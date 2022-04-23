package test.Java8新特性.接口中的默认方法和静态方法你都掌握了吗.接口中的静态方法;

public interface MyFunction {
    default String getName() {
        return "binghe";
    }

    static void send() {
        System.out.println("Send Message...");
    }

    static void main(String[] args) {
        send();
    }
}
