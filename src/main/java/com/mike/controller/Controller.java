package com.mike.controller;

import com.mike.domain.model.Block;
import com.mike.domain.model.Blocks;
import com.mike.domain.model.ResponseModel;
import com.mike.service.BlockService;
import com.mike.util.Constants;
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

    private Blocks blocks;

    @Autowired
    BlockService blockService;

    @RequestMapping("/id/{id}")
    public ResponseEntity<Block> getBlock(HttpServletRequest request, HttpServletResponse response, @PathVariable int id){
            //TODO CREATE BETTER ERROR OUTPUT
            return new ResponseEntity<>(blockService.getBlock(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/id/{id}", method = RequestMethod.PUT)
    public ResponseEntity<ResponseModel> updateBlock(HttpServletRequest request, HttpServletResponse response, @PathVariable int id, @RequestBody Block block){
        //TODO CREATE BETTER ERROR OUTPUT
        return new ResponseEntity<>(new ResponseModel(blockService.updateBlock(id, block), request), HttpStatus.OK);
    }

    @RequestMapping(value = "/id/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<ResponseModel> deleteBlock(HttpServletRequest request, HttpServletResponse response, @PathVariable int id){
        //TODO CREATE BETTER ERROR OUTPUT
        return new ResponseEntity<>(new ResponseModel(blockService.removeBlock(id), request), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<ResponseModel> createBlock(HttpServletRequest request, HttpServletResponse response, @RequestBody Block block){
        logger.info("Request to insert block");
        if (validateBlock(block)){
            return new ResponseEntity<>(new ResponseModel(0, request), HttpStatus.BAD_REQUEST);
        }
        //TODO CREATE BETTER ERROR OUTPUT
        return new ResponseEntity<>(new ResponseModel(blockService.addBlock(block), request), HttpStatus.OK);
    }

    @RequestMapping("/blocks/color/{color}/limit/{limit}")
    public ResponseEntity<Blocks> getBlocksByColor(HttpServletRequest request, HttpServletResponse response, @PathVariable String color,@PathVariable int limit ){
        blocks = blockService.getBlocksByAttribute(Constants.COLOR, color, limit);
        //TODO CREATE BETTER ERROR OUTPUT
        return new ResponseEntity<>(blocks, HttpStatus.OK);
    }

    @RequestMapping("/blocks/pattern/{pattern}/limit/{limit}")
    public ResponseEntity<Blocks> getBlocksByPattern(HttpServletRequest request, HttpServletResponse response, @PathVariable String pattern, @PathVariable int limit){
        blocks = blockService.getBlocksByAttribute(Constants.PATTERN, pattern, limit);
        //TODO CREATE BETTER ERROR OUTPUT
        return new ResponseEntity<>(blocks, HttpStatus.OK);
    }

    @RequestMapping("/blocks/shape/{shape}/limit/{limit}")
    public ResponseEntity<Blocks> getBlocksByShape(HttpServletRequest request, HttpServletResponse response, @PathVariable String shape, @PathVariable int limit){
        blocks = blockService.getBlocksByAttribute(Constants.SHAPE, shape, limit);
        //TODO CREATE BETTER ERROR OUTPUT
        return new ResponseEntity<>(blocks, HttpStatus.OK);
    }
    /*
    need to be able to update
    error objects in spring http://springinpractice.com/2013/10/09/generating-json-error-object-responses-with-spring-web-mvc
     */
    //helper
    private boolean validateBlock(Block block){
        return  block.getColor() == null || block.getColor().length() > 45 ||
                block.getPattern() == null || block.getPattern().length() > 45 ||
                block.getShape() == null || block.getPattern().length() > 45;
    }



}
