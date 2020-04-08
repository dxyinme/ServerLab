package com.dxyinme.demo.HttpResponse;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class HttpResponse {


    @ApiModelProperty(value = "status" , example = "0")
    private int status;

    @ApiModelProperty(value = "message" , example = "")
    private String message;

    @ApiModelProperty(value = "data" , example = "")
    private Object data;


    public HttpResponse(Integer status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public HttpResponse(Integer status, String message) {
        this.status = status;
        this.message = message;
        this.data = null;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public Object getData() {
        return data;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
