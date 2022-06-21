package test.hutool;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.CharsetUtil;
import org.junit.jupiter.api.Test;

/**
 * @description:
 * @author: biankunpeng
 * @date: 2022/6/20 21:26
 */
//https://blog.csdn.net/weixin_43888891/article/details/122464734
public class Main {

    @Test
    public void test() {
        String result = FileUtil.readString("D:\\workspace\\springbootdemo\\src\\main\\java\\test\\hutool\\Main.java",
                CharsetUtil.charset("UTF-8"));
        System.out.println(result);
    }

    @Test
    public void isFile方法可以判断文件是否存在() {
        if (FileUtil.isFile("D:\\workspace\\springbootdemo\\src\\main\\java\\test\\hutool\\Main.java")) {
            System.out.println(123);
        }
    }

}