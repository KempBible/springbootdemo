package test.多线程;

public class Thread共享变量的使用 {
    public static void main(String[] args) {
        Game game = new Game();
        game.start();
        try {
            Thread.sleep(100);
        } catch (Exception e) {

        }
        game.setIndex(-1);
        System.out.println("change.....");
    }
}

class Game extends Thread {
    public int index = 0;

    public synchronized int getIndex() {
        return index;
    }

    public synchronized void setIndex(int index) {
        this.index = index;
    }

    @Override
    public void run() {
        System.out.println("Game Start");
        while (true) {
            if (this.getIndex() == -1) {
                break;
            }
        }
        System.out.println("Game End");
    }
}
