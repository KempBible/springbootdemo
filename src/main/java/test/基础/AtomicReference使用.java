package test.基础;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @description:
 * @author: biankunpeng
 * @date: 2022/3/11 10:15
 */
public class AtomicReference使用 {
    public static void main(String[] args) {
        AtomicReference<String> sf = new AtomicReference<>();
        List<String> strings = Arrays.asList("A", "B", "B", "C", "D", "D", "E");

        strings.stream().distinct().forEach(System.out::println);

        if (strings.stream().anyMatch(t -> "C".equals(t))) {
            System.out.println("WE");
        }

        strings.stream().forEach((t) -> {
            if (t.equals("C")) {
                sf.set(t);
            }
            System.out.print(t + "\t");
        });

        System.out.print(sf.get() + "\t");
    }
}