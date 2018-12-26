package idxr;

import java.nio.file.*;
import org.apache.commons.io.FileUtils;

public class TextFileDocument extends FileDocument
{
    public TextFileDocument(Path p)
    {
        super(p);
    }

    public IndexData index() throws Exception
    {
        IndexData idxDat = new IndexData();
        String text = FileUtils.readFileToString(path.toFile());
        idxDat.textIdx = indexText(text);
        idxDat.pathIdx = indexText(path.toString());
        idxDat.md5 = Util.getMd5(Files.readAllBytes(path));
        return idxDat;
    }
}

