package com.mike.controller;

import com.mike.domain.model.Block;
import com.mike.domain.model.ResponseModel;
import com.mike.service.BlockService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Michael Brennan on 9/8/15.
 */
@RestController
@RequestMapping("/block")
public class Controller {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    BlockService blockService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<ResponseModel> createBlock(HttpServletRequest request, HttpServletResponse response, @RequestBody Block block){
        logger.info("Request to insert block");
        if (validateBlock(block)){
            return new ResponseEntity<>(new ResponseModel(0, request), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(new ResponseModel(blockService.addBlock(block), request), HttpStatus.OK);
    }

    @RequestMapping("/id/{id}")
    public ResponseEntity<Block> getBlock(HttpServletRequest request, HttpServletResponse response, @PathVariable int id){
            return new ResponseEntity<>(blockService.getBlockWithId(id), HttpStatus.OK);
    }


    /*
    should be able to get all blocks of a certain shape, color, or pattern
    should be able to get as many blocks as possible or limited as specified by the api user
    should be able to add a block to db  todo DONE
    should be able to delete a block from the db
    should be able to get a single block
    should be able to update a block via its id
    should be able to find a block(s) with a certain pattern and shape, a certain pattern and color, and certain color and shape
    make sure to validate requests varchar(45) when updating db
    error objects in spring http://springinpractice.com/2013/10/09/generating-json-error-object-responses-with-spring-web-mvc
     */

    private boolean validateBlock(Block block){
        return  block.getColor() == null || block.getColor().length() > 45 ||
                block.getPattern() == null || block.getPattern().length() > 45 ||
                block.getShape() == null || block.getPattern().length() > 45;
    }



}
