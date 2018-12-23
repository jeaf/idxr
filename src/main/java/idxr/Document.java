package idxr;

import java.util.*;
import static net.gcardone.junidecode.Junidecode.*;

public abstract class Document
{
    public abstract IndexData index() throws Exception;

    public static Map<String, Integer> indexText(String text)
    {
        Hashtable<String, Integer> h = new Hashtable<String, Integer>();
        String[] toks = flatten(text).split("\\s");
        for (String tok: toks)
        {
            tok = tok.strip();
            if (tok.length() > 1) h.merge(tok, 1, Integer::sum);
        }
        return h;
    }

    /**
     * Reduces a string to a limited set of ascii chars by applying the
     * following actions:
     * <ul>
     *     <li>Convert to lower case</li>
     *     <li>Replace non ascii unicode characters with their equivalent.
     *         For example, é is replaced with e. This conversion is done with
     *         the junidecode package
     *         (https://github.com/gcardone/junidecode).</li>
     *     <li>Replace unsupported characters with spaces (e.g., =)</li>
     * </ul>
     */
    public static String flatten(String s)
    {
        s = unidecode(s.toLowerCase());
        StringBuilder sb = new StringBuilder();
        for (char c: s.toCharArray())
        {
            final boolean isLetter     = (c >= 'a' && c <= 'z');
            final boolean isDigit      = (c >= '0' && c <= '9');
            final boolean isUnderscore = (c == '_');
            if (isLetter || isDigit || isUnderscore) sb.append(c);
            else sb.append(' ');
        }
        return new String(sb);
    }
}

