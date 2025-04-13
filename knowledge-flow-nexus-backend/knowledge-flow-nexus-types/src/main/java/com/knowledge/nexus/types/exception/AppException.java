package com.knowledge.nexus.types.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serial;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
public class AppException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 5317680961212299217L;

    /**
     * 异常码
     */
    private String code;

    /**
     * 异常信息
     */
    private String msg;

    public AppException(String code) {
        this.code = code;
    }

    public AppException(String code, Throwable cause) {
        this.code = code;
        super.initCause(cause);
    }

    public AppException(String code, String message) {
        this.code = code;
        this.msg = message;
        super.initCause(new Throwable(message));
    }

    public AppException(String code, String message, Throwable cause) {
        this.code = code;
        this.msg = message;
        super.initCause(cause);
    }
}
