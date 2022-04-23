package com.example.springbootdemo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springbootdemo.mapper.SysDeptMapper;
import com.example.springbootdemo.model.SysDept;
import com.example.springbootdemo.service.SysDeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Description: SysDeptServiceImpl
 * @author: biankunpeng
 * @date: 2021年03月30日 20:44
 */
@Slf4j
@Service
public class SysDeptServiceImpl extends ServiceImpl<SysDeptMapper, SysDept> implements SysDeptService {

    @Override
    public void add(SysDept deptEntity) {
        this.save(deptEntity);
    }
}
