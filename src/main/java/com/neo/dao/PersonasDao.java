package com.neo.dao;

import java.io.IOException;

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
    String findByRowKey(String tableName, String row) throws IOException;
}