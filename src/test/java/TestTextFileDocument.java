import idxr.*;
import java.math.*;
import java.nio.file.*;
import java.security.*;
import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class TestTextFileDocument
{
    @Test
    public void testBinaryFileMd5() throws Exception
    {
        ClassLoader loader = getClass().getClassLoader();
        Path f = Paths.get(loader.getResource("testdir1/small.txt").toURI());
        byte[] buf = Files.readAllBytes(f);
        assertEquals( 3, buf.length);
        assertEquals(97, buf[0]);
        assertEquals(13, buf[1]);
        assertEquals(10, buf[2]);
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] md5 = md.digest(buf);
        String expected = "933222b19ff3e7ea5f65517ea1f7d57e";
        String actual = String.format("%032x", new BigInteger(1, md5));
        assertEquals(expected, actual);
    }

    @Test
    public void test1() throws Exception
    {
        ClassLoader loader = getClass().getClassLoader();
        Path f = Paths.get(loader.getResource("testdir1/small.txt").toURI());
        Document d = new TextFileDocument(f);
        IndexData idxDat = d.index();
        byte[] expectedMd5 = Util.hexStringToByteArray("933222b19ff3e7ea5f65517ea1f7d57e");
        assertArrayEquals(expectedMd5, idxDat.md5);
    }
}

