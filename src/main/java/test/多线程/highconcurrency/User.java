package test.多线程.highconcurrency;

import lombok.Data;

/**
 * @Description: UserInfo
 * @author: biankunpeng
 * @date: 2021年03月31日 20:02
 */
@Data
public class User {

    private Integer id;
    private String name;

    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
