package com.example.springbootdemo.controller.swagger2;

import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

@Api(tags = "用户模板")
@RestController("user")
public class UserController {

    @ApiOperation(value = "用户登录", notes = "随便说点啥")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(name = "mobile", value = "手机号", required = true, paramType = "form"),
                    @ApiImplicitParam(name = "password", value = "密码", required = true, paramType = "form"),
                    @ApiImplicitParam(name = "age", value = "年龄", required = true, paramType = "form", dataType = "Integer")
            }
    )
    @ApiResponses({
            @ApiResponse(code = 200, message = "请求成功"),
            @ApiResponse(code = 400, message = "请求参数没填好"),
            @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")
    })
    @ResponseBody
    @PostMapping("/login")
    public Object login(@RequestParam String mobile, @RequestParam String password, @RequestParam Integer age){
        return mobile + password + age;
    }

    @ApiOperation(value = "用户登录", notes = "接口描述可以写很多东西")
    @PostMapping(value = "/login1")
    public RestMessage login1(@RequestBody UserLoginVO userLoginVO){
        RestMessage hi = new RestMessage();
        hi.setData(userLoginVO);
        return hi;
    }
}
