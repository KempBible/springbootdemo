package test.hutool.IO流相关;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.file.FileNameUtil;
import org.junit.jupiter.api.Test;

import java.io.File;

public class 文件名工具FileNameUtil {

    @Test
    public void 获取文件名(){
        File file = FileUtil.file("/Users/kemp/IdeaProjects/springbootdemo/src/main/java/test/hutool/IO流相关/test.properties");
        //test.properties
        String name = FileNameUtil.getName(file);
        System.out.println(name);
    }

    @Test
    public void 获取主文件名和扩展名(){
        File file = FileUtil.file("/Users/kemp/IdeaProjects/springbootdemo/src/main/java/test/hutool/IO流相关/test.properties");

        //test
        String name1 = FileNameUtil.mainName(file);
        System.out.println(name1);
        //test
        String name3 = FileNameUtil.getPrefix(file);
        System.out.println(name3);

        //properties
        String name2 = FileNameUtil.extName(file);
        System.out.println(name2);
        //properties
        String name4 = FileNameUtil.getSuffix(file);
        System.out.println(name4);
    }
}
