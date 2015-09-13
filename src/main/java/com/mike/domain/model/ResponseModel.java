package com.mike.domain.model;

import com.mike.util.Constants;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by Michael Brennan on 9/8/15.
 */
public class ResponseModel {

    private String method;
    private String requestUrl;
    private String successConfirmation;
    private Date timeStamp;

    public ResponseModel(int i,  HttpServletRequest request){
        this.method = request.getMethod();
        this.requestUrl = request.getRequestURL().toString();
        this.timeStamp = new Timestamp(new Date().getTime());
        successConfirmation = i == 1? Constants.SUCCESS : Constants.FAILURE;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
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

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }
}
