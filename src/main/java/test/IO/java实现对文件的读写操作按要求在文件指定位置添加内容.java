package test.IO;

import java.io.*;
import java.util.Random;

/**
 * @description:
 * @author: biankunpeng
 * @date: 2022/3/9 20:06
 */
// https://blog.csdn.net/qq_36509592/article/details/80759668
public class java实现对文件的读写操作按要求在文件指定位置添加内容 {

    public static void main(String[] args) {
        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader bReader = null;
        OutputStreamWriter osw = null;
        FileOutputStream fos = null;
        BufferedWriter bWriter = null;
        try {
            int rand;
            String line;
            StringBuffer stringBuffer;
            fis = new FileInputStream("D:\\workspace\\springbootdemo\\src\\main\\java\\test\\IO\\text.txt"); // 定义输入文件
            fos = new FileOutputStream("D:\\workspace\\springbootdemo\\src\\main\\java\\test\\IO\\text1.txt"); // 定义输出文件
            isr = new InputStreamReader(fis); // 读取输入文件
            osw = new OutputStreamWriter(fos); // 写入输入文件
            bReader = new BufferedReader(isr); // 读取缓冲区
            bWriter = new BufferedWriter(osw); // 写入缓存区
            String[] city = {"重庆", "上海", "北京", "黑龙江", "四川", "湖南", "新疆", "哈尔滨"}; //定义需要加入的内容,这里就随便写几个为例了
            while ((line = bReader.readLine()) != null) { //按行读取数据
                rand = new Random().nextInt(8); // 生成随机数
                System.out.println(rand);
                String aString = line + "\t" + city[rand] + "\n";
                //stringBuffer = new StringBuffer();//新建一个字符串缓冲区
                //aString =stringBuffer.append(line+"\t").append(city[rand]).toString();
                System.out.println(aString); //输出拼接结果
                bWriter.write(aString); //将拼结果按行写入出入文件中
            }
        } catch (FileNotFoundException e) {
            System.out.println("找不到文件");
        } catch (IOException e) {
            System.out.println("读取文件失败");
        } finally {
            try {
                bReader.close(); // 关闭读取缓冲区
                isr.close(); // 关闭读取文件内容
                fis.close(); // 关闭读取文件
                bWriter.close(); // 关闭写入缓存区
                osw.close(); //关闭写入文件内容
                fos.close(); //关闭写入文件
            } catch (IOException e) {
                // TODO: handle exception
                e.printStackTrace();
            }
        }
    }
}