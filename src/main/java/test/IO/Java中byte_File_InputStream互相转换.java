package test.IO;

import java.io.*;

// https://www.cnblogs.com/xiaohu1218/p/7881312.html
// java 中 byte[]、File、InputStream 互相转换
public class Java中byte_File_InputStream互相转换 {
    public static void main(String[] args) throws IOException {
        // 1、将File、FileInputStream 转换为byte数组：
        File file = new File("/Users/kemp/IdeaProjects/springbootdemo/src/main/java/test/IO/text.txt");
        InputStream inputStream = new FileInputStream(file);
        byte[] bytes = new byte[inputStream.available()];
        inputStream.read(bytes);

        // 2、将byte数组转换为InputStream：
        byte[] bytes1 = new byte[1024];
        InputStream inputStream1 = new ByteArrayInputStream(bytes);

        // 3、将byte数组转换为File：
        File file1 = new File("/Users/kemp/IdeaProjects/springbootdemo/src/main/java/test/IO/text.txt");
        OutputStream outputStream = new FileOutputStream(file1);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
        bufferedOutputStream.write(bytes1);
    }
}
