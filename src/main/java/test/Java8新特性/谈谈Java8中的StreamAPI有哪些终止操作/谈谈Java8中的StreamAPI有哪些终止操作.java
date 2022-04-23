package test.Java8新特性.谈谈Java8中的StreamAPI有哪些终止操作;

import test.Java8新特性.StreamAPI有哪些中间操作看完你也可以吊打面试官;
import test.Java8新特性.谈谈Java8中的StreamAPI有哪些终止操作.Employee.Stauts;

import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: biankunpeng
 * @date: 2022/2/15 19:06
 */
public class 谈谈Java8中的StreamAPI有哪些终止操作 {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("张三", 18, 9999.99, Employee.Stauts.SLEEPING),
                new Employee("李四", 38, 5555.55, Employee.Stauts.WORKING),
                new Employee("王五", 60, 6666.66, Employee.Stauts.WORKING),
                new Employee("赵六", 8, 7777.77, Employee.Stauts.SLEEPING),
                new Employee("田七", 58, 3333.33, Employee.Stauts.VOCATION)
        );

        boolean match = employees.stream().allMatch((e) -> Stauts.SLEEPING.equals(e.getStauts()));
        System.out.println(match);
        boolean match1 = employees.stream().anyMatch((e) -> Stauts.SLEEPING.equals(e.getStauts()));
        System.out.println(match1);
        boolean match2 = employees.stream().noneMatch((e) -> Stauts.SLEEPING.equals(e.getStauts()));
        System.out.println(match2);

        Employee employee = employees.stream().filter((e) -> Stauts.SLEEPING.equals(e.getStauts())).findFirst().orElse(null);
        System.out.println(employee);

        Optional op = employees.stream().filter((e) -> Stauts.WORKING.equals(e.getStauts())).findAny();
        System.out.println(op.get());

        Long count = employees.stream().count();
        System.out.println(count);

        Optional<Employee> op1 = employees.stream().max((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
        System.out.println(op1.get());

        Optional<Double> op2 = employees.stream().map(Employee::getSalary).min(Double::compare);
        System.out.println(op2.get());

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer sum = list.stream().reduce(0, (x, y) -> x + y);
        System.out.println(sum);
        Integer sum0 = list.stream().reduce(Integer::sum).get();
        System.out.println(sum0);

        System.out.println("-----------------------------------------------");
        Optional<Double> op3 = employees.stream().map(Employee::getSalary).reduce(Double::sum);
        System.out.println(op3.get());

        Optional<Integer> sum1 = employees.stream().map(Employee::getName).flatMap(StreamAPI有哪些中间操作看完你也可以吊打面试官::filterCharacter).map((ch) -> {
            if (ch.equals('六')) {
                return 1;
            } else {
                return 0;
            }
        }).reduce(Integer::sum);
        System.out.println(sum1.get());

        System.out.println("111111111111111111111111111111111111111111111");
        Optional<Double> max = employees.stream().map(Employee::getSalary).collect(Collectors.maxBy(Double::compare));
        System.out.println(max.get());

        System.out.println("444444444444444444444444444444444444444444444");
        Optional<Employee> op4 = employees.stream().collect(Collectors.minBy((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary())));
        System.out.println(op4.get());

        Double sum2 = employees.stream().collect(Collectors.summingDouble(Employee::getSalary));
        System.out.println(sum2);

        Double avg = employees.stream().collect(Collectors.averagingDouble(Employee::getSalary));
        System.out.println(avg);

        Long count1 = employees.stream().collect(Collectors.counting());
        System.out.println(count1);

        DoubleSummaryStatistics dss = employees.stream().collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println(dss.getAverage());

        String str = employees.stream().map(Employee::getName).collect(Collectors.joining(" "));
        System.out.println(str);

        Optional<Double> max1 = employees.stream().map(Employee::getSalary).collect(Collectors.maxBy(Double::compare));
        System.out.println(max1.get());

        Optional<Employee> op5 = employees.stream().collect(Collectors.minBy((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary())));
        System.out.println(op5.get());

        Double sum3 = employees.stream().collect(Collectors.summingDouble(Employee::getSalary));
        System.out.println(sum3);

        Double avg1 = employees.stream().collect(Collectors.averagingDouble(Employee::getSalary));
        System.out.println(avg1);

        Long count2 = employees.stream().collect(Collectors.counting());
        System.out.println(count2);

        DoubleSummaryStatistics dss1 = employees.stream().collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println(dss.getMax());
    }


}
