package test.Java从入门到精通第2版.第11章;

public enum 范例11_11_2对新建接口抽象方法的调用对接口中定义的抽象方法的调用并且在后期声明的枚举类型中任何一个对象都必须分别实现接口中的抽象方法NewColor2 implements 范例11_11_1创建枚举接口本例是新创建的一个接口其中声明了一个方法getColor方法ColorInterface {
    红色 // 每一个枚举对象都需要具体化从接口中继承而来的方法
    {
        public String getColor(){
            return "RED";
        }
    },
    绿色
    {
        public String getColor(){
            return "GREEN";
        }
    },
    蓝色
    {
        public String getColor(){
            return "BLUE";
        }
    };
}
