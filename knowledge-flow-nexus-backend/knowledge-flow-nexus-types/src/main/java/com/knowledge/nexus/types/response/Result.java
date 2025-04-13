package com.knowledge.nexus.types.response;

import com.knowledge.nexus.types.constants.ErrorCode;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * 统一响应对象
 *
 * @param <T> 返回数据类型
 */
@Data
public class Result<T> implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 返回消息
     */
    private String message;

    /**
     * 返回数据
     */
    private T data;

    /**
     * 时间戳
     */
    private long timestamp;

    private Result() {
        this.timestamp = System.currentTimeMillis();
    }

    private Result(Integer code, String message) {
        this.code = code;
        this.message = message;
        this.timestamp = System.currentTimeMillis();
    }

    private Result(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.timestamp = System.currentTimeMillis();
    }

    /**
     * 成功返回结果
     */
    public static <T> Result<T> success() {
        return new Result<>(ErrorCode.SUCCESS, "操作成功");
    }

    /**
     * 成功返回结果
     *
     * @param data 获取的数据
     */
    public static <T> Result<T> success(T data) {
        return new Result<>(ErrorCode.SUCCESS, "操作成功", data);
    }

    /**
     * 成功返回结果
     *
     * @param data    获取的数据
     * @param message 提示信息
     */
    public static <T> Result<T> success(T data, String message) {
        return new Result<>(ErrorCode.SUCCESS, message, data);
    }

    /**
     * 失败返回结果
     *
     * @param errorCode 错误码
     */
    public static <T> Result<T> failed(Integer errorCode) {
        return new Result<>(errorCode, "操作失败");
    }

    /**
     * 失败返回结果
     *
     * @param errorCode 错误码
     * @param message   错误信息
     */
    public static <T> Result<T> failed(Integer errorCode, String message) {
        return new Result<>(errorCode, message);
    }

    /**
     * 失败返回结果
     *
     * @param message 提示信息
     */
    public static <T> Result<T> failed(String message) {
        return new Result<>(ErrorCode.SYSTEM_ERROR, message);
    }

    /**
     * 系统错误返回结果
     */
    public static <T> Result<T> systemError() {
        return new Result<>(ErrorCode.SYSTEM_ERROR, "系统错误，请联系管理员");
    }

    /**
     * 参数验证失败返回结果
     */
    public static <T> Result<T> validateFailed() {
        return new Result<>(ErrorCode.PARAM_ERROR, "参数错误");
    }

    /**
     * 参数验证失败返回结果
     *
     * @param message 提示信息
     */
    public static <T> Result<T> validateFailed(String message) {
        return new Result<>(ErrorCode.PARAM_ERROR, message);
    }

    /**
     * 未登录返回结果
     */
    public static <T> Result<T> unauthorized() {
        return new Result<>(ErrorCode.UNAUTHORIZED, "暂未登录或token已经过期");
    }

    /**
     * 无权限返回结果
     */
    public static <T> Result<T> forbidden() {
        return new Result<>(ErrorCode.FORBIDDEN, "没有相关权限");
    }

    /**
     * 资源不存在返回结果
     */
    public static <T> Result<T> notFound() {
        return new Result<>(ErrorCode.NOT_FOUND, "资源不存在");
    }

    /**
     * 资源不存在返回结果
     *
     * @param message 提示信息
     */
    public static <T> Result<T> notFound(String message) {
        return new Result<>(ErrorCode.NOT_FOUND, message);
    }
} 