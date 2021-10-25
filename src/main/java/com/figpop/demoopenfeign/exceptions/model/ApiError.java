package com.figpop.demoopenfeign.exceptions.model;

import java.util.Date;

public class ApiError {
    private Date timestamp;
    private String message;
    private String description;
    private String errorCode;

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ApiError(String errorCode , Date timestamp , String message , String description) {
        this.errorCode = errorCode;
        this.timestamp = timestamp;
        this.message = message;
        this.description = description;
    }

}
