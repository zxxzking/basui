package com.lv.basui.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 统一定义返回参数格式
 * @param <T>
 */

@ApiModel
public class ResultBean<T> implements Serializable{

    private static final long serialVersionUID = 1L;

    public static final String SUCCESS = "0000";

    public static final String FAIL = "S1001";

    @ApiModelProperty(value = "返回信息",required = true)
    private String msg = "success";

    @ApiModelProperty(value = "响应code",required = true)
    private String code = SUCCESS;

    @ApiModelProperty(value = "返回数据")
    private T data;

    public ResultBean() {
        super();
    }

    public ResultBean(T data) {
        super();
        this.data = data;
    }

    public ResultBean(String code, String msg){
        super();
        this.msg = msg;
        this.code = code;
    }

    public ResultBean(String msg){
        super();
        this.msg = msg;
    }

    public ResultBean(Throwable e) {
        super();
        this.msg = e.toString();
        this.code = FAIL ;
    }


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
