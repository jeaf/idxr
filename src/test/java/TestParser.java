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
        String s = "abc def    AbC\nDEF dEf déf dèf dêf -,.!==2339i p";
        Map<String, Integer> m = p.parse(s);
        assertEquals(3, m.size());
        assertTrue(m.containsKey("abc"));
        assertTrue(m.containsKey("def"));
        assertTrue(m.containsKey("2339i"));
    }
}

