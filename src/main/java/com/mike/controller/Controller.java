package com.mike.controller;

import com.mike.model.ResponseModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Michael Brennan on 9/8/15.
 */
@RestController
@RequestMapping("/")
public class Controller {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("hello/{name}")
    public ResponseEntity<ResponseModel> helloWorld(HttpServletRequest request, HttpServletResponse response, @PathVariable final String name){
        logger.debug("This is the name: " + name);
        return new ResponseEntity<>(new ResponseModel(name, request), HttpStatus.OK);
    }


}
