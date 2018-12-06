package idxr;

import com.beust.jcommander.Parameter;
import java.util.*;

public class CmdLineArgs
{
    @Parameter(description = "Command to run", required = true)
    public String cmd;

    @Parameter(names = "--help", help = true)
    public boolean help = false;
}

