package com.joseph.service;

import java.io.IOException;
import org.apache.commons.lang.StringUtils;
import java.util.Map;

import com.joseph.common.Entity;

public interface CacheService {

    /**
     * 获取缓存数据
     *
     * @param
     * @return
     */ 
    Entity getCache(Map<String, String> request) throws IOException;

    /**
     * 插入缓存数据
     *
     * @param
     * @return
     */ 
    Entity setCache(Map<String, String> request) throws IOException;
}