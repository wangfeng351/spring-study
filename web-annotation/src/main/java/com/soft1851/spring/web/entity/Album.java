package com.soft1851.spring.web.entity;

import lombok.Data;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/3/24
 * @Version 1.0
 */
@Data
public class Album {
    private String name;
    private String url;

    public Album(String name, String url) {
        this.name = name;
        this.url = url;
    }
}
