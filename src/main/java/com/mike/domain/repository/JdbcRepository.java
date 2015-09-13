package com.mike.domain.repository;

import com.mike.domain.model.Block;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    public int createBlock(Block block) {
        String SQL = "INSERT INTO block (color, pattern, shape) VALUES (:color, :pattern, :shape)";
        Map n = new HashMap();
        n.put("color",block.getColor() );
        n.put("pattern", block.getPattern());
        n.put("shape", block.getShape());
        return jdbcTemplate.update(SQL, n);
    }

}
