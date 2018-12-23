package idxr;

import java.io.*;
import java.nio.file.*;
import java.security.*;

public class BinaryFileDocument extends FileDocument
{
    public BinaryFileDocument(Path p)
    {
        super(p);
    }

    public IndexData index() throws Exception
    {
        IndexData dat = new IndexData();
        MessageDigest md = MessageDigest.getInstance("MD5");
        try (InputStream is = Files.newInputStream(path);
             DigestInputStream dis = new DigestInputStream(is, md)) 
        {
            dis.read();
        }
        dat.md5 = md.digest();
        return dat;
    }
}

