package test.Java从入门到精通第2版.第11章;

enum NewColor3{
    // 每个枚举对象都需要实现所定义的抽象方法
    红色{
        public String getColor(){
            return "RED";
        }
    },
    绿色{
        public String getColor(){
            return "GREEN";
        }
    },
    蓝色{
        public String getColor(){
            return "BLUE";
        }
    };

    public abstract String getColor(); // 定义抽象方法
}

public class 范例11_12定义枚举的抽象方法直接在枚举中定义抽象方法其中每个对象都必须单独实现此方法AbstractEnum {
    public static void main(String[] args) {
        for (NewColor3 c: NewColor3.values()) {
            System.out.println(c.ordinal() + "\t" + c.name() + "\t" + c.getColor());
        }
    }
}
