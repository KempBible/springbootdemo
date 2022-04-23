package test.Java8新特性;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Java新特性Lambda表达式典型案例你想要的的都在这儿了 {

    static List<Employee> employees = Arrays.asList(
            new Employee("张三", 18, 9999.99),
            new Employee("李四", 38, 5555.55),
            new Employee("王五", 60, 6666.66),
            new Employee("赵六", 8, 7777.77),
            new Employee("田七", 58, 3333.33)
    );

    public static void test1() {
        Collections.sort(
                employees, (e1, e2) -> {
                    if (e1.getAge() == e2.getAge()) {
                        return -e1.getName().compareTo(e2.getName());
                    }
                    return -Integer.compare(e1.getAge(), e2.getAge());
                }
        );
        employees.stream().forEach(System.out::println);
    }

    public static String stringHandler(String str, MyFunction myFunction) {
        return myFunction.getValue(str);
    }

    public static void test2() {
        String value = stringHandler("binghe", (s) -> s.toUpperCase());
        System.out.println(value);
    }

    public static void test3() {
        String value = stringHandler("binghe", (s) -> s.substring(1, 3));
        System.out.println(value);
    }

    public static void operate(Long num1, Long num2, MyFunc4<Long, Long> myFunc4) {
        System.out.println(myFunc4.getValue(num1, num2));
    }

    public static void test4() {
        operate(100L, 200L, (x, y) -> x + y);
    }

    public static void test5() {
        operate(100L, 200L, (x, y) -> x * y);
    }

    public static void main(String[] args) {
        test5();
    }
}
