package test.设计模式.代理模式.Spring学习笔记代理模式;

//https://blog.csdn.net/xu_benjamin/article/details/118415934
public class demo01租房 {
    public static void main(String[] args) {
        Host host = new Host();
        Proxy proxy = new Proxy(host);
        proxy.rent();
    }
}
// 1、接口，租房
interface Rent{
    void rent();
}
// 2、真实角色，房东
class Host implements Rent{

    @Override
    public void rent() {
        System.out.println("房东出租房子");
    }
}
//3、代理角色，中介
class Proxy implements Rent{

    private Host host;

    public Proxy(Host host) {
        this.host = host;
    }

    @Override
    public void rent() {
        seeHouse();
        host.rent();
        signContract();
        charge();
    }

    private void seeHouse(){
        System.out.println("中介带你看房子");
    }
    private void signContract(){
        System.out.println("中介带你签合同");
    }
    private void charge(){
        System.out.println("中介收取中介费");
    }
}
