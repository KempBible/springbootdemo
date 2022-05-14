package test.设计模式.状态策略_State;

public class StartState implements State{
    @Override
    public void doAction(Context context) {
        System.out.println("Player is in start stare");
        context.setState(this);
    }

    @Override
    public String toString() {
        return "Start State";
    }
}
