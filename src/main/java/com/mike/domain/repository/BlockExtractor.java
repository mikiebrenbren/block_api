package com.mike.domain.repository;

import com.mike.domain.model.Block;
import com.mike.util.Constants;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by michaelbrennan on 9/13/15.
 */
public class BlockExtractor implements RowMapper<Block> {
    @Override
    public Block mapRow(ResultSet rs, int rowNum) throws SQLException {
        Block block = new Block();
        block.setColor(rs.getString(Constants.COLOR));
        block.setPattern(rs.getString(Constants.PATTERN));
        block.setShape(rs.getString(Constants.SHAPE));
        block.setId(rs.getInt("id"));
        return block;
    }
}
