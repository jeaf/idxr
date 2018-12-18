package idxr;

import java.nio.file.*;

public class FileDocument extends Document
{
    public FileDocument(Path p)
    {
        path = p;
    }

    public String toString()
    {
        return path.toString();
    }

    private Path path;
}

