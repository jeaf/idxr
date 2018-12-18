import idxr.*;
import java.net.*;
import java.nio.file.*;
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
        assertEquals(5, docs.length);
    }
}

