package test.Java从入门到精通第2版.第11章;

public class 范例11_11_3通过代码测试上面实现的接口类型TestColor {
    public static void main(String[] args) {
        for (范例11_11_2对新建接口抽象方法的调用对接口中定义的抽象方法的调用并且在后期声明的枚举类型中任何一个对象都必须分别实现接口中的抽象方法NewColor2 c:
                范例11_11_2对新建接口抽象方法的调用对接口中定义的抽象方法的调用并且在后期声明的枚举类型中任何一个对象都必须分别实现接口中的抽象方法NewColor2.values()) {
            System.out.println(c.ordinal() + "\t" + c.name() + "\t" + c.getColor());
        }
    }
}

