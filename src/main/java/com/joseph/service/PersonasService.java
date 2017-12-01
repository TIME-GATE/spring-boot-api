package com.joseph.service;

import java.io.IOException;
import java.util.Map;

import com.joseph.common.Entity;

/**
 * Service 接口层
 *
 * Created by Joseph on 04/11/2017.
 */
public interface PersonasService {

    /**
     * 获取全部数据
     *
     * @params
     * @return
     */ 
    Entity getPersonas(Map<String, String> request) throws IOException;
    
    /**
     * 获取某属性历史数据
     *
     * @params
     * @return
     */
    Entity getColumnVersion(Map<String, String> request) throws IOException;

    /**
     * 以特定前缀匹配客户所有数据
     *
     * @params
     * @return
     */
    Entity regixRowByPre(Map<String, String> request) throws IOException;

    /**
     * 表扫描获取所有数据
     *
     * @params
     * @return
     */
    Entity regixTableFilter(Map<String, String> request) throws IOException;
    
    /**
     * 插入客户画像数据
     *
     * @params
     * @return
     */
    Entity putPersonas(Map<String, String> request) throws IOException;
}