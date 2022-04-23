package test.基础;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * @description:
 * @author: biankunpeng
 * @date: 2022/3/11 19:17
 */
public class 获取Java文件的路径 {

    @Test
    public void writeToFile() throws IOException {
        /**
         * 获取项目的路径
         */
        // 1st projectPath==D:\workspace\springbootdemo
        String projectPath = System.getProperty("user.dir");
        System.out.println("projectPath==" + projectPath);

        // 2nd projectPath2==D:\workspace\springbootdemo
        File dir = new File("");// 参数为空
        String projectPath2 = dir.getCanonicalPath();
        System.out.println("projectPath2==" + projectPath2);

        // 获取java class文件地址
        File f = new File(this.getClass().getResource("/").getPath());
        System.out.println(f);
        // 获取java class文件地址
        File f1 = new File(this.getClass().getResource("").getPath());
        System.out.println(f1);

        URL xmlpath = this.getClass().getClassLoader().getResource("获取Java文件的路径.java");
        System.out.println(xmlpath);

        System.out.println(System.getProperty("java.class.path"));
    }
}