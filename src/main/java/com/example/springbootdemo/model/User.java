package com.example.springbootdemo.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @description:
 * @author: biankunpeng
 * @date: 2022/3/8 16:39
 */
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 4845255464498282154L;

    private String id;
    private String username;
    private String password;
    private String email;
    private Date birthday;
    private String gender;
    private String mobile;
    private String nickname;
}