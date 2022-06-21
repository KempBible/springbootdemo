package test.集合.collection.list;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @description:
 * @author: biankunpeng
 * @date: 2022/6/20 20:52
 */
//https://blog.csdn.net/wangooo/article/details/108509890
public class java8listsort排序 {

    @Test
    public void 对整数列表排序_升序() {
        List<Integer> list = Arrays.asList(1, 4, 2, 6, 2, 8);
        list.sort(Comparator.naturalOrder());
        System.out.println(list);
    }

    @Test
    public void 对整数列表排序_降序() {
        List<Integer> list = Arrays.asList(1, 4, 2, 6, 2, 8);
        list.sort(Comparator.reverseOrder());
        System.out.println(list);
    }

    public List<UserForList> init() {
        UserForList user1 = new UserForList("1", "a", 1);
        UserForList user2 = new UserForList("1", "b", 2);
        UserForList user3 = new UserForList("1", "c", 2);
        UserForList user4 = new UserForList("2", "d", 2);
        List<UserForList> list = new ArrayList<>();
        list.add(user4);
        list.add(user2);
        list.add(user1);
        list.add(user3);
        return list;
    }

    @Test
    public void 按照List中对象的id属性升序() {
        List<UserForList> userList = init();
        System.out.println(userList);
        userList.sort(Comparator.comparing(UserForList::getId));
        System.out.println(userList);
    }

    @Test
    public void 按照List中对象的id属性降序() {
        List<UserForList> userList = init();
        System.out.println(userList);
        userList.sort(Comparator.comparing(UserForList::getId).reversed());
        System.out.println(userList);
    }

    @Test
    public void 多个条件升序() {
        List<UserForList> userList = init();
        System.out.println(userList);
        userList.sort(Comparator.comparing(UserForList::getId).thenComparing(UserForList::getDeId));
        System.out.println(userList);
    }

    @Test
    public void id升序deId降序() {
        List<UserForList> userList = init();
        System.out.println(userList);
        userList.sort(Comparator.comparing(UserForList::getId).thenComparing(UserForList::getDeId).reversed());
        System.out.println(userList);
    }

    @Test
    public void Collection升序排序() {
        List<UserForList> userList = init();
        System.out.println(userList);
        Collections.sort(userList, new Comparator<UserForList>() {
            @Override
            public int compare(UserForList o1, UserForList o2) {
                return o1.hashCode() - o2.hashCode();
            }
        });
        System.out.println(userList);
    }

}