package com.soft1851.spring.web.dao.impl;

import com.soft1851.spring.web.dao.TopicDao;
import com.soft1851.spring.web.entity.Topic;
import org.springframework.beans.factory.annotation.Autowired;
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
 * @Date 2020/3/26
 * @Version 1.0
 */
@Repository
public class TopicDaoImpl implements TopicDao {
    private final JdbcTemplate jdbcTemplate;

    public TopicDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Topic> selectAll() {
        String sql = "SELECT * FROM t_topic";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Topic.class));
    }

    @Override
    public int[] batchInsert(List<Topic> topics) {
        final List<Topic> topicList = topics;
        String sql = "INSERT INTO t_topic(id, topic_name, topic_icon, description, follows_count, msg_count, followed)" +
                " VALUES(?, ?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                preparedStatement.setString(1, topicList.get(i).getId());
                preparedStatement.setString(2, topicList.get(i).getTopicName());
                preparedStatement.setString(3, topicList.get(i).getDescription());
                preparedStatement.setString(4, topicList.get(i).getDescription());
                preparedStatement.setInt(5, topicList.get(i).getFollowsCount());
                preparedStatement.setInt(6, topicList.get(i).getMsgCount());
                preparedStatement.setBoolean(7, topicList.get(i).getFollowed());
            }

            @Override
            public int getBatchSize() {
                return topicList.size();
            }
        });
    }

    @Override
    public int insert(Topic topic) {
        return 0;
    }
}
