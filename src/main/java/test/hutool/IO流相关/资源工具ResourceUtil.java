package test.hutool.IO流相关;

import cn.hutool.core.io.resource.ResourceUtil;
import org.junit.jupiter.api.Test;

public class 资源工具ResourceUtil {

    @Test
    public void 使用(){
        String str = ResourceUtil.readUtf8Str("test");
        System.out.println(str);
    }

    @Test
    public void 假设我们的文件存放在src_resources_config目录下则读取改为(){
        String str = ResourceUtil.readUtf8Str("/Users/kemp/IdeaProjects/springbootdemo/src/main/resources/application.properties-old");
        System.out.println(str);
    }

}
