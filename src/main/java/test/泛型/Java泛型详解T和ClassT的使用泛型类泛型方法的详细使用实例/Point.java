package test.泛型.Java泛型详解T和ClassT的使用泛型类泛型方法的详细使用实例;

//https://www.cnblogs.com/jpfss/p/9928747.html
public class Point<T> {

    private T x;
    private T y;

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

    public static void main(String[] args) {
        // IntegerPoint使用
        Point<Integer> point = new Point<>();
        point.setX(1);
        System.out.println(point.getX());

        // FloatPoint使用
        Point<Float> floatPoint = new Point<>();
        floatPoint.setY(1.2f);
        System.out.println(floatPoint.getY());

        // StringPoint使用
        Point<String> stringPoint = new Point<>();
        stringPoint.setY("string");
        System.out.println(stringPoint.getY());
        //stringPoint.setX(11);
    }
}
