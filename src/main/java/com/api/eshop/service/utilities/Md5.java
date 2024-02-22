package com.api.eshop.service.utilities;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
/**
 * @author meisam mohamadi
 * @version 3.0
 */

public class Md5 {
    private String MD5;
    private String text;

    /**
     * @param text
     * @return boolean
     * @throws Exception
     */
    public boolean setContent(String text) throws Exception {
        this.text = text;
        this.MD5 = getMD5(text);

        return true;
    }

    /**
     * @return String
     * @throws Exception
     * @param inputText
     */
    public String getContent(String inputText) throws Exception {
        return this.text;
    }

    /**
     * @return String
     * @throws Exception
     */
    public String getMD5() throws Exception {
        return this.MD5;
    }
    //////////////////////////////////////////////////////////////
    private String convertToHex(byte[] data) throws Exception {
        StringBuffer buf = new StringBuffer();

        for (int i = 0; i < data.length; i++) {
            int halfbyte = (data[i] >>> 4) & 0x0F;
            int two_halfs = 0;

            do {
                if ((0 <= halfbyte) && (halfbyte <= 9)) {
                    buf.append((char) ('0' + halfbyte));
                } else {
                    buf.append((char) ('a' + (halfbyte - 10)));
                }

                halfbyte = data[i] & 0x0F;
            } while (two_halfs++ < 1);
        }

        return buf.toString();
    }

    private String getMD5(String text) throws Exception {
        MessageDigest md;
        md = MessageDigest.getInstance("MD5");

        byte[] md5hash = new byte[32];
        md.update(text.getBytes(StandardCharsets.ISO_8859_1), 0, text.length());
        md5hash = md.digest();

        return convertToHex(md5hash);
    }
    // my added method for make direct md5 from string
    public  String reciveMD5(String str)
    {
        try
        {
        MD5= getMD5(str);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return MD5;
    }




}
