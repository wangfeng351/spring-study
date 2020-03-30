package com.soft1851.spring.web.dao;

import com.soft1851.spring.web.entity.GithubSponsors;

import java.util.List;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/3/28
 * @Version 1.0
 */
public interface SponsorsDao {

    /**
     * 批量插入
     *
     * @return int[]
     */
    int[] batchInsert(List<GithubSponsors> list);

    /**
     * 查询所有
     *
     * @return List<GithubSponsors>
     */
    List<GithubSponsors> selectAll();
}
