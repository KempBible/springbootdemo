package com.example.springbootdemo.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.example.springbootdemo.common.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description: SysDeptEntity
 * @author: biankunpeng
 * @date: 2021年03月30日 20:33
 */
@Data
public class SysDept extends BaseEntity implements Serializable {

    private static final long serialVersionUID = -7724802953578357368L;

    /**
     * 部门ID
     **/
    @TableId(type = IdType.AUTO)
    @ApiModelProperty(value = "主键")
    private Long deptId;

    /**
     * 部门父节点ID
     **/
    @ApiModelProperty(value = "部门父节点ID")
    private Long parentId;

    /**
     * 部门名称
     **/
    @ApiModelProperty(value = "部门名称")
    private String deptName;

    /**
     * 显示顺序
     **/
    @ApiModelProperty(value = "显示顺序")
    private Integer orderNum;

    /**
     * 用户状态（0：正常 1：禁用）
     **/
    @ApiModelProperty(value = "用户状态")
    private Integer status;
}
