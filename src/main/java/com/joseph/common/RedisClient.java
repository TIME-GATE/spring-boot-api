package com.joseph.common;

import redis.clients.jedis.Jedis;

public class RedisClient {

    private Jedis jedis = new Jedis("127.0.0.1", 6379);

    public String get(String key) {
      return jedis.get(key);
    }

    public void set(String key, String value) {
        try {
          jedis.set(key, value);
        } catch (Exception e) {
          e.printStackTrace();
        }
    }

}