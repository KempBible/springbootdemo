package com.example.springbootdemo.controller;

import com.example.springbootdemo.model.UserTest1;
import com.example.springbootdemo.service.UserTest1Service;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/CrudTestUser")
    public List<UserTest1> CrudTestUser(@RequestParam("username") String username){
        //Dto和DtoUtil是我自己封装的工具类 同志们直接返回List就行
        return userTest1Service.likeListUser(username);
    }

    @GetMapping("/pageList")
    public List<UserTest1> pageList(@RequestParam("current")int current, @RequestParam("size")int size){
        //Dto和DtoUtil是我自己封装的工具类 同志们直接返回List就行
        return userTest1Service.pageList(current, size);
    }

    @PostMapping("addUser")
    public String addUser(@RequestBody UserTest1 userTest1){
        int num = userTest1Service.addUser(userTest1);
        if (num > 0){
            return "添加成功";
       }else {
            return "添加失败";
        }
    }

    @DeleteMapping("deleteUser")
    public String deleteUser(@RequestParam("id") int id){
        if (userTest1Service.deleteUser(id)){
            return "删除成功";
        }else {
            return "删除失败";
        }
    }

    @GetMapping("testVersion")
    public void testVersion(){
        UserTest1 userTest1 = new UserTest1();
        userTest1.setUsername("tom");
        userTest1.setAge(10);
        userTest1.setTel(120);
        //先执行插入操作
        userTest1Service.addUser(userTest1);

        //查询一次
        userTest1Service.list().forEach(System.out::println);
        userTest1.setUsername("jarry");
        //执行修改操作
        userTest1Service.update(userTest1, null);
        //再查询一次
        userTest1Service.list().forEach(System.out::println);
    }

    @PostMapping("testVersion1")
    public void testVersion1(){
        UserTest1 userTest1 = userTest1Service.getById(37);
        System.out.println(userTest1);
        userTest1.setUsername("jarry");
        //执行修改操作
        userTest1Service.update(userTest1, null);
        //再查询一次
        System.out.println(userTest1Service.getById(37));
    }


}
