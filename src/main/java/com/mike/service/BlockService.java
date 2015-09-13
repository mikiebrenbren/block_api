package com.mike.service;

import com.mike.domain.model.Block;
import com.mike.domain.model.Blocks;

/**
 * Created by michaelbrennan on 9/13/15.
 */
public interface BlockService {

    int addBlock(Block block);

    Block getBlock(int id);

    Blocks getBlocksByAttribute(String attributeKey, String attributeValue, int limit);

    int removeBlock(int id);

    int updateBlock(int id, Block block);
}
