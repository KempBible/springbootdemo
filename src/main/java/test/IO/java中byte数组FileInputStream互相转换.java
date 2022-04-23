package test.IO;

import java.io.*;

/**
 * @description:
 * @author: biankunpeng
 * @date: 2022/3/9 14:06
 */
// https://www.cnblogs.com/xiaohu1218/p/7881312.html
public class java中byte数组FileInputStream互相转换 {
    public static void main(String[] args) throws IOException {
        String currentFolder = System.getProperty("user.dir") + "\\src\\main\\java\\test\\IO\\";
        // 1、将File、FileInputStream 转换为byte数组：
        File file1 = new File(currentFolder + "java中byte数组FileInputStream互相转换.java");
        InputStream inputStream = new FileInputStream(file1);
        byte[] byt1 = new byte[inputStream.available()];
        System.out.println(inputStream.read(byt1));

        // 2、将byte数组转换为InputStream：
        byte[] byt2 = new byte[1024];
        InputStream inputStream1 = new ByteArrayInputStream(byt2);
        System.out.println(inputStream1);

        // 3、将byte数组转换为File：
        File file3 = new File(currentFolder + "java中byte数组FileInputStream互相转换1.java");
        FileOutputStream fileOutputStream = new FileOutputStream(file3);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        bufferedOutputStream.write(byt1);
    }
}