package test.基础;


import com.alibaba.druid.util.StringUtils;

// 阿里手册
public class SwitchString {
    public static void main(String[] args) {
        method(null);
        Integer a = 1;
        Integer b = 2;
        Integer c = 0;
        Boolean flag = false;
        Integer result = (flag ? a * b : c);
        System.out.println(result);
    }

    private static void method(String param) {
        if (StringUtils.isEmpty(param)) {
            return;
        }
        switch (param) {
            case "sth":
                System.out.println(param);
                break;
            case "null":
                System.out.println("null");
                return;
            default:
                System.out.println();
                return;
        }
    }
}
