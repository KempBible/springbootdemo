package test.hutool.IO流相关;

import cn.hutool.core.io.resource.ClassPathResource;
import cn.hutool.core.lang.Console;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Properties;

public class ClassPath资源访问ClassPathResource {

    @Test
    public void 由来() throws IOException {
        String path = "/Users/kemp/IdeaProjects/springbootdemo/src/main/resources/application.properties-old";
    }

    @Test
    public void 封装() throws IOException {
        ClassPathResource resource = new ClassPathResource("application.properties-old");
        System.out.println(resource);
        Properties properties = new Properties();
        properties.load(resource.getStream());
        Console.log("Properties:{}", properties);
    }
}
