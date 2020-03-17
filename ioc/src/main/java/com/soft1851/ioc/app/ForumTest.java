package com.soft1851.ioc.app;

import com.soft1851.ioc.config.AppConfig;
import com.soft1851.ioc.entity.Forum;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.lang.model.AnnotatedConstruct;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/3/17
 * @Version 1.0
 */
public class ForumTest {
    public static void main(String[] args) {
        //获取
        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(AppConfig.class);
        //scan手动扫包
        ctx.scan("com.soft1851.ioc.config");
        Forum forum = (Forum) ctx.getBean("forum");
        forum.setForumId(2);
        forum.setForumName("老颜");
        System.out.println(forum);
    }
}
