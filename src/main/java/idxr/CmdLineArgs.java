package idxr;

import com.beust.jcommander.Parameter;
import java.io.File;
import java.util.*;

public class CmdLineArgs
{
    @Parameter(description = "Command to run", required = true)
    public String cmd;

    @Parameter(names = "--db", description = "DB file")
    public String dbPath = System.getProperty("user.home") + File.separator +
                           "idxr.db";

    @Parameter(names = "--src", description = "Documents source")
    public String src;

    @Parameter(names = "--help", help = true)
    public boolean help = false;
}

