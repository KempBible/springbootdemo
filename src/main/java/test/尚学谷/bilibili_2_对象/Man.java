package test.尚学谷.bilibili_2_对象;

interface Filial{ // 孝顺的
    default void help(){
        System.out.println("老妈，我来救你了");
    }
}

interface Spoony{ // 痴情的
    default void help(){
        System.out.println("媳妇儿，别怕，我来了");
    }
}

class Father{
    public void help(){
        System.out.println("儿子，救我媳妇儿！");
    }
}

public class Man extends Father implements Filial, Spoony {

    @Override
    public void help() {
        System.out.println("我该救谁呢？");
        Filial.super.help();
        Spoony.super.help();
    }

    public static void main(String[] args) {
        Man man = new Man();
        man.help();
    }
}
