package com.plugin.foundation.library.http.entity;

/**返回响应实体模型
 * @param <T>
 */
public class BaseResponseEntity<T> {
    private T data;
    private String code;
    private String msg;

    public T getData() {
        return data;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    @Override
    public String toString() {
        return "BaseResponseEntity{" +
                "data=" + data +
                ", code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }
}
