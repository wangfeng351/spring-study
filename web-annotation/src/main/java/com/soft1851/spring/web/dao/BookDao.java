package com.soft1851.spring.web.dao;

import com.soft1851.spring.web.entity.Book;

import java.util.List;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/3/28
 * @Version 1.0
 */
public interface BookDao {

    /**
     * 批量新增
     *
     * @return int[]
     */
    int[] batchInsert(List<Book> books);

    /**
     * 查询所有数据
     *
     * @return List<Book>
     */
    List<Book> selectAll();
}
