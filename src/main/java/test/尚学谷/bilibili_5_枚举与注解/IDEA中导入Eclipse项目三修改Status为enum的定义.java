package test.尚学谷.bilibili_5_枚举与注解;

public class IDEA中导入Eclipse项目三修改Status为enum的定义 {
    public static void main(String[] args) throws Exception {
        // Exception in thread "main" java.lang.Exception: 该员工已是某团队成员
        switch (Status.BUSY){
            case BUSY:
                throw new Exception("该员工已是某团队成员");
            case VOCATION:
                throw new Exception("该员工正在休假，无法添加");
        }
    }
}

//class Status{
//    private final String NAME;
//    private Status(String name){
//        NAME = name;
//    }
//
//    public static final Status FREE = new Status("FREE");
//    public static final Status BUSY = new Status("BUSY");
//    public static final Status VOCATION = new Status("VOCATION");
//
//    public String getNAME(){
//        return NAME;
//    }
//
//    @Override
//    public String toString() {
//        return "Status{" +
//                "NAME='" + NAME + '\'' +
//                '}';
//    }
//}

enum Status{
    FREE,BUSY,VOCATION;
}