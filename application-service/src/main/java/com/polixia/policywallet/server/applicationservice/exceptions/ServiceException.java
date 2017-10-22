package com.polixia.policywallet.server.applicationservice.exceptions;

/**
 * Created by bhagya on 10/22/17.
 */
public class ServiceException extends RuntimeException
{
    private String errorMessage;
    private int errorCode;
    private int statusCode;

    public ServiceException( String errorMessage, int errorCode, int statusCode) {
        super(errorMessage);
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
        this.statusCode = statusCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
}
