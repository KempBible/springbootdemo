package com.example.springbootdemo.controller;

import com.example.springbootdemo.model.Message;
import com.example.springbootdemo.service.MessageService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/appmessage")
public class MessageController {

    @Autowired
    private MessageService service;

    @RequestMapping(value = "/getThree", method = RequestMethod.GET)
    @ApiOperation(value = "getThree",notes = "author：zhangh")
    public List<Message> getThreeForMessage(@RequestParam("id") Long id){
        List<Message> list = service.getMessage(id);
        return list;
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    @ApiOperation(value = "getAll",notes = "author：zhangh")
    public List<Message> getAllMessage(){

        List<Message> list = service.getAllMessage();
        int num = list.size();
        if(null!=list && num>3){
            for (int i = 0; i < num-3; i++) {
                list.remove(0);
            }
        }
        return list;
    }

    @RequestMapping(value = "/getByID", method = RequestMethod.GET)
    public List<Message> getMessageById(@RequestParam("id") Long id){
        List<Message> list = service.getMessageById(id);
        int num = list.size();
        if(null!=list && num>5){
            for (int i = 0; i < num-5; i++) {
                list.remove(0);
            }
        }
        return list;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    @ApiOperation(value = "delete",notes = "author：bkp")
    public boolean delete(@RequestParam("id") Long id){
        return service.delete(id);
    }

    @ApiOperation("添加信息")
    @RequestMapping(value="/add",method=RequestMethod.POST)
    public boolean add() {
        return service.add(new Message());//只新建，不设值
    }
}