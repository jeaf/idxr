package idxr;

import java.util.stream.*;

public abstract class Source
{
    public abstract Stream<Document> getDocuments() throws Exception;
}

