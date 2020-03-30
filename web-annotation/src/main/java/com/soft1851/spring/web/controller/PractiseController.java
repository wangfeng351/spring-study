package com.soft1851.spring.web.controller;

import com.alibaba.fastjson.JSON;
import com.soft1851.spring.web.service.BookService;
import com.soft1851.spring.web.service.SponsorsService;
import com.soft1851.spring.web.util.ResponseObject1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/3/28
 * @Version 1.0
 */
@Controller
@RequestMapping(value = "/")
public class PractiseController {
    @Autowired
    private BookService bookService;
    @Autowired
    private SponsorsService sponsorsService;

    @GetMapping("practise")
    public String practise(Model model){
        model.addAttribute("books", bookService.selectAll());
        model.addAttribute("sponsors", sponsorsService.selectAll());
        return "templates/practise";
    }

    @RequestMapping(value = "list",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getForums(){
        ResponseObject1 ro = new ResponseObject1(1, "成功", sponsorsService.selectAll());
        System.out.println(ro);
        return JSON.toJSON(ro).toString();
    }
}
