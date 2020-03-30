package com.soft1851.spring.web.dao.impl;

import com.soft1851.spring.web.dao.BookDao;
import com.soft1851.spring.web.entity.Book;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/3/28
 * @Version 1.0
 */
@Repository
public class BookDaoImpl implements BookDao {
    final private JdbcTemplate jdbcTemplate;

    public BookDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int[] batchInsert(List<Book> books) {
        final List<Book> bookList = books;
        String sql = "INSERT INTO t_book(id, name, price, avatar, author, url)" +
                " VALUES(?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                preparedStatement.setInt(1, bookList.get(i).getId());
                preparedStatement.setString(2, bookList.get(i).getName());
                preparedStatement.setDouble(3, bookList.get(i).getPrice());
                preparedStatement.setString(4, bookList.get(i).getAvatar());
                preparedStatement.setString(5, bookList.get(i).getAuthor());
                preparedStatement.setString(6, bookList.get(i).getUrl());
            }

            @Override
            public int getBatchSize() {
                return bookList.size();
            }
        });
    }

    @Override
    public List<Book> selectAll() {
        String sql = "SELECT * FROM t_book";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Book.class));
    }
}
