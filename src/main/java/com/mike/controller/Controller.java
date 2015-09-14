package com.mike.controller;

import com.mike.domain.model.Block;
import com.mike.domain.model.Blocks;
import com.mike.domain.model.ResponseModel;
import com.mike.exception.BlockException;
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
import java.io.IOException;

/**
 * Created by Michael Brennan on 9/8/15.
 */
@RestController
@RequestMapping("/block")
public class Controller {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private Blocks blocks;
    private Block block;

    @Autowired
    BlockService blockService;

    @RequestMapping("/id/{id}")
    public ResponseEntity<Block> getBlock(HttpServletRequest request, HttpServletResponse response, @PathVariable int id) {
        block = blockService.getBlock(id);
        if(block == null){
            throw new BlockException();
        }
        return new ResponseEntity<>(block, HttpStatus.OK);
    }

    @RequestMapping(value = "/id/{id}", method = RequestMethod.PUT)
    public ResponseEntity<ResponseModel> updateBlock(HttpServletRequest request, HttpServletResponse response, @PathVariable int id, @RequestBody Block block){
        int i = blockService.updateBlock(id, block);
        if (i != 1){
            throw new BlockException();
        }
        return new ResponseEntity<>(new ResponseModel(i, request), HttpStatus.OK);
    }

    @RequestMapping(value = "/id/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<ResponseModel> deleteBlock(HttpServletRequest request, HttpServletResponse response, @PathVariable int id){
        int i = blockService.removeBlock(id);
        if (i != 1){
            throw new BlockException();
        }
        return new ResponseEntity<>(new ResponseModel(i, request), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<ResponseModel> createBlock(HttpServletRequest request, HttpServletResponse response, @RequestBody Block block){
        int i = blockService.addBlock(block);
        if (validateBlock(block) || i != 1){
            throw new BlockException();
        }
        return new ResponseEntity<>(new ResponseModel(i, request), HttpStatus.OK);
    }

    @RequestMapping("/blocks/color/{color}/limit/{limit}")
    public ResponseEntity<Blocks> getBlocksByColor(HttpServletRequest request, HttpServletResponse response, @PathVariable String color,@PathVariable int limit ){
        blocks = blockService.getBlocksByAttribute(Constants.COLOR, color, limit);
        if(blocks == null){
            throw new BlockException();
        }
        return new ResponseEntity<>(blocks, HttpStatus.OK);
    }

    @RequestMapping("/blocks/pattern/{pattern}/limit/{limit}")
    public ResponseEntity<Blocks> getBlocksByPattern(HttpServletRequest request, HttpServletResponse response, @PathVariable String pattern, @PathVariable int limit){
        blocks = blockService.getBlocksByAttribute(Constants.PATTERN, pattern, limit);
        if(blocks == null){
            throw new BlockException();
        }
        return new ResponseEntity<>(blocks, HttpStatus.OK);
    }

    @RequestMapping("/blocks/shape/{shape}/limit/{limit}")
    public ResponseEntity<Blocks> getBlocksByShape(HttpServletRequest request, HttpServletResponse response, @PathVariable String shape, @PathVariable int limit){
        blocks = blockService.getBlocksByAttribute(Constants.SHAPE, shape, limit);
        if(blocks == null){
            throw new BlockException();
        }
        return new ResponseEntity<>(blocks, HttpStatus.OK);
    }

    @ExceptionHandler(BlockException.class)
    public void myError(HttpServletRequest request, HttpServletResponse response, Exception exception) throws IOException {

        switch (request.getMethod()){
            case(Constants.POST):
                response.sendError(HttpStatus.BAD_REQUEST.value(),Constants.FAILURE_POST);
                return;
            case (Constants.PUT):
                response.sendError(HttpStatus.BAD_REQUEST.value(),Constants.FAILURE_PUT);
                return;
            case(Constants.DELETE):
                response.sendError(HttpStatus.BAD_REQUEST.value(),Constants.FAILURE_POST);
                return;
            default:
                response.sendError(HttpStatus.BAD_REQUEST.value(), "Resource not found, invalid ID");
        }

    }

    //helper
    private boolean validateBlock(Block block){
        return  block.getColor() == null || block.getColor().length() > 45 ||
                block.getPattern() == null || block.getPattern().length() > 45 ||
                block.getShape() == null || block.getPattern().length() > 45;
    }



}
