package com.mike.domain.repository.impl;

import com.mike.domain.model.Block;
import com.mike.domain.model.Blocks;

/**
 * Created by michaelbrennan on 9/20/15.
 */
public interface JdbcRepository {

    int removeBlock(int id);
    Blocks getBlocks(String attributeKey,String attributeValue, int limit);
    Block getBlockWithId(int id);
    int createBlock(Block block);
    int updateBlock(int id, Block block);
}
