package com.soft1851.spring.web.dao;

import com.soft1851.spring.web.entity.Topic;

import java.util.List;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/3/26
 * @Version 1.0
 */
public interface TopicDao {
    /**
     * 查询所有
     *
     * @return List<Topic>
     */
    List<Topic> selectAll();

    /**
     * 批量插入
     *
     * @return int[]
     */
    int[] batchInsert(List<Topic> topics);

    /**
     * 单个新增
     *
     * @return int
     */
    int insert(Topic topic);
}
