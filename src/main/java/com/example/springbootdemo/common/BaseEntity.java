package com.example.springbootdemo.common;

/**
 * @Description: BaseEntity
 * @author: biankunpeng
 * @date: 2021年03月29日 15:41
 */

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 基础Bean
 */
@Data
public class BaseEntity implements Serializable {

    @TableField(value = "create_by", fill = FieldFill.INSERT) // 新增执行
    private String createBy;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    @ApiModelProperty(hidden = false)
    private Date createTime;

    @TableField(value = "update_by", fill = FieldFill.INSERT_UPDATE) // 新增和更新执行
    private String updateBy;

    @TableField(value = "update_Time", fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
}
