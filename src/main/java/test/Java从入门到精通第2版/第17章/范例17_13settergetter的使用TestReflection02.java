package test.Java从入门到精通第2版.第17章;

//https://weread.qq.com/web/reader/34332dd05b1f6e3431a8f7ck98f3284021498f137082c2e

import java.lang.reflect.Method;

class Book13{
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

public class 范例17_13settergetter的使用TestReflection02 {
    public static void main(String[] args) throws Exception {
        String filedName = "title"; //要操作的属性
        String titleValue = "Java开发实战经典";
        Class<?> cls = Class.forName("test.Java从入门到精通第2版.第17章.Book13"); //产生对象可以分配对内存
        Object obj = cls.newInstance();//产生对象可以分配堆内存

        Method setMethod = cls.getMethod("set" + initcap(filedName), String.class);
        setMethod.invoke(obj, titleValue);

        Method getMethod = cls.getMethod("get" + initcap(filedName));
        System.out.println(getMethod.getName());
        System.out.println(getMethod.invoke(obj)); //对象.getTitle()调用
    }

    private static String initcap(String filedName) {
        return filedName.substring(0,1).toUpperCase() + filedName.substring(1);
    }
}
