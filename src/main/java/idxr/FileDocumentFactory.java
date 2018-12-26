package idxr;

import java.nio.file.*;
import java.util.*;
import org.apache.commons.io.FilenameUtils;

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
        String ext = FilenameUtils.getExtension(p.toString());
        if (Arrays.stream(imageExts).anyMatch(x -> x.equalsIgnoreCase(ext)))
        {
            return new ImageFileDocument(p);
        }
        else if (Arrays.stream(textExts).anyMatch(x -> x.equalsIgnoreCase(ext)))
        {
            return new TextFileDocument(p);
        }
        else if (Arrays.stream(videoExts).anyMatch(x -> x.equalsIgnoreCase(ext)))
        {
            return new VideoFileDocument(p);
        }

        return new BinaryFileDocument(p);
    }

    private String[] imageExts;
    private String[] textExts;
    private String[] videoExts;
}

