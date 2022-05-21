package com.example.springbootdemo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springbootdemo.domain.HrDepartment;
import com.example.springbootdemo.service.HrDepartmentService;
import com.example.springbootdemo.mapper.HrDepartmentMapper;
import org.springframework.stereotype.Service;

/**
*
*/
@Service
public class HrDepartmentServiceImpl extends ServiceImpl<HrDepartmentMapper, HrDepartment>
implements HrDepartmentService{

}
