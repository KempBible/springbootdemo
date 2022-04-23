package test.设计模式.代理模式.代理模式1;

//实现接口
public class FoodServiceImpl implements FoodService {

    @Override
    public void makeNoodle() {
        System.out.println("make noodle");
    }

    @Override
    public void makeChicken() {
        System.out.println("make Chicken");
    }
}