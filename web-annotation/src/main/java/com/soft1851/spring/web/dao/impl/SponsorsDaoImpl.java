package com.soft1851.spring.web.dao.impl;

import com.soft1851.spring.web.dao.SponsorsDao;
import com.soft1851.spring.web.entity.GithubSponsors;
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
public class SponsorsDaoImpl implements SponsorsDao {
   private final JdbcTemplate jdbcTemplate;

    public SponsorsDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int[] batchInsert(List<GithubSponsors> list) {
        final List<GithubSponsors> sponsorsList = list;
        String sql = "INSERT INTO t_sponsors(avatar, author_name, description) VALUES (?, ?, ?)";
        return jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                preparedStatement.setString(1, sponsorsList.get(i).getAvatar());
                preparedStatement.setString(2, sponsorsList.get(i).getAuthorName());
                preparedStatement.setString(3, sponsorsList.get(i).getDescription());
            }

            @Override
            public int getBatchSize() {
                return sponsorsList.size();
            }
        });
    }

    @Override
    public List<GithubSponsors> selectAll() {
        String sql = "SELECT * FROM t_sponsors";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(GithubSponsors.class));
    }
}
