package com.example.springbootdemo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.springbootdemo.model.UserTest1;

import java.util.List;

//https://blog.csdn.net/q736317048/article/details/110284582?spm=1001.2101.3001.6650.1&utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7ECTRLIST%7Edefault-1-110284582-blog-123351670.pc_relevant_default&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7ECTRLIST%7Edefault-1-110284582-blog-123351670.pc_relevant_default&utm_relevant_index=2?

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
