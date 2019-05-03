package com.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {
    public static String getMD5(String input) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            System.out.println("input: " + input.getBytes());
            messageDigest.update(input.getBytes());
            return new BigInteger(1, messageDigest.digest()).toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return input;
    }

    public static void main(String[] args) {
        String input = "hello world";
        System.out.println("result: " + MD5Util.getMD5(input));
    }
}
