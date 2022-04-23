package test.集合.collection.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @description:
 * @author: biankunpeng
 * @date: 2022/3/10 19:02
 */
public class List遍历修改 {
    public static void main(String[] args) {
        List<String> list2 = new ArrayList<>();
        list2.add("1");
        list2.add("2");
        System.out.println(list2);
        Iterator<String> iterator = list2.iterator();
        while (iterator.hasNext()) {
            String item = iterator.next();
            if ("1".equals(item)) {
                iterator.remove();
            }
        }
        System.out.println(list2);

        // 异常
//        for (String li:list2) {
//            if ("2".equals(li)){
//                list2.remove(li);
//            }
//        }
//        System.out.println(list2);
    }
}