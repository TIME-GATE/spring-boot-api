package com.joseph.common;

import com.alibaba.fastjson.JSONObject;

/**
 * 定义返回实体
 * 
 * Created by Joseph on 04/11/2017
 */

public class Entity {

    public int code;
    public String msg;
    public JSONObject data = new JSONObject();

    public Entity() {
        this.code = 0;
        this.msg = "请求成功";
    }

    public Entity(int code) {
        this.code = code;
        this.msg = "请求失败";
    }

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