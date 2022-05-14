package test.设计模式.策略模式_strategy;

public class StrategyPatternDemo {

    public static void main(String[] args) {
        Context context = new Context(new OperationAdd());
        System.out.println(context.executeStrategy(1, 2));;

        Context context1 = new Context(new OperationSubtract());
        System.out.println(context1.executeStrategy(1,3));

        Context context2 = new Context(new OperationMultiply());
        System.out.println(context2.executeStrategy(2,6));
    }
}
