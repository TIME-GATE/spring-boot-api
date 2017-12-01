package com.joseph.service;

import java.io.IOException;
import java.util.Map;

import com.joseph.common.Entity;

public interface CacheService {

    /**
     * 获取缓存数据
     *
     * @params
     * @return
     */ 
    Entity getCache(Map<String, String> request) throws IOException;

    /**
     * 插入缓存数据
     *
     * @params
     * @return
     */ 
    Entity setCache(Map<String, String> request) throws IOException;

    /**
     * 获取缓存数据
     *
     * @params
     * @return
     */ 
    Entity getCacheByPool(Map<String, String> request) throws IOException;
    
    /**
     * 插入缓存数据
     *
     * @params
     * @return
     */ 
    Entity setCacheByPool(Map<String, String> request) throws IOException;
}