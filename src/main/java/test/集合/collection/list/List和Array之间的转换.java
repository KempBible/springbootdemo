package test.集合.collection.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class List和Array之间的转换 {
    public static void main(String[] args) {
        // List转为Array
        List<String> list = new ArrayList<>(2);
        list.add("guan");
        list.add("bao");
        String[] array = list.toArray(new String[0]);
        System.out.println(Arrays.toString(array));

        // Array转为List
        String[] str = new String[]{"chen", "yang", "hao"};
        List list1 = Arrays.asList(str);
//        list1.add("yangguanhao");
        str[0] = "change";
        System.out.println(list1);
    }
}
