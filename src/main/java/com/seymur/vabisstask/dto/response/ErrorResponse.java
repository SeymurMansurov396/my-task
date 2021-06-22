package com.seymur.vabisstask.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ErrorResponse {
    private int code;
    private int httpCode;
    private List<String> message;

    public ErrorResponse() {
    }

    public ErrorResponse(int code, List<String> message) {
        this.code = code;
        this.message = message;
    }

    public ErrorResponse(int code, int httpCode, List<String> message) {
        this.code = code;
        this.httpCode = httpCode;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getHttpCode() {
        return httpCode;
    }

    public void setHttpCode(int httpCode) {
        this.httpCode = httpCode;
    }

    public List<String> getMessage() {
        return message;
    }

    public void setMessage(List<String> message) {
        this.message = message;
    }
}
