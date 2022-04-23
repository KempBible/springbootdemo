package test.Java8新特性;


import java.util.Comparator;
import java.util.TreeSet;
import java.util.function.Consumer;

public class Java8新特性Lambda表达式基础语法 {

    public static void test() {
        TreeSet<Integer> ts = new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        });
        ts.add(4);
        ts.add(1);
        ts.add(9);
        System.out.println(ts);
    }

    public static void test2() {
        Consumer<String> consumer = x -> System.out.println(x);
        consumer.accept("Hello World");
    }

    public static void test4() {
        Comparator<Integer> comparator = (x, y) -> {
            System.out.println("函数式接口");
            return Integer.compare(x, y);
        };
    }

    public static String handleString(MyFunc<String> myFunc, String str) {
        return myFunc.getValue(str);
    }

    public static void test6() {
        String str = handleString((s) -> s.toUpperCase(), "binghe");
        System.out.println(str);
    }

    public static void test7() {
        String str = handleString(s -> s.substring(0, 4), "binghe");
        System.out.println(str);
    }

    public static void main(String[] args) {
        test7();
    }
}
