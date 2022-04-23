package test.IO;

import java.io.*;

/**
 * @description:
 * @author: biankunpeng
 * @date: 2022/3/9 19:46
 */
// https://m.runoob.com/java/java-filereader.html
public class JavaFileReader类 {
    public static void main(String[] args) throws IOException {
        Reader reader = new FileReader(System.getProperty("user.dir") + "/src/main/java/test/IO/JavaFileReader类.java");
        Writer writer = new FileWriter(System.getProperty("user.dir") + "/src/main/java/test/IO/JavaFileReader类2.java");
        writer.write(reader.read());

        File file = new File(System.getProperty("user.dir") + "/src/main/java/test/IO/JavaFileReader类3.java");
        // 创建文件
        file.createNewFile();
        // creates a FileWriter Object
        FileWriter write1 = new FileWriter(file);
        // 向文件写入内容
        write1.write("This\\n is\\n an\\n example\\n");
        write1.flush();
        write1.close();
        // 创建 FileReader 对象
        FileReader fr = new FileReader(file);
        char[] a = new char[50];
        fr.read(a);
        for (char c : a) {
            System.out.println(c);
        }
        fr.close();
    }
}