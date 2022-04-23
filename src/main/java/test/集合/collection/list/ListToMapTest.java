package test.集合.collection.list;

import com.google.common.collect.Lists;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ListToMapTest {

    public static void main(String[] args) {

        List<Pair<String, Double>> pairArrayList = new ArrayList<>();
        pairArrayList.add(new Pair<>("version", 6.19));
        pairArrayList.add(new Pair<>("version", 10.24));
        pairArrayList.add(new Pair<>("version", 13.14));

        Map<String, Double> map = pairArrayList.stream().collect(
                Collectors.toMap(Pair::getKey, Pair::getValue, (v1, v2) -> v2)
        );

        Map<String, Double> map1 = pairArrayList.stream().collect(
                Collectors.toMap(new Function<Pair<String, Double>, String>() {
                    @Override
                    public String apply(Pair<String, Double> stringDoublePair) {
                        return stringDoublePair.getKey();
                    }
                }, new Function<Pair<String, Double>, Double>() {
                    @Override
                    public Double apply(Pair<String, Double> stringDoublePair) {
                        return stringDoublePair.getValue();
                    }
                }, new BinaryOperator<Double>() {
                    @Override
                    public Double apply(Double aDouble, Double aDouble2) {
                        return aDouble2;
                    }
                })
        );
        System.out.println(map);
        System.out.println(map1);

        String[] departments = new String[]{"iERP", "iERP", "EIBU"};
//        Map<Integer, String> map2 = Arrays.stream(departments).collect(Collectors.toMap(String::hashCode, Function.identity()));
//        System.out.println(map2);

        List<User> userList = new ArrayList<>();
        userList.add(new User("A", "张三"));
        userList.add(new User("A", "李四"));//相同的key
        userList.add(new User("C", "王五"));
//        System.out.println(userList.stream().collect(Collectors.toMap(UserInfo::getId, UserInfo::getName)));;
        System.out.println(userList.stream().collect(Collectors.toMap(User::getId, User::getName, (n1, n2) -> n1 + n2)));
        ;

        List<User> userList1 = Lists.newArrayList(
                new User().setId("B").setName("张三"),
                new User().setId("A").setName("李四"),
                new User().setId("C").setName("王五")
        );
        Map<String, String> uu = userList1.stream().collect(Collectors.toMap(User::getId, User::getName, (n1, n2) -> n1, TreeMap::new));
        System.out.println(uu);

        Map<String, String> result = userList1.stream().collect(Collectors.toMap(User::getId, User::getName, (n1, n2) -> n1, ConcurrentHashMap::new));
        System.out.println(result);

//        String username = Objects.requireNonNull(null);
//        System.out.println(username);
    }
}

