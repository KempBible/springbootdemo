package test.泛型.Java泛型详解T和ClassT的使用泛型类泛型方法的详细使用实例;

import com.alibaba.fastjson.JSON;

import java.util.List;

// https://www.cnblogs.com/jpfss/p/9928747.html
public class 其它用法ClassT类传递及泛型数组_1_使用ClassT传递泛型类Class对象 {

    public static List<SuccessModel> parseArray(String respense){
        List<SuccessModel> modelList = JSON.parseArray(respense, SuccessModel.class);
        return modelList;
    }

    public static <T> List<T> parseArray1(String respense, Class<T> object){
        List<T> modelList = JSON.parseArray(respense, object);
        return modelList;
    }
}

