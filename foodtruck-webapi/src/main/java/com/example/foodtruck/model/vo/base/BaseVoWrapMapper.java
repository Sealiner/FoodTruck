package com.example.foodtruck.model.vo.base;

import com.example.foodtruck.systemcode.ErrorCodeEnum;

public class BaseVoWrapMapper {
    /**
     * Instantiates a new wrap mapper.
     */
    private BaseVoWrapMapper() {
    }

    /**
     * Wrap.
     *
     * @param <E>     the element type
     * @param code    the code
     * @param message the message
     * @param o       the o
     * @return the wrapper
     */
    public static <E> BaseVoWrapper<E> wrap(int code, String message, E o) {
        return new BaseVoWrapper<>(code, message, o);
    }

    /**
     * Wrap.
     *
     * @param <E>     the element type
     * @param code    the code
     * @param message the message
     * @return the wrapper
     */
    public static <E> BaseVoWrapper<E> wrap(int code, String message) {
        return wrap(code, message, null);
    }


    /**
     *
     * @param errorCodeEnum
     * @return BaseVoWrapper
     */
    public static <E> BaseVoWrapper<E> wrap(ErrorCodeEnum errorCodeEnum) {
        return new BaseVoWrapper<>(errorCodeEnum.code(), errorCodeEnum.msg());
    }


    public static <E> BaseVoWrapper<E> wrap(ErrorCodeEnum errorCodeEnum, E o) {
        return new BaseVoWrapper<>(errorCodeEnum.code(), errorCodeEnum.msg(), o);
    }


    /**
     * Wrap ERROR. code=500
     *
     * @param <E> the element type
     * @return the wrapper
     */
    public static <E> BaseVoWrapper<E> error() {
        return wrap(ErrorCodeEnum.ERROR.code(), ErrorCodeEnum.ERROR.msg());
    }

    /**
     * Wrap ERROR. code=500
     *
     * @param <E> the element type
     * @return the wrapper
     */
    public static <E> BaseVoWrapper<E> error(ErrorCodeEnum errorCodeEnum) {
        return wrap(errorCodeEnum.code(), errorCodeEnum.msg());
    }

    public static <E> BaseVoWrapper<E> error(ErrorCodeEnum errorCodeEnum, E o) {
        return wrap(errorCodeEnum.code(), errorCodeEnum.msg(), o);
    }


    /**
     * Wrap SUCCESS. code=200
     *
     * @param <E> the element type
     * @return the wrapper
     */
    public static <E> BaseVoWrapper<E> success() {
        return new BaseVoWrapper<>();
    }

    /**
     * Ok wrapper.
     *
     * @param <E> the type parameter
     * @param o   the o
     * @return the wrapper
     */
    public static <E> BaseVoWrapper<E> success(E o) {
        return new BaseVoWrapper<>(ErrorCodeEnum.SUCCESS.code(),ErrorCodeEnum.SUCCESS.msg(), o);
    }

}