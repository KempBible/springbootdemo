package test.Java从入门到精通第2版.第17章;

interface Book3{
    public String getTitle();
}

class MathBook3 implements Book3{

    @Override
    public String getTitle() {
        return "数学类图书";
    }
}

class ComputerBook implements Book3{

    @Override
    public String getTitle() {
        return "计算机类图书";
    }
}

class Factory3{
    public static Book3 getInstance(String className){
        Book3 book3 = null;
        try {
            book3 = (Book3) Class.forName(className).newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return book3;
    }
}

public class 范例17_11使用反射机制的工厂模式TestFactory01 {
    public static void main(String[] args) {
        Book3 book3 = Factory3.getInstance("test.Java从入门到精通第2版.第17章.ComputerBook");
        System.out.println(book3.getTitle());
    }
}
