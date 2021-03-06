package com.mike.domain.repository;

import com.mike.domain.model.Block;
import com.mike.domain.model.Blocks;
import com.mike.domain.repository.impl.JdbcRepository;
import com.mike.util.Constants;
import com.mike.util.Queries;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
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
public class JdbcRepositoryImpl implements JdbcRepository{
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

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
        return jdbcTemplate.update(Queries.INSERT_BLOCK, p);
    }

    public Block getBlockWithId(int id) {

        p = new HashMap();
        p.put("id", id);
        Block block;
        try{
            block = jdbcTemplate.queryForObject(Queries.QUERY_WITH_ID, p, new BeanPropertyRowMapper<>(Block.class));
        } catch (DataAccessException dae){
            logger.error(dae.getMessage());
            return null;
        }
        return block;
    }

    public Blocks getBlocks(String attributeKey,String attributeValue, int limit){

        String sql = null;
        Blocks blocks = new Blocks();
        p = new HashMap();

        switch(attributeKey){
            case(Constants.COLOR):
                sql = limit>0?initLimit(Queries.ALL_BY_COLOR_LIMIT, limit):Queries.ALL_BY_COLOR;
                break;
            case (Constants.PATTERN):
                sql = limit>0?initLimit(initLimit(Queries.ALL_BY_PATTERN_LIMIT, limit), limit):Queries.ALL_BY_PATTERN;
                break;
            case (Constants.SHAPE):
                sql = limit>0?initLimit(Queries.ALL_BY_SHAPE_LIMIT, limit):Queries.ALL_BY_SHAPE;
        }
        p.put(attributeKey, attributeValue);

        try{
            blocks.setBlocks((jdbcTemplate.query(sql, p, new BlockExtractor())));
        }catch (DataAccessException dae){
            logger.error(dae.getMessage());
            return null;
        }
        return blocks;
    }

    public int removeBlock(int id){

        p = new HashMap();
        p.put("id", id);
        return jdbcTemplate.update(Queries.DELETE_BLOCK, p);
    }

    public int updateBlock(int id, Block block){

        p = new HashMap();
        p.put("color", block.getColor());
        p.put("pattern", block.getPattern());
        p.put("shape", block.getShape());
        p.put("id", id);
        return jdbcTemplate.update(Queries.UPDATE_BLOCK, p);
    }

    //helper
    private String initLimit(String sql, int limit){
        p.put("n", limit);
        return sql;
    }
}
