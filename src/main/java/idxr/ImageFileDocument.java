package idxr;

import java.nio.file.*;

public class ImageFileDocument extends FileDocument
{
    public ImageFileDocument(Path p)
    {
        super(p);
    }

    public IndexData index() throws Exception
    {
        throw new RuntimeException("Not implemented");
    }
}


