package com.soft1851.spring.web.controller.service.impl;

import com.soft1851.spring.web.controller.dao.ForumDao;
import com.soft1851.spring.web.controller.entity.Forum;
import com.soft1851.spring.web.controller.service.ForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/3/21
 * @Version 1.0
 */
@Service
public class ForumServiceImpl implements ForumService {
    @Autowired
    private ForumDao forumDao;

    @Override
    public Forum get(int forumId) {
        return forumDao.get(forumId);
    }

    @Override
    public List<Forum> selectAll() {
        return forumDao.selectAll();
    }

    @Override
    public List<Forum> getByKeyword() {

        return forumDao.getByKeywords("测试");
    }
}
