package com.joseph.common;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisPool {

    private static String HOST = "127.0.0.1";
    private static int PORT = 6379;

    private static int MAX_ACTIVE = 1024;
    private static int MAX_IDLE = 300;

    private static int MAX_WAIT = 10000;
    private static int TIMEOUT = 10000;

    private static boolean TEST_ON_BORROW = true;
    private static JedisPool jedisPool = null;

    /**
    * 初始化连接池
    */
    static {
        try {
            JedisPoolConfig config = new JedisPoolConfig();
            config.setMaxTotal(MAX_ACTIVE);
            config.setMaxIdle(MAX_IDLE);
            config.setMaxWaitMillis(MAX_WAIT);
            config.setTestOnBorrow(TEST_ON_BORROW);
            jedisPool = new JedisPool(config, HOST, PORT, TIMEOUT);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    /**
    * 获取Jedis实例
    */
    public synchronized static Jedis getJedis() {
        try {
            if(jedisPool != null) {
              return jedisPool.getResource();
            }
            return null;
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
    * 释放Jedis实例
    */
    public static void releaseJedis(Jedis jedis) {
        if(jedis != null) {
          jedisPool.returnResource(jedis);
        }
    }

    /**
    * 获取Cache
    */
    public String get(String key) {
        Jedis jedis = this.getJedis();
        String str = jedis.get(key);
        this.releaseJedis(jedis);
        return str;
    }

    /**
    * 插入Cache
    */
    public void set(String key, String value) {
        try {
            Jedis jedis = this.getJedis();
            jedis.set(key, value);
            this.releaseJedis(jedis);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

}