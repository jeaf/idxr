package idxr;

import java.nio.file.*;

public class TextFileDocument extends FileDocument
{
    public TextFileDocument(Path p)
    {
        super(p);
    }

    public IndexData index() throws Exception
    {
        throw new RuntimeException("Not implemented");
    }
}

