package com.example.springbootdemo.controller;

import com.example.springbootdemo.mapper.UserTest1Mapper;
import com.example.springbootdemo.model.UserTest1;
import com.example.springbootdemo.service.UserTest1Service;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//https://blog.csdn.net/q736317048/article/details/110284582?spm=1001.2101.3001.6650.1&utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7ECTRLIST%7Edefault-1-110284582-blog-123351670.pc_relevant_default&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7ECTRLIST%7Edefault-1-110284582-blog-123351670.pc_relevant_default&utm_relevant_index=2?
/**
 * 测试连接Mybatis-plus
 */
@RestController
@RequestMapping("api/v1/test/my")
public class UserTest1Controller {

    //如果出现红色下划线不影响运行，可以设置idea不报红
    @Autowired
    private UserTest1Service userTest1Service;

    @ApiOperation("查询所有用户信息")
    @GetMapping("/userList")
    public List<UserTest1> test(){
        //直接调用BaseMapper封装好的CRUD方法，就可实现无条件查询数据
        List<UserTest1> list = userTest1Service.list();

        //循环获取用户数据
        for (UserTest1 userTest1:list) {
            System.out.println(userTest1.getUsername());
        }
        return list;
    }
}
