package com.joseph.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import com.joseph.common.Entity;
import com.joseph.common.RedisClient;
import com.joseph.common.RedisPool;
import com.joseph.service.CacheService;

/**
 * 逻辑实现
 *
 * Created by Joseph on 27/11/2017.
 */
@Service
public class CacheServiceImpl implements CacheService {

  private RedisClient redis = new RedisClient();
  private RedisPool redisPool = new RedisPool();

  @Override
  public Entity getCache(Map<String, String> request) throws IOException {
    String str = redis.get(request.get("key"));
    JSONObject obj = new JSONObject();
    obj.put(request.get("key"), str);
    return new Entity(obj);
  }

  @Override
  public Entity setCache(Map<String, String> request) throws IOException {
    redis.set(request.get("key"), request.get("value"));
    return new Entity();
  }

  @Override
  public Entity getCacheByPool(Map<String, String> request) throws IOException {
    String str = redisPool.get(request.get("key"));
    JSONObject obj = new JSONObject();
    obj.put(request.get("key"), str);
    return new Entity(obj);
  }

  @Override
  public Entity setCacheByPool(Map<String, String> request) throws IOException {
    redisPool.set(request.get("key"), request.get("value"));
    return new Entity();
  }
}