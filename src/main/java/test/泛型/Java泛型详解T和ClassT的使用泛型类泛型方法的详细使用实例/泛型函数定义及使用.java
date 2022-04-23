package test.泛型.Java泛型详解T和ClassT的使用泛型类泛型方法的详细使用实例;

import com.alibaba.fastjson.JSON;

import java.util.List;
//https://www.cnblogs.com/jpfss/p/9928747.html
public class 泛型函数定义及使用 {

    // 静态函数
    public static <T> void StaticMethod(T a){
        System.out.println("kemp StaticMethod\t" + a.toString());
    }

    // 普通函数
    public <T> void OtherMethod(T a){
        System.out.println("kemp OtherMethod\t" + a.toString());
    }

    @Override
    public String toString() {
        return "泛型函数定义及使用{}";
    }

    public static <T> List<T> parseArray(String response, Class<T> object){
        List<T> modelList = JSON.parseArray(response, object);
        return modelList;
    }

    public static void main(String[] args) {
        //静态方法
        泛型函数定义及使用.StaticMethod("adfdsa"); // 使用方法一
        泛型函数定义及使用.<String>StaticMethod("adfdsa"); // 使用方法二

        //常规方法
        泛型函数定义及使用 conventianalMethod = new 泛型函数定义及使用();
        conventianalMethod.OtherMethod(new Integer(123)); // 使用方法一
        conventianalMethod.<Integer>OtherMethod(new Integer(456)); // 使用方法二
    }
}
