package test.Java从入门到精通第2版.第13章;

//https://weread.qq.com/web/reader/34332dd05b1f6e3431a8f7ckc7432af0210c74d97b01b1c

interface USB{ //定义USB接口的标准
    public void work(); // 拿到USB设备就表示要进行工作
}

class Computer{
    public void plugin(USB usb){
        usb.work(); // 按照固定的方式进行工作
    }
}

class Print implements USB{ //打印机实现了USB接口标准

    @Override
    public void work() {
        System.out.println("打印机用USB接口，连接开始工作。");
    }
}

class Flash implements USB{ // U盘实现了USB接口标准

    @Override
    public void work() {
        System.out.println("U盘使用USB接口，连接开始工作");
    }
}

public class 范例13_10接口制定标准代码Interfacestandards {
    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.plugin(new Print()); // 在电话
        computer.plugin(new Flash()); // 在电话上使用U盘
    }
}

