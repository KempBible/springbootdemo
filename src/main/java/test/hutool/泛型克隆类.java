package test.hutool;

import cn.hutool.core.clone.CloneSupport;
import cn.hutool.core.util.ObjectUtil;

import java.io.Serializable;

//https://www.hutool.cn/docs/#/core/%E5%85%8B%E9%9A%86/%E6%94%AF%E6%8C%81%E6%B3%9B%E5%9E%8B%E7%9A%84%E5%85%8B%E9%9A%86%E6%8E%A5%E5%8F%A3%E5%92%8C%E5%85%8B%E9%9A%86%E7%B1%BB?id=%e6%b3%9b%e5%9e%8b%e5%85%8b%e9%9a%86%e7%b1%bb
public class 泛型克隆类 implements Serializable {

    private static class Dog extends CloneSupport<Dog>{
        private String name = "wangwang";
        private int age = 3;
    }

    public void test(Object obj){
        ObjectUtil.cloneByStream(obj);
    }

}
