package test.多线程.highconcurrency;

import java.util.Arrays;
import java.util.function.IntConsumer;

/**
 * @Description: Test
 * @author: biankunpeng
 * @date: 2021年03月31日 19:52
 */

public class Test {

    public static void main(String[] args) {
//        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6);
//        numbers.forEach((Integer value) -> System.out.println(value));
//
//        final int num = 2;
//        Function<Integer, Integer> stringConverter = (from) -> from * num;
//        System.out.println(stringConverter.apply(2));
//
//        List<UserInfo> users = new ArrayList<>();
//        for (int i = 0; i < 5; i++) {
//            users.add(new UserInfo(i, "billy" + Integer.toString(i)));
//        }
//        users.stream().map(UserInfo::getName).forEach(System.out::println);
//
//        for (int i:arr){
//            System.out.println(i);
//        }
//
//        Arrays.stream(arr).forEach(new IntConsumer() {
//            @Override
//            public void accept(int value) {
//                System.out.println(value);
//            }
//        });

        String caseSource = "JR_GXGM";
        System.out.println(caseSource.contains("JR"));

        IntConsumer outprintln = System.out::println;
        IntConsumer errprintln = System.err::println;
        Arrays.stream(arr).forEach(outprintln.andThen(errprintln));
    }

    static int[] arr = {1, 3, 4, 5, 6, 7, 8, 9, 10};

}
