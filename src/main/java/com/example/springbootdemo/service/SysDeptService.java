package com.example.springbootdemo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.springbootdemo.model.SysDept;

public interface SysDeptService extends IService<SysDept> {

    void add(SysDept deptEntity);
}
