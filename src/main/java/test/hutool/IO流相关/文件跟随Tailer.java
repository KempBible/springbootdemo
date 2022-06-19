package test.hutool.IO流相关;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.LineHandler;
import cn.hutool.core.io.file.Tailer;
import cn.hutool.core.lang.Console;
import org.junit.jupiter.api.Test;

public class 文件跟随Tailer {

    @Test
    public void 使用(){
        Tailer tailer = new Tailer(
                FileUtil.file("/Users/kemp/IdeaProjects/springbootdemo/src/main/java/test/hutool/IO流相关/test.properties"),
                Tailer.CONSOLE_HANDLER, 2);
        System.out.println(tailer);
    }

    /**
     * 命令行打印的行处理器
     *
     * @author looly
     * @since 4.5.2
     */
    public static class ConsoleLineHandler implements LineHandler{

        @Override
        public void handle(String line) {
            Console.log(line);
            System.out.println(line);
        }
    }
}
