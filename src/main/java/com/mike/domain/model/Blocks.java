package com.mike.domain.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Michael Brennan on 9/12/15.
 */
public class Blocks implements Serializable {

    List<Block> blocks;

    public List<Block> getBlocks() {
        return blocks;
    }

    public void setBlocks(List<Block> blocks) {
        this.blocks = blocks;
    }
}
