package test.Java从入门到精通第2版.第11章;

//https://weread.qq.com/web/reader/34332dd05b1f6e3431a8f7ckaab325601eaab3238922e53

enum NewColor{
    RED("红色", 4),
    GREEN("绿色",5),
    BLUE("蓝色",6);

    private String name;
    private int index;

    NewColor(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public static String getName(int index) {
        for (NewColor c:NewColor.values()) {
            if (c.getIndex() == index){
                return c.name;
            }
        }
        return null;
    }

    public static void setName(int index, String name) {
        for (NewColor c:NewColor.values()) {
            if (c.getIndex() == index){
                c.name = name;
                return;
            }
        }
    }

    public String getName() {
        return name;
    }

    public int getIndex() {
        return index;
    }

    public static void setIndex(int index, String name) {
        for (NewColor c:NewColor.values()) {
            if (c.getName() == name){
                c.index = index;
                return;
            }
        }
    }
}

public class 范例11_10定义枚举的构造方法DeepEnum {
    public static void main(String[] args) {
        System.out.println("-----------输出枚举中元素-----------");
        System.out.println(NewColor.RED.getIndex() + "-->" + NewColor.RED.getName());
        System.out.println(NewColor.GREEN.getIndex() + "-->" + NewColor.GREEN.getName());
        System.out.println(NewColor.BLUE.getIndex() + "-->" + NewColor.BLUE.getName());

        System.out.println("-----------在自定义编号和属性值之后，测试-----------");
        NewColor.setName(4, "黑色");
        System.out.println(NewColor.getName(4));

        NewColor.setName(7, "黄色");
        System.out.println(NewColor.getName(7));

        NewColor.setIndex(7, "黑色");
        System.out.println(NewColor.getName(7));
    }
}

