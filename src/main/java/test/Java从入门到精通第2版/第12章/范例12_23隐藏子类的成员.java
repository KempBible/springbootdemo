package test.Java从入门到精通第2版.第12章;

//https://weread.qq.com/web/reader/34332dd05b1f6e3431a8f7ck9bf32f301f9bf31c7ff0a60
public class 范例12_23隐藏子类的成员 {
    public static void main(String[] args) {
        Father dad = new Son();
        dad.overWritting();

        Father.overWritting();
        Son.overWritting();
    }
}

class Father{
    public static void overWritting(){
        System.out.println("####--Father method");
    }
}

class Son extends Father{
    public static void overWritting(){
        System.out.println("****--Son method");
    }
}

