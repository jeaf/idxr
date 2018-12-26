package idxr;

import java.security.*;

public class Util
{
    public static byte[] hexStringToByteArray(String hex)
    {
        if (hex.length() % 2 != 0)
        {
            throw new RuntimeException("Invalid hex string length");
        }
        if (hex.startsWith("0x"))
        {
            hex = hex.substring(2);
        }
        byte[] b = new byte[hex.length() / 2];
        for (int i = 0; i < b.length; ++i)
        {
            b[i] = (byte)Integer.parseInt(hex.substring(i*2, i*2 + 2), 16);
        }
        return b;
    }

    public static byte[] getMd5(byte[] buf) throws Exception
    {
        byte[] hexMd5 = MessageDigest.getInstance("MD5").digest(buf);
        return hexMd5;
    }
}

