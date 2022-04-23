package test.lambda;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class Test {

    private static List<User> userList = new ArrayList<>();

    static {
        User user1 = new User();
        user1.setId(1L);
        user1.setName("roc");
        user1.setAge(16);
        user1.setJobNumber("a1");
        user1.setSex("man");
        user1.setEntryDate(new Date());
        user1.setFamilyMemberQuantity(new BigDecimal(2));
        userList.add(user1);

        User user2 = new User();
        user2.setId(2L);
        user2.setName("ling");
        user2.setAge(15);
        user2.setJobNumber("a2");
        user2.setSex("woman");
        user2.setEntryDate(new Date(2010 - 1900, 1, 10));
        user2.setFamilyMemberQuantity(new BigDecimal(2));
        userList.add(user2);

        User user3 = new User();
        user3.setId(3L);
        user3.setName("rocling");
        user3.setJobNumber("a12");
        user3.setSex("man");
        user3.setEntryDate(new Date());
        user3.setFamilyMemberQuantity(new BigDecimal(2));
        userList.add(user3);
    }

    public static void main(String[] args) {
        //分组
        Map<String, List<User>> groupBySex = userList.stream().collect(Collectors.groupingBy(User::getSex));
        //遍历分组
        for (Map.Entry<String, List<User>> entryUser : groupBySex.entrySet()) {
            String key = entryUser.getKey();
            List<User> entryUserList = entryUser.getValue();
            for (User user : entryUserList) {
                System.out.println(key + ":" + user.toString());
            }
        }

        System.out.println("----------------------------------------------------------------------------------------------------");
        //过滤
        //排除掉工号为a2的用户
        List<User> userCommonList = userList.stream().filter(a -> !a.getJobNumber().equals("a2")).collect(Collectors.toList());
        for (User user : userCommonList) {
            System.out.println(user.toString());
        }

        System.out.println("----------------------------------------------------------------------------------------------------");
        //求和
        //基本类型
        int sumAge = userList.stream().mapToInt(User::getAge).sum();
        System.out.println(sumAge);
        //BigDecimal求和
        //user3.setFamilyMemberQuantity(new BigDecimal(2)); 注释会报错
        BigDecimal totalQuantity = userList.stream().map(User::getFamilyMemberQuantity).reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println(totalQuantity);
        //user3.setFamilyMemberQuantity(new BigDecimal(2)); 注释不会报错
        BigDecimal totalQuantity2 = userList.stream().map(User::getFamilyMemberQuantity).reduce(BigDecimal.ZERO, BigDecimalUtils::sum);
        System.out.println(totalQuantity2);

        System.out.println("----------------------------------------------------------------------------------------------------");
        //最小
        Date minEntryDate = userList.stream().map(User::getEntryDate).min(Date::compareTo).get();
        //最大
        Date maxEntryDate = userList.stream().map(User::getEntryDate).max(Date::compareTo).get();
        System.out.println(minEntryDate);
        System.out.println(maxEntryDate);

        System.out.println("----------------------------------------------------------------------------------------------------");
        /**
         * List -> Map
         * 需要注意的是：
         * toMap 如果集合对象有重复的key，会报错Duplicate key ....
         *  user1,user2的id都为1。
         *  可以用 (k1,k2)->k1 来设置，如果有重复的key,则保留key1,舍弃key2
         */
        Map<Long, User> userMap = userList.stream().collect(Collectors.toMap(User::getId, a -> a, (k1, k2) -> k1));
        System.out.println(userMap);

        System.out.println("----------------------------------------------------------------------------------------------------");
        //排序
        //单字段排序，根据id排序
        userList.sort(Comparator.comparing(User::getId));
        //多字段排序，根据id，年龄排序
        userList.sort(Comparator.comparing(User::getId).thenComparing(User::getAge));
        System.out.println(userList);

        System.out.println("----------------------------------------------------------------------------------------------------");
        //去重
        List<Long> idList = new ArrayList<Long>();
        idList.add(1L);
        idList.add(1L);
        idList.add(2L);
        List<Long> distinctIdList = idList.stream().distinct().collect(Collectors.toList());
        System.out.println(distinctIdList);

        System.out.println("----------------------------------------------------------------------------------------------------");
        //获取list对象的某个字段组装成新list
        List<Long> userIdList = userList.stream().map(a -> a.getId()).collect(Collectors.toList());
        System.out.println(userIdList);

        System.out.println("----------------------------------------------------------------------------------------------------");
        userList.stream().forEach(a -> a.setJobNumber("0"));
        System.out.println(userList);
    }

}
