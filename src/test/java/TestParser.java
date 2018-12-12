import idxr.*;
import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class TestParser
{
    @Test
    public void test1()
    {
        Parser p = new Parser();
        Map<String, Integer> m = p.parse("abc def AbC DEF dEf d�f d�f d�f");
        assertEquals(2, m.size());
    }
}

