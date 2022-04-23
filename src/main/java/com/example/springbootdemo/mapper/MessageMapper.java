package com.example.springbootdemo.mapper;

import com.example.springbootdemo.model.Message;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MessageMapper {

    Message selectByPrimaryKey(Long id);

    List<Message> selectAll();

    List<Message> getMessById(Long id);

    Boolean detele(Long id);

    Boolean add(Message appMessage);
}