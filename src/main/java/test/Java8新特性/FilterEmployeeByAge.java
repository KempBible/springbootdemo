package test.Java8新特性;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilterEmployeeByAge implements MyPredicate<Employee> {

    @Override
    public boolean filter(Employee employee) {
        return employee.getSalary() >= 5000;
    }

    public static List<Employee> filterEmployee(List<Employee> list, MyPredicate<Employee> myPredicate) {
        List<Employee> employees = new ArrayList<>();
        for (Employee e : list) {
            if (myPredicate.filter(e)) {
                employees.add(e);
            }
        }
        return employees;
    }

    protected static List<Employee> employees = Arrays.asList(
            new Employee("张三", 18, 9999.99),
            new Employee("李四", 38, 5555.55),
            new Employee("王五", 60, 6666.66),
            new Employee("赵六", 16, 7777.77),
            new Employee("田七", 18, 3333.33)
    );

    public static void test6() {
        List<Employee> employeeList = filterEmployee(employees, new MyPredicate<Employee>() {
            @Override
            public boolean filter(Employee employee) {
                return employee.getAge() >= 30;
            }
        });
        for (Employee e : employeeList) {
            System.out.println(e);
        }
    }

    public static void test7() {
        List<Employee> employeeList = filterEmployee(employees, new MyPredicate<Employee>() {
            @Override
            public boolean filter(Employee employee) {
                return employee.getSalary() >= 5000;
            }
        });

        for (Employee e : employeeList) {
            System.out.println(e);
        }
    }

    public static void test8() {
        filterEmployee(employees, (e) -> e.getAge() >= 30).forEach(System.out::println);
    }

    public static void test9() {
        filterEmployee(employees, (e) -> e.getSalary() >= 5000).forEach(System.out::println);
    }

    public static void test10() {
        employees.stream().filter(employee -> employee.getSalary() >= 5000).forEach(System.out::println);
    }

    public static void test11() {
        employees.stream().filter(employee -> employee.getSalary() >= 5000).limit(10).forEach(System.out::println);
    }

    public static void test12() {
        employees.stream().filter(employee -> employee.getSalary() >= 5000).map(Employee::getName).forEach(System.out::println);
    }

    public static void main(String[] args) {
        test12();
    }
}
