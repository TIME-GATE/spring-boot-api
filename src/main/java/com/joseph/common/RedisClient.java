package com.joseph.common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Before;
import java.io.IOException;

import redis.clients.jedis.Jedis;

public class RedisClient {

  private Jedis jedis = new Jedis("127.0.0.1", 6379);

  public String get(String key) {
    return jedis.get(key);
  }

  public void set(String key, String value) {
    try {
      jedis.set(key, value);
    } catch(Exception e) {
      
    }
  }

}