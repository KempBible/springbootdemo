package test.基础.多态;

/**
 * @description:
 * @author: biankunpeng
 * @date: 2022/3/3 9:47
 */
// 普通员工继承员工对象
public class CommonEmployee extends Employee {

    @Override
    public void work() {
        System.out.println("流水线");
    }
}