package test.泛型.Java泛型详解T和ClassT的使用泛型类泛型方法的详细使用实例;

//https://www.cnblogs.com/jpfss/p/9928747.html
public class MorePoint<T, U> {

    private T x;
    private T y;

    private U name;

    public T getX() {
        return x;
    }

    public void setX(T x) {
        this.x = x;
    }

    public T getY() {
        return y;
    }

    public void setY(T y) {
        this.y = y;
    }

    public U getName() {
        return name;
    }

    public void setName(U name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MorePoint{" +
                "x=" + x +
                ", y=" + y +
                ", name=" + name +
                '}';
    }

    public static void main(String[] args) {
        // 使用
        MorePoint<Integer, String> morePoint = new MorePoint<>();
        morePoint.setName("harvic");
        System.out.println(morePoint);
    }
}
