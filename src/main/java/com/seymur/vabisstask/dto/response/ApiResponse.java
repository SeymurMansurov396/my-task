package com.seymur.vabisstask.dto.response;

import lombok.ToString;

@ToString
public class ApiResponse {
    private String message;
    private boolean success;
    private Object data;
    private ErrorResponse error;

    public ApiResponse() {
    }

    public ApiResponse(boolean success) {
        this.success = success;
    }

    public ApiResponse(String message, boolean success) {
        this.message = message;
        this.success = success;
    }


    public ApiResponse(String message, boolean success, Object data) {
        this.message = message;
        this.success = success;
        this.data = data;
    }

    public ApiResponse(boolean success, ErrorResponse error) {
        this.success = success;
        this.error = error;
    }

    public ApiResponse(boolean success, Object data) {
        this.success = success;
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public ErrorResponse getError() {
        return error;
    }

    public void setError(ErrorResponse error) {
        this.error = error;
    }


}
