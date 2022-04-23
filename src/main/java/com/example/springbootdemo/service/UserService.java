package com.example.springbootdemo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.springbootdemo.model.UserInfo;

/**
 * @Description: UserService
 * @author: biankunpeng
 * @date: 2021年03月25日 15:06
 */
public interface UserService extends IService<UserInfo> {
    UserInfo Sel(int id);

    boolean addUser(UserInfo userInfo);

    boolean addUserWithNoParam(UserInfo userInfo);

    IPage<UserInfo> selectUserPage(Page<UserInfo> userPage, long id);
}
