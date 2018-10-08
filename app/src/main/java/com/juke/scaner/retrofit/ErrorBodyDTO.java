package com.juke.scaner.retrofit;

/**
 * 报错实体类
 * Created by Gavin on 2018/6/29.
 */

public class ErrorBodyDTO {
    private String errCode;
    private String errMsg;

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }
}
