package com.drelephant.elephantadmin.business.module.util;

import org.apache.commons.lang.StringUtils;

/**
 * @author zhou.fan
 * @date 2018/10/23 13:57
 * @description
 */
public class Result<T> {

    public String code;

    private String msg;

    private T data;

    public boolean checkCode(){
        return StringUtils.equals(code, "0");
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }
}
