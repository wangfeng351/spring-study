package com.soft1851.spring.web.controller;

import com.soft1851.spring.web.entity.Album;
import com.soft1851.spring.web.entity.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/3/24
 * @Version 1.0
 */
@Controller
public class HomeController {
    @GetMapping("/")
    public String home(Model model){
        //使用model接口将数据返回到客户端
        model.addAttribute("message", "Hello Spring MVC~~");
        Album[] albums = {
                new Album("最爱", "http://ww1.sinaimg.cn/large/0084EtCNgy1gd59e9j424j30e809idgp.jpg"),
                new Album("女歌手", "http://ww1.sinaimg.cn/large/0084EtCNgy1gd59e9kuqpj30zk0k0q4y.jpg"),
                new Album("没有", "http://ww1.sinaimg.cn/large/0084EtCNgy1gd59e9iys7j30zk0k00v1.jpg"),
                new Album("之一", "http://ww1.sinaimg.cn/large/0084EtCNgy1gd59e9g5jkj30k00k0dgy.jpg"),
                new Album("最爱", "http://ww1.sinaimg.cn/large/0084EtCNgy1gd59e9gisqj30e808w75b.jpg"),
                new Album("女演员", "http://ww1.sinaimg.cn/large/0084EtCNgy1gd59e9i76xj30e808wgma.jpg"),
                new Album("没有", "http://ww1.sinaimg.cn/large/0084EtCNgy1gd59maa6u0j30k00u0go4.jpg"),
                new Album("之一", "http://ww1.sinaimg.cn/large/0084EtCNgy1gd59mfbl5lj30b40b4q3z.jpg")
        };
        List<Album> albumList = Arrays.asList(albums);
        model.addAttribute("list", albumList);
        //map数据
        Map<String, Object> map = new HashMap<>();
        map.put("message", "以上皆为本人最喜爱的歌手、演员，没有之一");
        model.addAttribute("map", map);
        //对象数据
        Album album = new Album("一位非常有才华的女歌手，多才多艺，弹、唱，rap等都非常棒，音色非常有特色，很容易记住，最爱女歌手没有之一", "http://ww1.sinaimg.cn/large/0084EtCNgy1gd59e9j424j30e809idgp.jpg");
        model.addAttribute("object", album);
        //返回页面
        return "templates/home";
    }

}
