package test.hutool.IO流相关;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IoUtil;
import org.junit.jupiter.api.Test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;

public class IO工具类IoUtil {

    @Test
    public void 拷贝(){
        BufferedInputStream in =
                FileUtil.getInputStream("/Users/kemp/IdeaProjects/springbootdemo/src/main/java/test/hutool/IO工具类IoUtil.java");
        BufferedOutputStream out =
                FileUtil.getOutputStream("/Users/kemp/IdeaProjects/springbootdemo/src/main/java/test/hutool/Test_IO工具类IoUtil.java");
        long copySize = IoUtil.copy(in, out, IoUtil.DEFAULT_BUFFER_SIZE);
        System.out.println(copySize);
    }
}
