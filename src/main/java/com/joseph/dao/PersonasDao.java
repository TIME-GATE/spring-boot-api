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
     * @param
     * @return
     */ 
    String findByRowKey(Map<String, String> request) throws IOException;

    String putByRowKey(Map<String, String> request) throws IOException;
}