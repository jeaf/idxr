import idxr.*;
import org.junit.*;
import static org.junit.Assert.*;

public class TestUtil
{
    @Test
    public void testMd5() throws Exception
    {
        // Empty
        String exp = "d41d8cd98f00b204e9800998ecf8427e";
        byte[] h = Util.getMd5(Util.hexStringToByteArray(""));
        assertEquals(exp, Util.byteArrayToHexString(h));
    }

    @Test
    public void testByteArrayToHexString() throws Exception
    {
        byte[] b = {(byte)5, (byte)126, (byte)243};
        String exp = "057ef3";
        assertEquals(exp, Util.byteArrayToHexString(b));
    }

    @Test
    public void test1() throws Exception
    {
        byte[] b = Util.hexStringToByteArray("abcd");
        assertEquals(2, b.length);
        assertEquals((byte)171, b[0]);
        assertEquals((byte)205, b[1]);
    }

    @Test
    public void test2() throws Exception
    {
        byte[] b = Util.hexStringToByteArray("5cab966eca6eb5f7a7dde2a47ab577e7");
        assertEquals(16, b.length);
        assertEquals((byte) 92, b[ 0]);
        assertEquals((byte)171, b[ 1]);
        assertEquals((byte)150, b[ 2]);
        assertEquals((byte)167, b[ 8]);
        assertEquals((byte)231, b[15]);
    }

    @Test
    public void testMixedCase() throws Exception
    {
        byte[] b = Util.hexStringToByteArray("AbCD");
        assertEquals(2, b.length);
        assertEquals((byte)171, b[0]);
        assertEquals((byte)205, b[1]);
    }
}

