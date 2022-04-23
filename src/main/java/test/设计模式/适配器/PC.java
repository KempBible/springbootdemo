package test.设计模式.适配器;

public class PC implements ThreePlug {
    @Override
    public void use3Plug() {
        System.out.println("电脑已插电源，正常工作中...");
    }
}
