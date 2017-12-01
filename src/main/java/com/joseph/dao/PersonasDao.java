package com.joseph.dao;

import java.io.IOException;
import java.util.Map;

/**
 * Hbase Dao接口层
 *
 * Created by Joseph on 04/11/2017.
 */
public interface PersonasDao {

    /**
     * 获取客户 DAO接口
     *
     * @params
     * @return
     */ 
    String findByRowKey(Map<String, String> request) throws IOException;

     /**
     * 根据Id与标签获取数据
     *
     * @params
     * @return
     */ 
    String findByRowColumn(Map<String, String> request) throws IOException;

    /**
     * 根据前缀获取所有数据
     *
     * @params
     * @return
     */
    String findAllRowByPre(Map<String, String> request) throws IOException;
    
    /**
     * 扫描过滤获取所有数据
     *
     * @params
     * @return
     */
    String findAllRowByFilter(Map<String, String> request) throws IOException;

    /**
     * 添加数据
     *
     * @params
     * @return
     */
    String putByRowKey(Map<String, String> request) throws IOException;
}