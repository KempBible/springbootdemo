package test.Java8新特性;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Java8新特性还没搞懂函数式接口赶快过来看看吧 {

    public static void handlerConsumer(Integer number, Consumer<Integer> consumer) {
        consumer.accept(number);
    }

    public static void test1() {
        handlerConsumer(10000, (i) -> System.out.println(i));
    }

    public static List<Integer> getNumberList(int num, Supplier<Integer> supplier) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            list.add(supplier.get());
        }
        return list;
    }

    public static void test2() {
        List<Integer> numberList = getNumberList(10, () -> new Random().nextInt(100));
        numberList.stream().forEach(System.out::println);
    }

    public static String handlerString(String str, Function<String, String> func) {
        return func.apply(str);
    }

    public static void test3() {
        String str = handlerString("binghe", (s) -> s.toUpperCase());
        System.out.println(str);
    }

    public static List<String> filterString(List<String> list, Predicate<String> predicate) {
        List<String> strList = new ArrayList<>();
        for (String str : list) {
            if (predicate.test(str)) {
                strList.add(str);
            }
        }
        return strList;
    }

    public static void test4() {
        List<String> list = Arrays.asList("Hello", "Lambda", "binghe", "lyz", "World");
        List<String> strList = filterString(list, (s) -> s.length() >= 5);
        strList.stream().forEach(System.out::println);
    }

    public static void main(String[] args) {
//        test1();
//        test2();
//        test3();
        test4();
    }
}
