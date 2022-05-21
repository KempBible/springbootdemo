package com.example.springbootdemo.controller.controllerAnnotationrestcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/controller")
public class FileUploadController {

    //跳转到上传文件的页面
    //在对应的方法上，视图解析器可以解析return 的jsp,html页面，并且跳转到相应页面。
    @RequestMapping(value = "/gouploadimg", method = RequestMethod.GET)
    public String goUploadImg(){
        //跳转到 templates 目录下的 uploadimg.html
        return "uploadimg";
    }

    //处理文件上传
    //若返回json等内容到页面，则需要加@RequestBody注解
    @RequestMapping(value = "/testuploadimg", method = RequestMethod.POST)
    public @ResponseBody String uploadImg(@RequestParam("file")MultipartFile file, HttpServletRequest request){
        System.out.println("调用文件上传方法");
        String contentType = file.getContentType();
        String fileName = file.getOriginalFilename();
        return fileName;
    }

}
