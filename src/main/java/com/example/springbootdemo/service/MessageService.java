package com.example.springbootdemo.service;

import com.example.springbootdemo.mapper.MessageMapper;
import com.example.springbootdemo.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: AppMessageService
 * @author: biankunpeng
 * @date: 2021年03月25日 16:10
 */

@Service("messageService")
public class MessageService {

    @Autowired
    private MessageMapper messageMapper;

    public List<Message> getMessage(Long id) {
        List<Message> list = new ArrayList<Message>();
        list.add(messageMapper.selectByPrimaryKey(id));
        //list = mapper.selectAll();
        return list;
    }

    public List<Message> getAllMessage() {
        List<Message> list = new ArrayList<Message>();
        list = messageMapper.selectAll();
        return list;
    }


    public List<Message> getMessageById(Long id) {
        return messageMapper.getMessById(id);
    }

    public boolean delete(Long id) {
        return messageMapper.detele(id);
    }

    public boolean add(Message appMessage) {
        return messageMapper.add(appMessage);
    }
}
