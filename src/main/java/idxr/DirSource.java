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
        
        return Files.walk(path).filter(p -> Files.isRegularFile(p))
                               .map   (p -> new FileDocument(p)   );
    }

    private Path path;
}

