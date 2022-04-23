package test.设计模式.适配器;

/**
 * Adapter Pattern 适配器模式 Demo
 */
public class AdapterPatternDemo2 {
    public static void main(String[] args) {

        System.out.println("-------- Test 2: 对象适配器 -------");
        ThreePlug fan = new FanPlugAdapter(new Fan());
        fan.use3Plug();

    }
}