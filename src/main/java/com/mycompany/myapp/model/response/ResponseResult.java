package com.mycompany.myapp.model.response;

import lombok.Builder;

@Builder
public class ResponseResult<T> {

    private String message;
    private T data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ResponseResult() {}

    public static <T> ResponseResult<T> ofSuccess() {
        ResponseResult<T> ResponseResult = new ResponseResult<>();
        ResponseResult.setMessage("success");
        return ResponseResult;
    }

    public static <T> ResponseResult<T> ofSuccess(String message) {
        ResponseResult<T> ResponseResult = new ResponseResult<>();
        ResponseResult.setMessage(message);
        return ResponseResult;
    }

    public static <T> ResponseResult<T> ofSuccess(T data) {
        ResponseResult<T> ResponseResult = new ResponseResult<>();
        ResponseResult.setMessage("success");
        ResponseResult.setData(data);
        return ResponseResult;
    }

    public static <T> ResponseResult<T> ofSuccess(String message, T data) {
        ResponseResult<T> ResponseResult = new ResponseResult<>();
        ResponseResult.setMessage(message);
        ResponseResult.setData(data);
        return ResponseResult;
    }

    public ResponseResult(String message) {
        this.message = message;
    }

    public ResponseResult(String message, T data) {
        this.message = message;
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResponseResult{" + ", message='" + message + '\'' + ", data=" + data + '}';
    }
}
