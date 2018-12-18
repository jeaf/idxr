package idxr;

import java.nio.file.*;
import java.util.stream.*;

public class DirSource extends Source
{
    public DirSource(Path p)
    {
        path = p;
    }

    public Stream<Document> getDocuments() throws Exception
    {
        return Files.walk(path).map((Path p) -> new FileDocument(p));
    }

    private Path path;
}

