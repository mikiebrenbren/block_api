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
@RequestMapping("/")
public class Controller {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    BlockService blockService;

    @RequestMapping(value = "block", method = RequestMethod.POST)
    public ResponseEntity<ResponseModel> createBlock(HttpServletRequest request, HttpServletResponse response, @RequestBody Block block){
        logger.debug("Request to insert block");
        return new ResponseEntity<>(new ResponseModel(blockService.addBlock(block), request), HttpStatus.OK);
    }


    /*
    should be able to get all blocks of a certain shape, color, or pattern
    should be able to get as many blocks as possible or limited as specified by the api user
    should be able to add a block to db
    should be able to delete a block from the db
    should be able to get a single block
    should be able to update a block via its id as well
    should be able to find a block(s) with a certain pattern and shape, a certain pattern and color, and certain color and shape
    make sure to validate requests varchar(45) and convert json to int
     */




}
