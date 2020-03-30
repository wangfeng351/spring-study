package com.soft1851.spring.web.service;

import com.soft1851.spring.web.entity.Topic;

import java.util.List;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/3/27
 * @Version 1.0
 */
public interface TopicService {

    int[] batchInsert(List<Topic> list);
}
