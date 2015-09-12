package com.mike.model;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Michael Brennan on 9/8/15.
 */
public class ResponseModel {

    private String method;
    private String authType;
    private String requestUrl;
    private String name;

    public ResponseModel(String name, HttpServletRequest request){

        this.method = request.getMethod();
        this.authType = request.getAuthType();
        this.requestUrl = request.getRequestURL().toString();
        this.name = name;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getAuthType() {
        return authType;
    }

    public void setAuthType(String authType) {
        this.authType = authType;
    }

    public String getRequestUrl() {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
