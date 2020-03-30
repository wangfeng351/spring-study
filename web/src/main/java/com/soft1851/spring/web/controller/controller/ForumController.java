package com.soft1851.spring.web.controller.controller;

import com.alibaba.fastjson.JSON;
import com.soft1851.spring.web.controller.service.ForumService;
import com.soft1851.spring.web.controller.util.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/3/21
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "forum")
public class ForumController {
    @Autowired
    private ForumService forumService;

    @RequestMapping(value = "/list",produces = "application/json;charset=utf-8")
    public String getForums(){
        ResponseObject ro = new ResponseObject(1,"成功",forumService.selectAll());
        return JSON.toJSONString(ro);
    }

    @RequestMapping(value = "/single/{id}",produces = "application/json;charset=utf-8" )
    public String getForumById(@PathVariable int id){
        ResponseObject ro = new ResponseObject(1,"成功",forumService.get(id));
        return JSON.toJSONString(ro);
    }

    @RequestMapping(value = "/keyword",produces = "application/json;charset=utf-8" )
    public String getForumByKeyword(){
        ResponseObject ro = new ResponseObject(1, "成功", forumService.getByKeyword());
        return JSON.toJSONString(ro);
    }
}