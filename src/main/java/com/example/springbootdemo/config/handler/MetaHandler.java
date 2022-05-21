package com.example.springbootdemo.config.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Description: MetaHandler
 * @author: biankunpeng
 * @date: 2021年03月29日 14:38
 */
@Component
@Configuration
public class MetaHandler implements MetaObjectHandler {

    /**
     * 新增数据执行
     * @param metaObject
     */
    @Override
    public void insertFill(MetaObject metaObject) {
//        SysUserEntity userEntity = ShiroUtil.getUser();
        boolean hasCreateTime = metaObject.hasSetter("createTime");
        if (hasCreateTime){
            this.setFieldValByName("createTime", new Date(), metaObject);
        }
//        this.setFieldValByName("createBy", userEntity.getLoginName(), metaObject);
        boolean hasUpdateTime = metaObject.hasSetter("updateTime");
        if(hasUpdateTime){
            this.setFieldValByName("updateTime", new Date(), metaObject);
        }
//        this.setFieldValByName("updateBy", userEntity.getLoginName(), metaObject);

        this.strictInsertFill(metaObject, "version", Integer.class, 1);
    }

    /**
     * 更新数据执行
     * @param metaObject
     */
    @Override
    public void updateFill(MetaObject metaObject) {
//        SysUserEntity userEntity = ShiroUtil.getUser();
        boolean hasUpdateTime = metaObject.hasSetter("updateTime");
        if(hasUpdateTime){
            this.setFieldValByName("updateTime", new Date(), metaObject);
        }
//        this.setFieldValByName("updateBy", userEntity.getLoginName(), metaObject);
    }

}