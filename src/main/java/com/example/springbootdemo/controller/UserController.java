package com.example.springbootdemo.controller;
/**
 * @Description: UserController
 * @author: biankunpeng
 * @date: 2021年03月25日 15:04
 */

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springbootdemo.common.PageEntity;
import com.example.springbootdemo.model.UserInfo;
import com.example.springbootdemo.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/testBoot")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation("通过Id查询")
    @RequestMapping(value = "getUser/{id}", method = RequestMethod.GET)
    public String GetUser(@PathVariable int id) {
        return userService.Sel(id).toString();
    }

    @ApiOperation("查询所有数据")
    @RequestMapping(value = "getUsers", method = RequestMethod.GET)
    public List<UserInfo> getUsers() {
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        return userService.list(queryWrapper);
    }

    @ApiOperation("添加用户/测试POJO默认值")
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public boolean addUser() {
        //只新建，不设值
        return userService.addUser(new UserInfo());
    }

    @ApiOperation("添加用户")
    @RequestMapping(value = "/addUserWithNoParam", method = RequestMethod.POST)
    public boolean addUserWithNoParam() {
        return userService.addUserWithNoParam(new UserInfo());
    }

    @ApiOperation("修改用户")
    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    public boolean updateUser() {
        UserInfo userInfo = userService.getById(1);
        userInfo.setRealName("张三2");
        return userService.updateById(userInfo);
    }

    @ApiOperation("删除用户")
    @RequestMapping(value = "/deleteUser", method = RequestMethod.DELETE)
    public boolean deleteUser(Long id) {
        return userService.removeById(id);
    }

    @ApiOperation("分页查询")
    @RequestMapping(value = "/getUserPage", method = RequestMethod.GET)
    public IPage<UserInfo> getUserPage() {
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<UserInfo>().ge("id", "0");
        IPage<UserInfo> userIPage = userService.page(new Page<>(PageEntity.pageNum, PageEntity.pageSize), queryWrapper);
        return userIPage;
    }

    @ApiOperation("XML分页查询")
    @RequestMapping(value = "/getUserPageXML", method = RequestMethod.GET)
    public IPage<UserInfo> getUserPageXML() {
        Page<UserInfo> userPage = new Page<>(1, 2);
        IPage<UserInfo> iPage = userService.selectUserPage(userPage, 1L);
        System.out.println("总页数：" + iPage.getPages());
        System.out.println("总记录数：" + iPage.getTotal());
        List<UserInfo> mpUserInfoList1 = iPage.getRecords();
        mpUserInfoList1.forEach(System.out::println);
        return iPage;
    }
}