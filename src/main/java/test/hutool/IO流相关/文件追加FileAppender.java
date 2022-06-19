package test.hutool.IO流相关;

import cn.hutool.core.io.file.FileAppender;
import org.junit.jupiter.api.Test;

import java.io.File;

public class 文件追加FileAppender {

    @Test
    public void 使用(){
        File file = new File("/Users/kemp/IdeaProjects/springbootdemo/src/main/java/test/hutool/IO流相关/test.properties");
        FileAppender appender = new FileAppender(file, 16, true);
        appender.append("123");
        appender.append("abc");
        appender.append("xyz");

        appender.flush();
        appender.toString();
    }
}
