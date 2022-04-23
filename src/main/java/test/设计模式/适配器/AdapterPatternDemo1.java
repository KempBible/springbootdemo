package test.设计模式.适配器;

public class AdapterPatternDemo1 {
    public static void main(String[] args) {

        System.out.println("-------- Test 1: 类适配器 ---------");
        ThreePlug desklamp = new DeskLampAdapter();
        desklamp.use3Plug();

    }
}
