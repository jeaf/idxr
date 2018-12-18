import idxr.*;
import java.lang.*;
import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class TestDocument
{
    @Test
    public void test1()
    {
        String s = "abc def    AbC\nDEF dEf déf dèf dêf -,.!==2339i p";
        Map<String, Integer> m = Document.indexText(s);
        assertEquals(3, m.size());
        assertTrue(m.containsKey("abc"));
        assertEquals(Integer.valueOf(2), m.get("abc"));
        assertTrue(m.containsKey("def"));
        assertEquals(Integer.valueOf(6), m.get("def"));
        assertTrue(m.containsKey("2339i"));
        assertEquals(Integer.valueOf(1), m.get("2339i"));
    }
}

