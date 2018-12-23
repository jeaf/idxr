package idxr;

import java.nio.file.*;

public class VideoFileDocument extends FileDocument
{
    public VideoFileDocument(Path p)
    {
        super(p);
    }

    public IndexData index() throws Exception
    {
        throw new RuntimeException("Not implemented");
    }
}


