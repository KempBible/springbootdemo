package test.集合.collection.list;

import java.util.*;

/**
 * @description:
 * @author: biankunpeng
 * @date: 2022/3/11 14:11
 */
public class 从List中随机抽取小于ListSize个数元素 {

    public static void main(String[] args) {
        Integer[] integers = {1, 5, 6, 3, 8};
        List<Object> list = Arrays.asList(integers);
        getList(list, 4).forEach(System.out::println);
    }

    /**
     * 根据取出的数量 随机生成一组指定范围内不重复的下标，再去取
     * list 需要筛选的list
     * num  取出的个数
     **/
    private static List<Object> getList(List<Object> list, int num) {
        int listSize = list.size();
        //如果要取出的个数大于当前list的size；则返回当前list
        if (listSize <= num) {
            return list;
        }
        //待返回的list
        List<Object> waitList = new ArrayList<Object>();
        //随机生成要取出的下标
        SortedSet<Integer> sortedSet = new TreeSet<Integer>();
        randomSet(0, listSize, num, sortedSet);
        System.out.println("sortedSet数集合=====" + sortedSet);
        for (Integer i : sortedSet) {
            waitList.add(list.get(i));
        }
        return waitList;
    }

    /**
     * 随机生成一组数
     * m   指定范围最小值
     * n   指定范围最大值
     * num 生成的数量（个）
     * set 数组集合
     **/
    public static void randomSet(int m, int n, int num, SortedSet<Integer> set) {
        System.out.println(m + (int) (Math.random() * (n - m)));
        set.add(m + (int) (Math.random() * (n - m)));
        if (set.size() < num) {
            randomSet(m, n, num, set);
        }
    }
}