package com.neo.common;

import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;  
import com.alibaba.fastjson.JSONObject;

/**
 * Created by Joseph on 20/10/2017
 */

public class Context {

    public int code;
    public String msg;
    public JSONObject data;

    public Context(JSONObject obj) {
        this.code = 0;
        this.msg = "请求成功";
        this.data = obj;
    }

    public Context(JSONObject obj, int code) {
        this.code = code;
        this.msg = "请求失败";
        this.data = obj;
    }

}