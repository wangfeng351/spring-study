package com.soft1851.spring.web.controller.dao;

import com.soft1851.spring.web.controller.entity.Forum;

import java.util.List;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/3/21
 * @Version 1.0
 */
public interface ForumDao {


    /**
     * 根据id查询Forum
     * @param forumId
     * @return Forum
     */
    Forum get(int forumId);

    /**
     * 查询所有论坛信息
     * @return List<Forum>
     */
    List<Forum> selectAll();

    /**
     * 根据关键字查询post
     * @return List<Post>
     */
    List<Forum> getByKeywords(String keywords);
}

