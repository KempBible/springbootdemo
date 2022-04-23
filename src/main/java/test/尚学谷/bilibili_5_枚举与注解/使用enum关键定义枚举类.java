package test.尚学谷.bilibili_5_枚举与注解;

/**
 * 使用enum关键定义枚举类
 * Enum类中的常用方法：
 *  values()方法：返回枚举类型的对象数组。该方法可以很方便地遍历所有的枚举值
 *  valueOf(String str)：可以把一个字符串转为对应的枚举类对象。要求字符串必须是枚举类对象
 *  toString():返回当前枚举类对象常量的名称
 *
 * 使用enum关键字定义的枚举类实现接口的情况
 *  情况一：实现接口，在enum类中实现抽象方法
 *  情况二：让枚举类的对象分别实现接口中的抽象方法
 */
public class 使用enum关键定义枚举类 {
    public static void main(String[] args) {
        Season1 summer = Season1.SUMMER;
        System.out.println(summer.getSeasonName()); // 夏天
        System.out.println(summer.getSeasonDesc()); // 夏日炎炎

        // toString():
        System.out.println(summer.toString()); // SUMMER

        System.out.println(Season1.class.getSuperclass()); // class java.lang.Enum

        System.out.println("*******************");
        // values():
        Season1[] values = Season1.values();
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);
        }
        /*
            SPRING
            SUMMER
            AUTUMN
            WINTER
         */

        System.out.println("*******************");
        Thread.State[] values1 = Thread.State.values();
        for (int i = 0; i < values1.length; i++) {
            System.out.println(values1[i]);
        }
        /*
            NEW
            RUNNABLE
            BLOCKED
            WAITING
            TIMED_WAITING
            TERMINATED
         */

        System.out.println("*******************");
        // valueOf(String objName):返回枚举类中对象名是objName的对象
         Season1 winter = Season1.valueOf("WINTER");
         System.out.println(winter); // WINTER
        // 如果没有objName的枚举类对象，则抛出异常：IllegalArgumentException
        // Season1 winter = Season1.valueOf("WINTER1");
        // System.out.println(winter); // Exception in thread "main" java.lang.IllegalArgumentException: No enum constant test.尚学谷.bilibili_5_枚举与注解.Season1.WINTER1

        winter.show(); // 大约在冬季
    }
}

interface Info{
    void show();
}

// 自定义枚举类
enum Season1 implements Info {
    // 1.提供当前枚举类的对象，多个对象之间用"，"隔开，末尾对象"；"结束
    SPRING("春天", "春暖花开"){
        @Override
        public void show() {
            System.out.println("春天在哪里啊？");
        }
    },
    SUMMER("夏天", "夏日炎炎"){
        @Override
        public void show() {
            System.out.println("宁静的夏天");
        }
    },
    AUTUMN("秋天", "秋高气爽"){
        @Override
        public void show() {
            System.out.println("秋天不回来");
        }
    },
    WINTER("冬天", "冰天雪地"){
        @Override
        public void show() {
            System.out.println("大约在冬季");
        }
    };

    // 2.声明Season对象的属性：private final修饰
    private final String seasonName;
    private final String seasonDesc;

    // 2.私有化类的构造器，并给对象属性赋值
    Season1(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    // 4.其他诉求：获取枚举类对象的属性
    public String getSeasonName(){
        return seasonName;
    }

    public String getSeasonDesc(){
        return seasonDesc;
    }

//    @Override
//    public void show() {
//        System.out.println("这是一个季节");
//    }
}