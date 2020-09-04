package com.yss.ds.demo.constant;

/**
 * <p>
 * 响应码
 * </p>
 *
 * @author qjwyss
 * @since 2020-05-06 19:50
 */
public enum ResultCodeEnum {

    /**
     * 1-操作成功
     */
    SUCCESS(1, "操作成功"),

    /**
     * 0-操作失败
     */
    FAILED(0, "操作失败"),

    /**
     * 401-暂未登录或token已经过期
     */
    UNAUTHORIZED(10001, "暂未登录或token已经过期"),

    /**
     * 403-没有相关权限
     */
    NO_PRIVILEGE(10002, "没有相关权限"),

    ;

    private Integer code;
    private String msg;

    ResultCodeEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
