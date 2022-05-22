package test.比较器;

//https://blog.csdn.net/weixin_44602460/article/details/117731127

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.*;

/**
 * @                           _ooOoo_
 *                            o8888888o
 *                            88" . "88
 *                            (| -_- |)
 *                            O\  =  /O
 *                         ____/`---'\____
 *                       .'  \\|     |//  `.
 *                      /  \\|||  :  |||//  \
 *                     /  _||||| -:- |||||-  \
 *                     |   | \\\  -  /// |   |
 *                     | \_|  ''\---/''  |   |
 *                     \  .-\__  `-`  ___/-. /
 *                   ___`. .'  /--.--\  `. . __
 *                ."" '<  `.___\_<|>_/___.'  >'"".
 *               | | :  `- \`.;`\ _ /`;.`/ - ` : | |
 *               \  \ `-.   \_ __\ /__ _/   .-` /  /
 *          ======`-.____`-.___\_____/___.-`____.-'======
 *                             `=---='
 *          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
 *                     佛祖保佑        永无BUG
 */

public class LearnCompare {
    public static void main(String[] args) {
        List<Node> list = new ArrayList<>();
        list.add(new Node("yguo",25));
        list.add(new Node("msdfj",22));
        list.add(new Node("skf",20));
        list.add(new Node("sfe",23));
        System.out.println("===Age排序外部比较器===");
        System.out.println(list);
        Collections.sort(list, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.getAge() - o2.getAge();
            }
        });
        System.out.println(list);

        for (Iterator<Node> it = list.iterator();it.hasNext();){
            System.out.println(it.next());
        }
        System.out.println("===Name排序外部比较器====");
        Collections.sort(list, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        for (Iterator<Node> it=list.iterator();it.hasNext();){
            System.out.println(it.next());
        }
        System.out.println("===Age排序 内部比较器===");
        Collections.sort(list);
        for (Iterator<Node> it=list.iterator();it.hasNext();){
            System.out.println(it.next());
        }
    }
}

@Data
@ToString
@AllArgsConstructor
class Node implements Comparable<Node>{

    private String name;
    private int age;

    @Override
    public int compareTo(Node o) {
        if (this.age > o.age){
            return -1;
        }
        if (this.age < o.age){
            return 1;
        }
        return 0;
    }
}