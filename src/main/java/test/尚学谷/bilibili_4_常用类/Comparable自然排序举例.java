package test.尚学谷.bilibili_4_常用类;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 一、说明：Java中的对象，正常情况下，只能进行比较：== 或 != 。不能使用 > 或 < 的
 *          但是在开发场景中，我们需要对多个对象进行排序，言外之意，就需要比较对象的大小。
 *          如何实现？使用两个接口中的任何一个：Comparable 或 Comparator
 *
 * 二、Comparable接口与Comparator的使用的对比：
 *    Comparable接口的方法一旦一定，保证Comparable接口实现类的对象在任何位置都可以比较大小
 *    Comparator接口属于临时性的比较
 */
public class Comparable自然排序举例 {

    /**
     * Comparable接口的使用举例：自然排序
     * 1.像String、包装类等实现了Comparable接口，重写了compareTo()方法，给出了比较两个对象大小的方式
     * 2.像String、包装类重写compareTo()方法以后，进行了从小到大的排序
     * 3.重写compareTo()的规则：
     *      如果当前对象this大于形参对象obj，则返回正整数，
     *      如果当前对象this小于形参对象obj，则返回负整数，
     *      如果当前对象this等于形参对象obj，则返回零。
     * 4.对于自定义类来说，如果需要排序，我们可以让自定义类实现Comparable接口，重写compareTo()
     *      在compareTo(obj)方法中指明如何排序
     */
    @Test
    public void test1(){
        String[] arr = new String[]{"AA", "CC", "KK", "MM", "GG", "JJ", "DD"};
        //
        Arrays.sort(arr);

        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test2(){
        自定义类实现Comparable自然排序[] arr = new 自定义类实现Comparable自然排序[4];
        arr[0] = new 自定义类实现Comparable自然排序("lenovoMouse",34);
        arr[1] = new 自定义类实现Comparable自然排序("dellMouse",43);
        arr[2] = new 自定义类实现Comparable自然排序("xiaomiMouse",12);
        arr[3] = new 自定义类实现Comparable自然排序("huaweiMouse",65);

        Arrays.sort(arr);

        System.out.println(Arrays.toString(arr));
        // [自定义类实现Comparable自然排序{name='xiaomiMouse', price=12.0}, 自定义类实现Comparable自然排序{name='lenovoMouse', price=34.0}, 自定义类实现Comparable自然排序{name='dellMouse', price=43.0}, 自定义类实现Comparable自然排序{name='huaweiMouse', price=65.0}]
    }

    @Test
    public void test2_1(){
        自定义类实现Comparable自然排序[] arr = new 自定义类实现Comparable自然排序[5];
        arr[0] = new 自定义类实现Comparable自然排序("lenovoMouse",34);
        arr[1] = new 自定义类实现Comparable自然排序("dellMouse",43);
        arr[2] = new 自定义类实现Comparable自然排序("xiaomiMouse",12);
        arr[3] = new 自定义类实现Comparable自然排序("huaweiMouse",65);
        arr[4] = new 自定义类实现Comparable自然排序("microsoftMouse",43);

        Arrays.sort(arr);

        System.out.println(Arrays.toString(arr));
        // [自定义类实现Comparable自然排序{name='xiaomiMouse', price=12.0}, 自定义类实现Comparable自然排序{name='lenovoMouse', price=34.0}, 自定义类实现Comparable自然排序{name='dellMouse', price=43.0}, 自定义类实现Comparable自然排序{name='microsoftMouse', price=43.0}, 自定义类实现Comparable自然排序{name='huaweiMouse', price=65.0}]
    }

    @Test
    public void test2_2(){
        自定义类实现Comparable自然排序[] arr = new 自定义类实现Comparable自然排序[5];
        arr[0] = new 自定义类实现Comparable自然排序("lenovoMouse",34);
        arr[1] = new 自定义类实现Comparable自然排序("dellMouse",43);
        arr[2] = new 自定义类实现Comparable自然排序("xiaomiMouse",12);
        arr[3] = new 自定义类实现Comparable自然排序("huaweiMouse",65);
        arr[4] = new 自定义类实现Comparable自然排序("microsoftMouse",43);

        Arrays.sort(arr);

        System.out.println(Arrays.toString(arr));
        // [自定义类实现Comparable自然排序{name='xiaomiMouse', price=12.0}, 自定义类实现Comparable自然排序{name='lenovoMouse', price=34.0}, 自定义类实现Comparable自然排序{name='microsoftMouse', price=43.0}, 自定义类实现Comparable自然排序{name='dellMouse', price=43.0}, 自定义类实现Comparable自然排序{name='huaweiMouse', price=65.0}]
    }

    /**
     * Comparator接口的使用：定制排序
     * 1.背景：
     * 当元素的类型没有实现java.lang.Comparable接口而又不方便修改代码，
     * 或则实现了java.lang.Comparable接口的排序规则不适合当前的操作，
     * 那么可以考虑使用Comparator的对象来排序
     * 2.重写compare(Object o1, Object o2)方法，比较o1和o2的大小：
     * 如果方法返回正整数，则表示o1大于o2；
     * 如果返回0，表示相等；
     * 返回负整数，表示o1小于o2。
     */
    @Test
    public void test3(){
        String[] arr = new String[]{"AA", "CC", "KK", "MM", "GG", "JJ", "DD"};
        Arrays.sort(arr, new Comparator<String>() {
            // 按照字符串从大到小的顺序排列
            @Override
            public int compare(String o1, String o2) {
                if (o1 instanceof String && o2 instanceof String){
                    String s1 = (String)o1;
                    String s2 = (String)o2;
                    return -s1.compareTo(s2);
                }
                // return 0;
                throw new RuntimeException("输入的数据类型不一致");
            }
        });
        System.out.println(Arrays.toString(arr)); // [MM, KK, JJ, GG, DD, CC, AA]
    }

    @Test
    public void test4(){
        自定义类实现Comparable自然排序[] arr = new 自定义类实现Comparable自然排序[5];
        arr[0] = new 自定义类实现Comparable自然排序("lenovoMouse",34);
        arr[1] = new 自定义类实现Comparable自然排序("dellMouse",43);
        arr[2] = new 自定义类实现Comparable自然排序("xiaomiMouse",12);
        arr[3] = new 自定义类实现Comparable自然排序("huaweiMouse",65);
        arr[4] = new 自定义类实现Comparable自然排序("microsoftMouse",43);

        Arrays.sort(arr, new Comparator<自定义类实现Comparable自然排序>() {
            // 指明商品比较大小的方式：按照产品名称从低到高排序，再按照价格从高到低排序
            @Override
            public int compare(自定义类实现Comparable自然排序 o1, 自定义类实现Comparable自然排序 o2) {
                if (o1 instanceof 自定义类实现Comparable自然排序 && o2 instanceof 自定义类实现Comparable自然排序){
                    自定义类实现Comparable自然排序 g1 = (自定义类实现Comparable自然排序)o1;
                    自定义类实现Comparable自然排序 g2 = (自定义类实现Comparable自然排序)o2;
                    if (g1.getName().equals(g2.getName())){
                        return -Double.compare(g1.getPrice(), g2.getPrice());
                    }else{
                        return g1.getName().compareTo(g2.getName());
                    }
                }
                throw new RuntimeException("输入的数据类型不一致");
            }
        });

        System.out.println(Arrays.toString(arr));
        // [自定义类实现Comparable自然排序{name='dellMouse', price=43.0}, 自定义类实现Comparable自然排序{name='huaweiMouse', price=65.0}, 自定义类实现Comparable自然排序{name='lenovoMouse', price=34.0}, 自定义类实现Comparable自然排序{name='microsoftMouse', price=43.0}, 自定义类实现Comparable自然排序{name='xiaomiMouse', price=12.0}]
    }

    @Test
    public void test4_1(){
        自定义类实现Comparable自然排序[] arr = new 自定义类实现Comparable自然排序[6];
        arr[0] = new 自定义类实现Comparable自然排序("lenovoMouse",34);
        arr[1] = new 自定义类实现Comparable自然排序("dellMouse",43);
        arr[2] = new 自定义类实现Comparable自然排序("xiaomiMouse",12);
        arr[3] = new 自定义类实现Comparable自然排序("huaweiMouse",65);
        arr[4] = new 自定义类实现Comparable自然排序("huaweiMouse",224);
        arr[5] = new 自定义类实现Comparable自然排序("microsoftMouse",43);

        Arrays.sort(arr, new Comparator<自定义类实现Comparable自然排序>() {
            // 指明商品比较大小的方式：按照产品名称从低到高排序，再按照价格从高到低排序
            @Override
            public int compare(自定义类实现Comparable自然排序 o1, 自定义类实现Comparable自然排序 o2) {
                if (o1 instanceof 自定义类实现Comparable自然排序 && o2 instanceof 自定义类实现Comparable自然排序){
                    自定义类实现Comparable自然排序 g1 = (自定义类实现Comparable自然排序)o1;
                    自定义类实现Comparable自然排序 g2 = (自定义类实现Comparable自然排序)o2;
                    if (g1.getName().equals(g2.getName())){
                        return -Double.compare(g1.getPrice(), g2.getPrice());
                    }else{
                        return g1.getName().compareTo(g2.getName());
                    }
                }
                throw new RuntimeException("输入的数据类型不一致");
            }
        });

        System.out.println(Arrays.toString(arr));
        // [自定义类实现Comparable自然排序{name='dellMouse', price=43.0}, 自定义类实现Comparable自然排序{name='huaweiMouse', price=224.0}, 自定义类实现Comparable自然排序{name='huaweiMouse', price=65.0}, 自定义类实现Comparable自然排序{name='lenovoMouse', price=34.0}, 自定义类实现Comparable自然排序{name='microsoftMouse', price=43.0}, 自定义类实现Comparable自然排序{name='xiaomiMouse', price=12.0}]
    }
}
