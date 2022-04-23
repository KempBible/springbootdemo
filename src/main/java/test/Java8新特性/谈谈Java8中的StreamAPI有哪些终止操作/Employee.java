package test.Java8新特性.谈谈Java8中的StreamAPI有哪些终止操作;

import lombok.*;

import java.io.Serializable;

/**
 * @description:
 * @author: biankunpeng
 * @date: 2022/2/15 19:08
 */
@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Employee implements Serializable {

    private static final long serialVersionUID = -9079722457749166858L;
    private String name;
    private Integer age;
    private Double salary;
    private Stauts stauts;

    public enum Stauts {
        WORKING,
        SLEEPING,
        VOCATION
    }
}