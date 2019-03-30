package com.jun.pojo;

public class ResponseData {
    private Object data ;
    private int errorCode ;
    private String errorMessage ;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getErrorCode() {
        return errorCode;
    }

    @Override
    public String toString() {
        return "ResponseData{" +
                "data=" + data +
                ", errorCode=" + errorCode +
                ", errorMessage='" + errorMessage + '\'' +
                '}';
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
