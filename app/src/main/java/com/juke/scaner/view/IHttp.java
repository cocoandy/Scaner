package com.juke.scaner.view;

/**
 * Created by Gavin
 * 2018/9/26
 */
public interface IHttp {

    /**
     * 请求成功
     * @param json 返回值
     */
    void onSuccess(String json);

    /**
     * 请求失败
     * @param t
     */
    void onFail(Object t);

    /**
     * 请求结束
     */
    void onCompleted();
}
