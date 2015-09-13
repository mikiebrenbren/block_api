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
    private String confirmationMessage;
    private Date timeStamp;

    public ResponseModel(int i,  HttpServletRequest request){
        this.method = request.getMethod();
        this.requestUrl = request.getRequestURL().toString();
        this.timeStamp = new Timestamp(new Date().getTime());

        switch (method){
            case(Constants.POST):
                confirmationMessage = i == 1? Constants.SUCCESS_POST : Constants.FAILURE_POST;
                break;
            case (Constants.PUT):
                confirmationMessage = i == 1? Constants.SUCCESS_PUT : Constants.FAILURE_PUT;
                break;
            case(Constants.DELETE):
                confirmationMessage = i == 1? Constants.SUCCESS_DELETE : Constants.FAILURE_DELETE;

        }
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

    public String getConfirmationMessage() {
        return confirmationMessage;
    }

    public void setConfirmationMessage(String confirmationMessage) {
        this.confirmationMessage = confirmationMessage;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }
}
