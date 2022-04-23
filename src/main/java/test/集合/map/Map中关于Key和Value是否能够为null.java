package test.集合.map;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @description:
 * @author: biankunpeng
 * @date: 2022/3/10 19:03
 */
public class Map中关于Key和Value是否能够为null {
    public static void main(String[] args) {

        Map<Object, Object> map = new HashMap<>();
        map.put(null, null);
        System.out.println(map.entrySet());

        Map<Object, Object> concurrentHashMap1 = new ConcurrentHashMap();
        concurrentHashMap1.put("1", "");
        System.out.println(concurrentHashMap1);

        //ConcurrentHashMap Key：不允许为null Value：不允许为null
//        Map<Object, Object> concurrentHashMap2 = new ConcurrentHashMap();
//        concurrentHashMap2.put("2", null);
//        System.out.println(concurrentHashMap2);

//        Map<Object, Object> concurrentHashMap3 = new ConcurrentHashMap();
//        concurrentHashMap3.put(null, "3");
//        System.out.println(concurrentHashMap3);

//        Map<Object, Object> concurrentHashMap4 = new ConcurrentHashMap();
//        concurrentHashMap4.put(null, null);
//        System.out.println(concurrentHashMap4);

        // TreeMap Key：允许为null Value：允许为null
        Map<Object, Object> treeMap1 = new TreeMap();
        treeMap1.put("1", null);
        System.out.println(treeMap1);

//        Map<Object, Object> treeMap2 = new TreeMap();
//        treeMap2.put(null, "2");
//        System.out.println(treeMap2);

//        Map<Object, Object> treeMap3 = new TreeMap();
//        treeMap3.put(null, null);
//        System.out.println(treeMap3);
    }
}