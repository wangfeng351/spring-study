package com.soft1851.spring.web.service.impl;

import com.soft1851.spring.web.dao.SponsorsDao;
import com.soft1851.spring.web.entity.GithubSponsors;
import com.soft1851.spring.web.service.SponsorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/3/28
 * @Version 1.0
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class SponsorsServiceImpl implements SponsorsService {
    @Autowired
    private SponsorsDao sponsorsDao;

    @Override
    public int[] batchInsert(List<GithubSponsors> sponsors) {
        return sponsorsDao.batchInsert(sponsors);
    }

    @Override
    public List<GithubSponsors> selectAll() {
        return sponsorsDao.selectAll();
    }
}
