package com.i18n;

import javax.xml.bind.DatatypeConverter;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;

/**
 * @author 212331901
 * @date 2019/7/11
 */
public class CharEncodeAndDecode {
    public static void main(String[] args) {
        String test = "a";
        try {
            byte[] bytes = test.getBytes("UTF-8");
            System.out.println((new BigInteger(1, bytes).toString(2)));
            System.out.println((new BigInteger(1, bytes).toString(16)));
            System.out.println(new String(bytes, StandardCharsets.ISO_8859_1));
            System.out.println(System.currentTimeMillis());
            System.out.println(Long.parseLong("F", 16));
            System.out.println(Integer.toBinaryString(128));
            System.out.println(Integer.toHexString(64));
            System.out.println(Integer.toOctalString(128));
            int hex = 0x1ef;
            int octal = 023;
            int binary = 0b1100001110101000;
            System.out.println(new BigInteger("1100001110101000", 2).toString(16));
            System.out.println(escapeNonAscii(test));

            String ehex = "c3a8";
            System.out.println(new String(DatatypeConverter.parseHexBinary(ehex), "UTF-8"));
            String ehex2 = "efbf83efbea7";
            System.out.println(new String(DatatypeConverter.parseHexBinary(ehex2), StandardCharsets.US_ASCII));

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public static String decodeHexString(String hexCode) {
        return new String(DatatypeConverter.parseHexBinary(hexCode), StandardCharsets.UTF_8);
    }

//    public static String decodeBinaryString(String binaryCode) {
//        return new String(new BigInteger(binaryCode, 2))
//    }

    public static String escapeNonAscii(String str) {

        StringBuilder retStr = new StringBuilder();
        for(int i=0; i<str.length(); i++) {
            int cp = Character.codePointAt(str, i);
            int charCount = Character.charCount(cp);
            if (charCount > 1) {
                i += charCount - 1; // 2.
                if (i >= str.length()) {
                    throw new IllegalArgumentException("truncated unexpectedly");
                }
            }

            if (cp < 128) {
                retStr.appendCodePoint(cp);
            } else {
                retStr.append(String.format("\\u%x", cp));
            }
        }
        return retStr.toString();
    }
}
