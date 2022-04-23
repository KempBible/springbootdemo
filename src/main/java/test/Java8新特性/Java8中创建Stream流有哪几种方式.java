package test.Java8新特性;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @description:
 * @author: biankunpeng
 * @date: 2022/2/15 18:10
 */
// https://mp.weixin.qq.com/s?__biz=Mzg4MjU0OTM1OA==&mid=2247489314&idx=1&sn=b6140423cacae11819863d3f9cd0e2d3&chksm=cf55a023f8222935cdf66cee0bf0f23a3b4ccf2e360997133c7f07f8c5e28788413807646b24&scene=178&cur_album_id=1664766497224753159#rd
public class Java8中创建Stream流有哪几种方式 {

    public static void main(String[] args) {
        //1.
        List<String> list = new ArrayList<>();
        list.stream();
        list.parallelStream();

        //2.
        Integer[] nums = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        Stream<Integer> numStream = Arrays.stream(nums);
        System.out.println(numStream);

        //3.
        Stream<String> strStream = Stream.of("a", "b", "c");

        //4.
        Stream<Integer> intStream = Stream.iterate(0, (x) -> x + 2);
//        intStream.forEach(System.out::println);
//        Stream.generate(() -> Math.random()).forEach(System.out::println);
        Stream.generate(() -> Math.random()).limit(5).forEach(System.out::println);

        //5.
        Stream<String> empty = Stream.empty();

    }
}