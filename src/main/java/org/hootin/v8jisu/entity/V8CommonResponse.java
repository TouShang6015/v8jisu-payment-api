package org.hootin.v8jisu.entity;

import org.hootin.v8jisu.enums.V8ResultCode;

import java.util.Objects;

/**
 * 通用响应实体
 *
 * @author WuHao
 * @since 2023/10/20 17:13
 */
public class V8CommonResponse {

    private Integer code;

    private String message;

    public static <T extends V8CommonResponse> boolean verifyResponse(T param) {
        if (Objects.equals(param.getCode(), V8ResultCode.SUCCESS.getCode())) {
            return true;
        }
        return false;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
