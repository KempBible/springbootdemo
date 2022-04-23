package test.尚学谷.bilibili_2_对象;

/**
 * 排错
 */

interface Playable{
    void play();
}

interface Bounceable{
    void play();
}

interface Rollable extends Playable, Bounceable{
    Ball ball = new Ball("PingPang");
}

class Ball implements Rollable{

    private String name;

    public String getName(){
        return name;
    }

    public Ball(String name){
        this.name = name;
    }

    @Override
    public void play() {
        // 不能这样写 Cannot assign a value to final variable 'ball'
//        ball = new Ball("Football");
        System.out.println(ball.name);
    }
}


