package com.mike.service.impl;

import com.mike.domain.model.Block;
import com.mike.domain.model.Blocks;
import com.mike.domain.repository.JdbcRepository;
import com.mike.service.BlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by michaelbrennan on 9/12/15.
 */
@Service
public class BlockServiceImpl implements BlockService {

    @Autowired
    JdbcRepository jdbcRepository;

    @Override
    public int addBlock(Block block){

        return jdbcRepository.createBlock(block);
    }

    @Override
    public Block getBlockWithId(int id){

        Block block = jdbcRepository.getBlockWithId(id);

        if(block == null){
            return null;  //todo handle this
        }
        return block;
    }

    @Override
    public Blocks getBlocksByAttribute(String attributeKey, String attributeValue, int limit) {

        Blocks blocks = jdbcRepository.getBlocks(attributeKey, attributeValue, limit);

        if(blocks == null){
            return null; //todo handle this
        }
        return blocks;
    }
}
