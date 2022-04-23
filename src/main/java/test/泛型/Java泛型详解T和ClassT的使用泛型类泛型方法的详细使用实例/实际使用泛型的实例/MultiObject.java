package test.泛型.Java泛型详解T和ClassT的使用泛型类泛型方法的详细使用实例.实际使用泛型的实例;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.buf.UDecoder;

import java.util.List;
import java.util.stream.Collector;

// https://www.cnblogs.com/jpfss/p/9928747.html
@Data
@Slf4j
public class MultiObject<T> {

    /**
     * 成功状态
     */
    private boolean success;

    /**
     * 异常
     */
    private Exception ex;

    /**
     * 数据
     */
    private T obj;

    public MultiObject(){

    }

    /**
     * 注意：当传入的泛型是Boolean时，就和第三个构造函数冲突了。
     */
    public MultiObject(boolean success) {
        this.success = success;
    }

    public MultiObject(Exception ex){
        this.success = false;
        this.ex = ex;
    }

    public MultiObject(T value){
        this.success = true;
        this.obj = value;
    }

    public static <T> T parseJsonToObj(String json, Class<T> c){
        try {
            JSONObject jsonObject = JSON.parseObject(json);
            return JSON.toJavaObject(jsonObject, c);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    /**
     * @param dest   目的集合
     * @param source 源集合
     * @param <T>    集合参数的类型
     */
    public static <T> void listAddVoidNPE(List<T> dest, List<T> source){
        if (source == null){
            return;
        }
        dest.addAll(source);
    }

    private static <T> void listAddAvoidNull(List<T> dest, T source){
        if (source == null){
            return ;
        }
        dest.add(source);
    }

    public static void main(String[] args) {
        List<Object> list = Lists.newArrayList();
        listAddVoidNPE(list, null);
    }
}
