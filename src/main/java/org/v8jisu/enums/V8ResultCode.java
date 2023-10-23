package org.v8jisu.enums;

/**
 * @author WuHao
 * @since 2023/10/20 17:14
 */
public enum V8ResultCode {

    SUCCESS(1,"成功"),
    ;

    private final int code;

    private final String description;

    V8ResultCode(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
