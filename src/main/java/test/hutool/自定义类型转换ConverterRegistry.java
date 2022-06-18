package test.hutool;

import cn.hutool.core.convert.Converter;
import cn.hutool.core.convert.ConverterRegistry;
import com.sun.tools.javac.util.Assert;
import com.sun.tools.javac.util.StringUtils;
import org.junit.jupiter.api.Test;

//https://www.hutool.cn/docs/#/core/%E7%B1%BB%E5%9E%8B%E8%BD%AC%E6%8D%A2/%E8%87%AA%E5%AE%9A%E4%B9%89%E7%B1%BB%E5%9E%8B%E8%BD%AC%E6%8D%A2-ConverterRegistry
public class 自定义类型转换ConverterRegistry {

    @Test
    public void 解决(){
        int a = 3423;
        ConverterRegistry converterRegistry = ConverterRegistry.getInstance();
        String result = converterRegistry.convert(String.class, a);
        System.out.println("3423" == result);
    }

    //2.注册转换器
    @Test
    public void 注册转换器(){
        ConverterRegistry converterRegistry = ConverterRegistry.getInstance();
        //此处做为示例自定义String转换，因为Hutool中已经提供String转换，请尽量不要替换
        //替换可能引发关联转换异常（例如覆盖String转换会影响全局）
        converterRegistry.putCustom(String.class, CustomConverter.class);

        //3.执行转换
        int a = 454553;
        String result = converterRegistry.convert(String.class, a);
        System.out.println(result);
        System.out.println(result instanceof String);
    }


    public void 执行转换(){

    }

}

//1.自定义转换器
class CustomConverter implements Converter<String> {

    @Override
    public String convert(Object value, String defaultValue) throws IllegalArgumentException {
        return "Custom" + value.toString();
    }
}

