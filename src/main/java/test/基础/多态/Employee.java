package test.基础.多态;

/**
 * @description:
 * @author: biankunpeng
 * @date: 2022/3/3 9:39
 */
// 员工对象
public abstract class Employee {

    private String name;
    private int id;
    private double salary;

    public Employee() {
    }

    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public abstract void work();

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", salary=" + salary +
                '}';
    }
}