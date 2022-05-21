package com.example.springbootdemo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springbootdemo.mapper.UserTest1Mapper;
import com.example.springbootdemo.model.UserTest1;
import com.example.springbootdemo.service.UserTest1Service;
import org.springframework.stereotype.Service;

/**
*
*/
@Service
public class UserTest1ServiceImpl extends ServiceImpl<UserTest1Mapper, UserTest1>
implements UserTest1Service {

}
