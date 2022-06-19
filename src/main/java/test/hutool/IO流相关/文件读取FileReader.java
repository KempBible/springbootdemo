package test.hutool.IO流相关;

import cn.hutool.core.io.file.FileReader;
import cn.hutool.core.util.ArrayUtil;
import org.junit.jupiter.api.Test;

import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.util.List;

public class 文件读取FileReader {

    @Test
    public void 使用() throws FileNotFoundException {
        //默认UTF-8编码，可以在构造中传入第二个参数做为编码
        FileReader fileReader = new FileReader("/Users/kemp/IdeaProjects/springbootdemo/src/main/java/test/hutool/IO流相关/test.properties");
        String result = fileReader.readString();
        System.out.println(result);
    }

    @Test
    public void BufferedReader() throws FileNotFoundException {
        //默认UTF-8编码，可以在构造中传入第二个参数做为编码
        FileReader fileReader = new FileReader("/Users/kemp/IdeaProjects/springbootdemo/src/main/java/test/hutool/IO流相关/test.properties");
        byte[] bytes = fileReader.readBytes();
        System.out.println(ArrayUtil.toString(bytes));

        List<String> result = fileReader.readLines();
        System.out.println(result);
    }
}
