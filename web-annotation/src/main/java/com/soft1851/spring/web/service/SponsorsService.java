package com.soft1851.spring.web.service;

import com.soft1851.spring.web.entity.GithubSponsors;

import java.util.List;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/3/28
 * @Version 1.0
 */
public interface SponsorsService {

    /**
     * 批量新增
     *
     * @return int[]
     */
    int[] batchInsert(List<GithubSponsors> sponsors);

    /**
     * 查询所有信息
     *
     * @return List<GithubSponsors>
     */
    List<GithubSponsors> selectAll();
}
