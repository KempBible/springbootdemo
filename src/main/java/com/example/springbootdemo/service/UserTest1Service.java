package com.example.springbootdemo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.springbootdemo.model.UserTest1;

import java.util.List;

/**
*
*/
public interface UserTest1Service extends IService<UserTest1> {

    /**
     * 模糊查询用户信息
     * @param username  用户名称
     * @return
     */
    List<UserTest1> likeListUser(String username);

    List<UserTest1> pageList(int current, int size);

    /**
     * 添加方法
     * @param userTest1
     * @return
     */
    int addUser(UserTest1 userTest1);

    /**
     * 删除方法
     * @param id
     * @return
     */
    boolean deleteUser(int id);
}
