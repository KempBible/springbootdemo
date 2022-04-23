package test.设计模式.适配器;

public class AdapterPatternDemo {
    public static void main(String[] args) {
        ThreePlug pc = new PC();
        pc.use3Plug();
    }
}
