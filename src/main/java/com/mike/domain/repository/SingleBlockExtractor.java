package com.mike.domain.repository;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by michaelbrennan on 9/12/15.
 */
public class SingleBlockExtractor implements RowMapper{
    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        return null;
    }
}
