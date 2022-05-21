package com.example.springbootdemo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springbootdemo.mapper.UserTest1Mapper;
import com.example.springbootdemo.model.UserTest1;
import com.example.springbootdemo.service.UserTest1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* 测试用户实现类
*/
@Service
public class UserTest1ServiceImpl extends ServiceImpl<UserTest1Mapper, UserTest1> implements UserTest1Service {

    @Autowired
    private UserTest1Mapper userTest1Mapper;

    @Override
    public List<UserTest1> likeListUser(String username) {
        //Step1:创建一个QueryWrapper对象
        QueryWrapper<UserTest1> queryWrapper = new QueryWrapper<>();

        //Step2:构造查询操作
        queryWrapper.select("username", "age")//需要查询得字段
                //.eq("age","20") //查询条件
                .like("username", username);//模糊查询
        //  Step3：执行查询
        List<UserTest1> userTestList = userTest1Mapper.selectList(queryWrapper);

        return userTestList;
    }

    @Override
    public List<UserTest1> pageList(int current, int size) {
        // Step1：创建一个 Page 对象   从0条开始 每页显示5条
        Page page = new Page(current, size);
        // Page<User> page = new Page<>(2, 5);
        QueryWrapper<UserTest1> queryWrapper = new QueryWrapper<>();

        // Step2：调用 mybatis-plus 提供的分页查询方法  .getRecords取出集合数据 不取的话会返回一些其它值
        List<UserTest1> userTest1List = this.page(page, queryWrapper).getRecords();

        // Step3：获取分页数据
        System.out.println(page.getCurrent()); //获取当前页
        System.out.println(page.getTotal()); //获取总记录数
        System.out.println(page.getSize()); //获取每页的条数 默认10
        System.out.println(page.getRecords()); //获取每页数据的集合
        System.out.println(page.getPages()); //获取总页数
        System.out.println(page.hasNext()); //是否存在下一页
        System.out.println(page.hasPrevious()); //是否存在上一页

        return userTest1List;
    }

    @Override
    public int addUser(UserTest1 userTest1) {
        return userTest1Mapper.insert(userTest1);
    }

    @Override
    public boolean deleteUser(int id) {
        //可能因版本不同 这里的删除方法可能不同 具体看官方文档
        return this.removeById(id);
    }
}
