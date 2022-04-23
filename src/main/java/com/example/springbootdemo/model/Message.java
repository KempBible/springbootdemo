package com.example.springbootdemo.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "发送信息")
public class Message {

    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "信息")
    private String message = "我最帅";

    @ApiModelProperty(value = "发送时间")
    private Date senddate = new Date();
}