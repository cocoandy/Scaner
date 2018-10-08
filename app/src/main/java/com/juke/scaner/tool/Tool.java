package com.juke.scaner.tool;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.juke.scaner.base.BaseInfo;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/**
 * 工具
 * Created by Gavin
 * 2018/9/29
 */
public class Tool {

    /**
     * BaseApi 转为Map
     */
    public static Map<String, String> toMap(BaseInfo api) {
        Gson gson = new Gson();
        Type type = new TypeToken<Map<String, String>>() {}.getType();
        return gson.fromJson(gson.toJson(api), type);
    }

    public static String beanToString(Object object){
        Gson gson = new Gson();
        return gson.toJson(object);
    }
}
