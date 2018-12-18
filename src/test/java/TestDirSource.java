import idxr.*;
import java.nio.file.*;
import org.junit.*;
import static org.junit.Assert.*;

public class TestDirSource
{
    @Test
    public void test1() throws Exception
    {
        Source s = new DirSource(Path.of("abc"));
        for (Document d : s.getDocuments().toArray(Document[]::new))
        {
        }
    }
}


