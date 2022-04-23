package test.lambda;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: biankunpeng
 * @date: 2022/3/11 19:32
 */
// https://blog.csdn.net/qq_19439605/article/details/86569856?spm=1001.2101.3001.6650.2&utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7ECTRLIST%7ERate-2.pc_relevant_aa&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7ECTRLIST%7ERate-2.pc_relevant_aa&utm_relevant_index=4
public class Lambda表达式写的Listforeach循环是单线程处理还是多线程处理 {

    List<String> list = Arrays.asList(new String[]{"a", "b", "c"});

    @Test
    public void TraverseList() {
        for (String l : list) {
            System.out.println(l);
        }
    }

    @Test
    public void foreach1() {
        list.stream().forEach((l) -> System.out.println(l));
    }

    @Test
    public void foreach2() {
        list.forEach(System.out::println);
    }

    @Test
    public void foreach3() {
        list.parallelStream().forEach(l -> {
            System.out.println("lambda表达式的线程:" + Thread.currentThread().getId());
        });
    }
}