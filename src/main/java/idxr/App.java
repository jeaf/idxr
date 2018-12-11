package idxr;

import com.beust.jcommander.JCommander;
import java.sql.Connection;
import java.util.logging.Logger;

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
                log.info(String.format("Executing parse, db: %s", args.dbPath));
                Db db = new Db("abc");
                Connection c = db.connect();
                break;
            default:
                System.out.printf("Invalid command: %s\n", args.cmd);
                break;
            }
        }
        catch (Exception ex)
        {
            log.severe(ex.getMessage());
        }
    }

    private final static Logger log = Logger.getLogger(Db.class.getName());
}

