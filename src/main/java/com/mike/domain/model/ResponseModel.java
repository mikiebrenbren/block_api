package com.mike.domain.model;

import com.mike.util.Constants;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Michael Brennan on 9/8/15.
 */
public class ResponseModel {

    private String method;
    private String authType;
    private String requestUrl;
    private String successConfirmation;

    public ResponseModel(int i,  HttpServletRequest request){

        this.method = request.getMethod();
        this.authType = request.getAuthType();
        this.requestUrl = request.getRequestURL().toString();
        successConfirmation = i == 1? Constants.SUCCESS : Constants.FAILURE;

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

    public String getSuccessConfirmation() {
        return successConfirmation;
    }

    public void setSuccessConfirmation(String successConfirmation) {
        this.successConfirmation = successConfirmation;
    }
}
