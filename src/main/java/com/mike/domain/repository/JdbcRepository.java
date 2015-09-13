package com.mike.domain.repository;

import com.mike.domain.model.Block;
import com.mike.util.Queries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Michael Brennan on 9/12/15.
 */
@Repository
public class JdbcRepository {

    private NamedParameterJdbcTemplate jdbcTemplate;
    private Map p;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    public int createBlock(Block block) {

        p = new HashMap();
        p.put("color", block.getColor());
        p.put("pattern", block.getPattern());
        p.put("shape", block.getShape());
        return jdbcTemplate.update(Queries.INSERT_SQL, p);
    }

    public Block getBlockWithId(int id) {
        p = new HashMap();
        p.put("id", id);
        return jdbcTemplate.queryForObject(Queries.QUERY_WITH_ID,p, new BeanPropertyRowMapper<>(Block.class));
    }
}
