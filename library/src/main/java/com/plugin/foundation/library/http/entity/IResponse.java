package com.plugin.foundation.library.http.entity;

public interface IResponse {
    /**此次响应成功与否
     * @return
     */
    boolean isSuccess();

    /**此次响应返回的message
     * @return
     */
    String message();
}
