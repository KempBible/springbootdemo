package com.example.springbootdemo.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springbootdemo.mapper.UserMapper;
import com.example.springbootdemo.model.UserInfo;
import com.example.springbootdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Description: UserServiceIAopmpl
 * @author: biankunpeng
 * @date: 2021年03月29日 15:46
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserInfo> implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public UserInfo Sel(int id) {
        return userMapper.Sel(id);
    }

    @Override
    public boolean addUser(UserInfo userInfo) {
//        userInfo.setId(4561L);
        userInfo.setUserName("kemp");
        userInfo.setPassWord("123456");
        userInfo.setRealName("hhh");
        userInfo.setCreateBy("Admin");
        userInfo.setCreateTime(new Date());
        userInfo.setUpdateBy("Admin");
        userInfo.setUpdateTime(new Date());
        return this.save(userInfo);
    }

    @Override
    public boolean addUserWithNoParam(UserInfo userInfo) {
        userInfo.setUserName("one");
        userInfo.setPassWord("abcdef");
        userInfo.setRealName("ONE");
        return userMapper.insertUserWithUserParam(userInfo) > 0 ? true : false;
    }

    @Override
    public IPage<UserInfo> selectUserPage(Page<UserInfo> userPage, long id) {
        // 不进行 count sql 优化，解决 MP 无法自动优化 SQL 问题，这时候你需要自己查询 count 部分
        // page.setOptimizeCountSql(false);
        // 当 total 为小于 0 或者设置 setSearchCount(false) 分页插件不会进行 count 查询
        // 要点!! 分页返回的对象与传入的对象是同一个
        return baseMapper.selectPageVo(userPage, id);
    }
}
