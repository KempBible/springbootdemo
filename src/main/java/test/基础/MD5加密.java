package test.基础;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * @description:
 * @author: biankunpeng
 * @date: 2022/3/11 13:41
 */
public class MD5加密 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString("String".getBytes()));
    }

    private static byte[] getMD5Bytes(byte[] content) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            return md5.digest(content);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}