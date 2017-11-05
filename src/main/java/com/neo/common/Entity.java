package com.neo.common;

import java.util.Map;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;  
import com.alibaba.fastjson.JSONObject;

/**
 * 定义返回实体
 * 
 * Created by Joseph on 04/11/2017
 */

public class Entity {

    public int code;
    public String msg;
    public JSONObject data;

    public Entity(JSONObject obj) {
        this.code = 0;
        this.msg = "请求成功";
        this.data = obj;
    }

    public Entity(JSONObject obj, int code) {
        this.code = code;
        this.msg = "请求失败";
        this.data = obj;
    }

}