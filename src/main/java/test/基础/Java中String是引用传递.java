package test.基础;

import org.junit.jupiter.api.Test;

//https://www.cnblogs.com/zeng-wei/p/3494336.html
public class Java中String是引用传递 {
    public static void main(String[] args) {
        String x = new String("ab");
        change(x);
        System.out.println(x);

        String y = "ab";
        changeAgain(y);
        System.out.println(y);
    }

    private static void changeAgain(String y) {
        y = "cd";
    }

    private static void change(String x) {
        x = "cd";
    }

    @Test
    public void test(){
        StringBuffer stringBuffer = new StringBuffer("ab");
        changeTest(stringBuffer);
        System.out.println(stringBuffer);
    }

    private void changeTest(StringBuffer stringBuffer) {
        stringBuffer.delete(0, 2).append("cd");
    }
}
