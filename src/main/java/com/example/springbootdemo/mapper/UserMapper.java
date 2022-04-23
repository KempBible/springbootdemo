package com.example.springbootdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springbootdemo.model.UserInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Description: UserMapper
 * @author: biankunpeng
 * @date: 2021年03月25日 15:07
 */
@Repository
public interface UserMapper extends BaseMapper<UserInfo> {

    UserInfo Sel(int id);

    @Insert("INSERT INTO userInfo (user_name, pass_word, real_name) VALUES(#{userName}, #{passWord}, #{realName})")
    int insertUserWithUserParam(UserInfo userInfo);

    //可以继承或者不继承BaseMapper

    /**
     * <p>
     * 查询 : 根据state状态查询用户列表，分页显示
     * 注意!!: 如果入参是有多个,需要加注解指定参数名才能在xml中取值
     * </p>
     *
     * @param page  分页对象,xml中可以从里面进行取值,传递参数 Page 即自动分页,必须放在第一位(你可以继承Page实现自己的分页对象)
     * @param state 状态
     * @return 分页对象
     */
    IPage<UserInfo> selectPageVo(Page page, @Param("id") Long id);
}
