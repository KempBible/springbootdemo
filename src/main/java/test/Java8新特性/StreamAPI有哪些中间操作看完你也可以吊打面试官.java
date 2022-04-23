package test.Java8新特性;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @description:
 * @author: biankunpeng
 * @date: 2022/2/15 18:26
 */
public class StreamAPI有哪些中间操作看完你也可以吊打面试官 {


    public static void main(String[] args) {
        List<Employee> list = Arrays.asList(
                new Employee("张三", 18, 9999.99),
                new Employee("李四", 38, 5555.55),
                new Employee("王五", 60, 6666.66),
                new Employee("赵六", 8, 7777.77),
                new Employee("田七", 58, 3333.33),
                new Employee("田七", 58, 3333.33)
        );
        Stream<Employee> stream = list.stream().filter((e) -> {
            System.out.println("Stream API 中间操作");
            return e.age > 30;
        });

        stream.limit(5).forEach(e -> {
                    System.out.println(e.toString());
                }
        );

        System.out.println("---------------------------------");
        Iterator<Employee> it = list.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        System.out.println("********************************");
        list.stream().filter((e) -> e.getAge() > 30).limit(2).forEach(System.out::println);

        System.out.println("++++++++++++++++++++++++++++++++");
        list.stream().skip(2).forEach(System.out::println);

        System.out.println("////////////////////////////////");
        list.stream().distinct().forEach(System.out::println);

        System.out.println();
        //将流中每一个元素都映射到map的函数中，每个元素执行这个函数，再返回
        List<String> list1 = Arrays.asList("aaa", "bbb", "ccc", "ddd");
        list1.stream().map(e -> e.toUpperCase()).forEach(System.out::println);

        // 映射
        List<String> names = list.stream().map(employee -> employee.getName()).collect(Collectors.toList());
        System.out.println(names);

        testFlatMap();

        System.out.println("999999999999999999999999999999999");
        // 自然排序
        List<Employee> person = list.stream().sorted().collect(Collectors.toList());
        System.out.println(person);

        list.stream().sorted((e1, e2) -> {
            if (e1.getAge() == e2.getAge()) {
                return 0;
            } else if (e1.getAge() > e2.getAge()) {
                return 1;
            } else {
                return -1;
            }
        }).forEach(System.out::println);
    }

    // 映射
    public static void testFlatMap() {
        List<String> list = Arrays.asList("aaa", "bbb", "ccc", "ddd");
        list.stream().flatMap((e) -> filterCharacter(e)).forEach(System.out::print);
    }

    public static Stream<Character> filterCharacter(String str) {
        List<Character> list = new ArrayList<>();
        for (Character ch : str.toCharArray()) {
            list.add(ch);
        }
        return list.stream();
    }

}