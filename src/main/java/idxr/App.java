package idxr;

import com.beust.jcommander.JCommander;
import java.sql.Connection;

public class App
{
    public static void main(String[] argv)
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
            System.out.println("Executing parse");
            Db db = new Db("abc");
            Connection c = db.connect();
            break;
        default:
            System.out.printf("Invalid command: %s\n", args.cmd);
            break;
        }
    }
}

