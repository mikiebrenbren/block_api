package com.mike.domain.model;

import com.mike.util.Constants;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Michael Brennan on 9/8/15.
 */
public class ResponseModel {

    private String requestUrl;
    private String path;
    private String method;
    private String message;
    private String timeStamp;
    private int status;

    public ResponseModel(int i,  HttpServletRequest request){

        DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        Date today = Calendar.getInstance().getTime();

        this.path = request.getServletPath();
        this.method = request.getMethod();
        this.requestUrl = request.getRequestURL().toString();
        this.timeStamp = df.format(today);

        switch (method){
            case(Constants.POST):
                message = i == 1? Constants.SUCCESS_POST : Constants.FAILURE_POST;
                break;
            case (Constants.PUT):
                message = i == 1? Constants.SUCCESS_PUT : Constants.FAILURE_PUT;
                break;
            case(Constants.DELETE):
                message = i == 1? Constants.SUCCESS_DELETE : Constants.FAILURE_DELETE;

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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
