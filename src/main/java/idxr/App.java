package idxr;

import com.beust.jcommander.JCommander;
import java.nio.file.*;
import java.sql.Connection;
import java.util.logging.*;

public class App
{
    public static void main(String[] argv)
    {
        try
        {
            CmdLineArgs args = new CmdLineArgs();
            JCommander jc = new JCommander(args);
            jc.setProgramName("idxr");
            jc.parse(argv);

            if (args.help)
            {
                jc.usage();
                return;
            }

            switch (args.cmd)
            {
            case "parse":
                log.info(String.format("Executing parse, db: %s, src: %s",
                                       args.dbPath, args.src));
                if (args.src == null)
                {
                    throw new RuntimeException("The src argument is required " +
                                               "for the parse command");
                }
                Path src = Path.of(args.src);
                if (!Files.exists(src))
                {
                    throw new RuntimeException(
                        String.format("Source doesn't exist: %s", src));
                }
                Db db = new Db(args.dbPath);
                Connection c = db.connect();
                break;
            default:
                System.out.printf("Invalid command: %s\n", args.cmd);
                break;
            }
        }
        catch (Throwable ex)
        {
            log.log(Level.SEVERE, "Exception thrown", ex);
        }
    }

    private final static Logger log = Logger.getLogger(Db.class.getName());
}

