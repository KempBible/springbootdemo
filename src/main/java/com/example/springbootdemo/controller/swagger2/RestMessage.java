package com.example.springbootdemo.controller.swagger2;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(description = "返回响应数据")
public class RestMessage {

    @ApiModelProperty(value = "是否成功", required = true)
    private boolean success = true;

    @ApiModelProperty(value = "错误码")
    private Integer errCode;

    @ApiModelProperty(value = "提示信息")
    private String message;

    @ApiModelProperty(value = "数据")
    private Object data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Integer getErrCode() {
        return errCode;
    }

    public void setErrCode(Integer errCode) {
        this.errCode = errCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
