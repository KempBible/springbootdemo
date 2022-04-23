package test.基础.多态;

/**
 * @description:
 * @author: biankunpeng
 * @date: 2022/3/3 9:45
 */
// 管理者继承员工对象
public class Manager extends Employee {

    private double bonus;

    public Manager() {

    }

    public Manager(String name, int id, double salary, double bonus) {
        super(name, id, salary);
        this.bonus = bonus;
    }

    @Override
    public void work() {
        System.out.println("管理工作");
    }

    @Override
    public String toString() {
        return "Manager{" + super.toString() +
                "bonus=" + bonus +
                "} ";
    }
}