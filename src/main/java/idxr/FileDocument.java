package idxr;

import java.nio.file.*;

public abstract class FileDocument extends Document
{
    public FileDocument(Path p)
    {
        path = p;
    }

    public String toString()
    {
        return path.toString();
    }

    protected Path path;
}

