import idxr.*;
import java.net.*;
import java.nio.file.*;
import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class TestDirSource
{
    @Test
    public void test1() throws Exception
    {
        ClassLoader loader = getClass().getClassLoader();
        Path f = Paths.get(loader.getResource("testdir1/abc def.txt").toURI());
        Source s = new DirSource(f.getParent());
        Document[] docs = s.getDocuments().toArray(Document[]::new);
        assertEquals(6, docs.length);
        Map<String, Integer> types = new Hashtable<String, Integer>();
        for (Document doc : docs)
        {
            types.merge(doc.getClass().getName(), 1, Integer::sum);
        }
        assertEquals(Integer.valueOf(1), types.get("idxr.BinaryFileDocument"));
        assertEquals(Integer.valueOf(2), types.get("idxr.ImageFileDocument"));
        assertEquals(Integer.valueOf(2), types.get("idxr.TextFileDocument"));
        assertEquals(Integer.valueOf(1), types.get("idxr.VideoFileDocument"));
    }
}

