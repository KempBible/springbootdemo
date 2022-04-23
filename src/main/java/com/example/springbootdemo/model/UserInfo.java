package com.example.springbootdemo.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.example.springbootdemo.common.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: UserInfo
 * @author: biankunpeng
 * @date: 2021年03月25日 15:03
 */
@Data
@ApiModel("用户实体类")
@TableName(value = "user_info")
public class UserInfo extends BaseEntity implements Serializable {

    private static final long serialVersionUID = -334637726854637624L;

    // https://blog.csdn.net/qq_34208844/article/details/88819467?spm=1001.2101.3001.6650.3&utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7ELandingCtr%7ERate-3.queryctrv4&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7ELandingCtr%7ERate-3.queryctrv4&utm_relevant_index=6
    // 主键自增 数据库中需要设置主键自增 long类型的不需要加这个注解
    // @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "用户名")
    private String userName;

    @ApiModelProperty(value = "密码")
    private String passWord;

    @ApiModelProperty(value = "真实名称")
    private String realName;

    @TableLogic
    @TableField(select = false)
    @ApiModelProperty(value = "是否删除")
    private Integer deleted;

    @ApiModelProperty(value = "真实名称")
    private String createBy;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "更新人")
    private String updateBy;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;
}
