package com.example.springbootdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springbootdemo.model.SysDept;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description: SysDeptMapper
 * @author: biankunpeng
 * @date: 2021年03月30日 20:46
 */
@Repository
public interface SysDeptMapper extends BaseMapper<SysDept> {

    List<SysDept> getSysDeptList();
}
