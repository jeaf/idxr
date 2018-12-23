package idxr;

import java.nio.file.*;
import java.util.*;

public class FileDocumentFactory
{
    public FileDocumentFactory()
    {
        imageExts = new String[]{"jpeg", "jpg", "gif"};
        textExts  = new String[]{"txt"};
        videoExts = new String[]{"webm"};
    }

    public FileDocument create(Path p)
    {
        String ext = ""/*p.getExt()*/;
        if (Arrays.stream(imageExts).anyMatch(x -> x.equalsIgnoreCase(ext)))
        {
        }
        //else if ()
        //{
        //}
        //else if ()
        //{
        //}

        return new BinaryFileDocument(p);
    }

    private String[] imageExts;
    private String[] textExts;
    private String[] videoExts;
}

