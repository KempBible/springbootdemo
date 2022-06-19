package test.hutool.IO流相关;

import cn.hutool.core.io.FileTypeUtil;
import cn.hutool.core.io.FileUtil;
import org.junit.jupiter.api.Test;

import java.io.File;

public class 文件类型判断FileTypeUtil {

    @Test
    public void 使用(){
        File file = FileUtil.file("/Users/kemp/IdeaProjects/springbootdemo/src/main/java/test/hutool/Test_IO工具类IoUtil.java");
        System.out.println(file);

        String type = FileTypeUtil.getType(file);
        //输出 java则说明确实为java文件
        System.out.println(type);
    }
}
