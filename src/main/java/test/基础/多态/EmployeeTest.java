package test.基础.多态;

/**
 * @description:
 * @author: biankunpeng
 * @date: 2022/3/3 9:48
 */
// 测试员工 多态
public class EmployeeTest {

    public static void main(String[] args) {
        Employee employee1 = new Manager("kemp", 1, 100000.0, 1000000.1);

        System.out.print(employee1.toString());
        employee1.work();

        System.out.println("------------普通员工------------");
        Employee employee2 = new CommonEmployee();
        employee2.work();
    }
}