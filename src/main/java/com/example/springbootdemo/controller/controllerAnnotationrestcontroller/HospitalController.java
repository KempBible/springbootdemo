package com.example.springbootdemo.controller.controllerAnnotationrestcontroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController/* @Controller + @ResponseBody*/
public class HospitalController {

    @RequestMapping(value = "/findAllHospital", method = RequestMethod.GET)
    public List<String> findAllHospital(){
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("twe");
        list.add("three");
        return list;
    }
}
