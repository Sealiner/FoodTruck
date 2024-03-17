package com.example.foodtruck.model.vo.base;

import com.example.foodtruck.systemcode.ErrorCodeEnum;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class BaseVoWrapper<T> implements Serializable {

    private static final long serialVersionUID = -2073903360582530232L;

    private int code;

    private String message;

    private transient T result;

    private Date currentTime = new Date();

    BaseVoWrapper() {
        this(ErrorCodeEnum.SUCCESS.code(), ErrorCodeEnum.SUCCESS.msg());
    }

    BaseVoWrapper(ErrorCodeEnum errorCodeEnum) {
        this(errorCodeEnum.code(), errorCodeEnum.msg());
    }

    BaseVoWrapper(ErrorCodeEnum errorCodeEnum, T result) {
        this(errorCodeEnum.code(), errorCodeEnum.msg(), result);
    }

    BaseVoWrapper(int code, String message) {
        this(code, message, null);
    }

    BaseVoWrapper(int code, String message, T result) {
        super();
        this.code(code).message(message).result(result);
    }

    private BaseVoWrapper<T> code(int code) {
        this.setCode(code);
        return this;
    }

    private BaseVoWrapper<T> message(String message) {
        this.setMessage(message);
        return this;
    }

    public BaseVoWrapper<T> result(T result) {
        this.setResult(result);
        return this;
    }
}