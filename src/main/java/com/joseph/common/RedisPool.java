package com.joseph.common;

import com.alibaba.fastjson.JSONObject;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Transaction;
import redis.clients.jedis.JedisPoolConfig;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
        Jedis jedis = null;
        String str;

        try {
            jedis = this.getJedis();
            str = jedis.get(key);
        } finally {
            if(jedis != null) {
                this.releaseJedis(jedis);
            }
        }

        return str;
    }

    public <T> T get(String key, Class<T> classT) {
        String json;
        Jedis jedis = null;

        try {
            jedis = this.getJedis();
            json = jedis.get(key);
        } finally {
            if (jedis != null) {
                this.releaseJedis(jedis);
            }
        }

        return json == null ? null : JSONObject.parseObject(json, classT);
    }

    public Boolean exists(String key) {
        Boolean result;
        Jedis jedis = null;

        try {
            jedis = this.getJedis();
            result = jedis.exists(key);
        } finally {
            this.releaseJedis(jedis);
        }

        return result;
    }

    public List<String> keys(String pattern) {
        List<String> result = new ArrayList<>();
        Set<String> set;
        Jedis jedis = null;

        try {
            jedis = this.getJedis();
            set = jedis.keys(pattern);

            if (set != null && !set.isEmpty()) {
                result.addAll(set);
            }
        } finally {
            this.releaseJedis(jedis);
        }

        return result;
    }


    /**
    * 插入Cache
    */
    public void set(String key, String value) {
        Jedis jedis = null;

        try {
            jedis = this.getJedis();
            jedis.set(key, value);

            this.releaseJedis(jedis);
        } catch (Exception e) {
            this.releaseJedis(jedis);
            e.printStackTrace();
        }
    }

    public void set(String key, String json, Integer expire) {
        Jedis jedis = null;

        try {
            jedis = this.getJedis();
            Transaction transaction = jedis.multi();
            transaction.hset(key, key, json);
            transaction.expire(key, expire);
            transaction.exec();
        } finally {
            this.releaseJedis(jedis);
        }
    }

}