package idxr;

import java.util.*;
import static net.gcardone.junidecode.Junidecode.*;

public class Parser
{
    public Map<String, Integer> parse(String text)
    {
        Hashtable<String, Integer> h = new Hashtable<String, Integer>();
        text = text.toLowerCase();
        text = unidecode(text);
        String[] toks = text.split("\\s");
        for (String tok: toks)
        {
            h.put(tok, 0);
        }
        return h;
    }
}

