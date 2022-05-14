package test.Java从入门到精通第2版.第18章;
//https://weread.qq.com/web/reader/34332dd05b1f6e3431a8f7ck3c5327902153c59dc0488e1
class Sex{
    private String title;
    private static final Sex MALE = new Sex("男");
    private static final Sex FEMALE = new Sex("女");

    public Sex(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Sex{" +
                "title='" + title + '\'' +
                '}';
    }

    public static Sex getInstance(String s){
        switch(s){
            case "男":
                return MALE;
            case "女":
                return FEMALE;
            default:
                return null;
        }
    }
}

public class 范例18_13多例设计TestMultiton {
    public static void main(String[] args) {
        System.out.println(Sex.getInstance("男").toString());;
    }
}
