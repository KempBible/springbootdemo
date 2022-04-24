package test.Java从入门到精通第2版.第13章;

//https://weread.qq.com/web/reader/34332dd05b1f6e3431a8f7ckc7432af0210c74d97b01b1c
abstract class Action{ //表示操作行为
    public static final int EAT = 1;
    public static final int WORK = 2;
    public static final int SLEEP = 5;
    public static final int RUN = 10;

    public abstract void eat(); //声明一抽象方法
    public abstract void sleep(); //声明一抽象方法
    public abstract void run(); //声明一抽象方法
    public abstract void work(); //声明一抽象方法

    public void command(int ch){ //具体的命令
        switch (ch){
            case EAT:
                this.eat();
                break;
            case SLEEP:
                this.sleep();
                break;
            case RUN:
                this.run();
                break;
            case WORK:
                this.work();
                break;
            case EAT+WORK:
                this.eat();
                this.work();
                break;
            case EAT+SLEEP+RUN:
                this.eat();
                this.sleep();
                this.run();
                break;
            case EAT+SLEEP+RUN+WORK:
                this.eat();
                this.sleep();
                this.run();
                this.work();
                break;
        }
    }
}

class Robot extends Action{ // 定义子类Robot

    @Override
    public void eat() { //覆写抽象方法
        System.out.println("为机器人加燃料");
    }

    @Override
    public void sleep() {

    }

    @Override
    public void run() {

    }

    @Override
    public void work() {
        System.out.println("让机器人开始工作");
    }
}

class Woman extends Action{ // 定义子类Woman

    @Override
    public void eat() {
        System.out.println("请美女吃饭");
    }

    @Override
    public void sleep() {
        System.out.println("让美女睡美容觉");
    }

    @Override
    public void run() {
        System.out.println("让美女跑步健身");
    }

    @Override
    public void work() {

    }
}

class Man extends Action{ // 定义子类Man行为

    @Override
    public void eat() {
        System.out.println("帅哥吃早饭、午饭、晚饭、加餐");
    }

    @Override
    public void sleep() {
        System.out.println("帅哥休息好以恢复精神和体力");
    }

    @Override
    public void run() {
        System.out.println("帅哥通过跑步来锻炼身体");
    }

    @Override
    public void work() {
        System.out.println("帅哥为了和美女幸福地生活在一起，要好好工作");
    }
}

public class 范例13_4模板设计模式代码TemplateMethod {
    public static void main(String[] args) {
        Action actionA = new Robot(); // 机器人行为
        actionA.command(Action.EAT+Action.WORK);

        System.out.println("--------------------------------");
        Action actionB = new Woman(); // 美女的行为
        actionB.command(Action.EAT+Action.SLEEP+Action.RUN);

        System.out.println("--------------------------------");
        Action actionC = new Man(); // 帅哥的行为
        actionC.command(Action.EAT+Action.SLEEP+Action.RUN+Action.WORK);
    }
}

