package com.mike.service;

import com.mike.domain.model.Block;
import com.mike.domain.repository.JdbcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by michaelbrennan on 9/12/15.
 */
@Service
public class BlockService {

    @Autowired
    JdbcRepository jdbcRepository;

    public int addBlock(Block block){
        return jdbcRepository.createBlock(block);
    }
}
