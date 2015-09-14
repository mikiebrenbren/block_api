package com.mike.util;

/**
 * Created by Michael Brennan on 9/12/15.
 */
public class Constants {

    public static final String SUCCESS = "BLOCK HAS SUCCESSFULLY ";
    public static final String SUCCESS_PUT = SUCCESS + "BEEN UPDATED ";
    public static final String SUCCESS_DELETE = SUCCESS + "BEEN DELETED ";
    public static final String SUCCESS_POST = SUCCESS + "BEEN CREATED ";

    public static final String FAILURE = "BLOCK WAS UNSUCCESSFUL CHECK ID, OR JSON PAYLOAD FOR VALIDITY";
    public static final String FAILURE_PUT =  "ATTEMPT TO UPDATE " + FAILURE;
    public static final String FAILURE_DELETE = "ATTEMPT TO DELETE WAS UNSUCCESSFUL CHECK ID FOR VALIDITY";
    public static final String FAILURE_POST = "ATTEMPT TO CREATE " + FAILURE;

    public static final String COLOR = "color";
    public static final String PATTERN = "pattern";
    public static final String SHAPE = "shape";

    public static final String POST = "POST";
    public static final String PUT = "PUT";
    public static final String DELETE = "DELETE";

}
