package com.neo.dao;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.NavigableMap;
import com.alibaba.fastjson.JSON;
import net.sf.json.JSONObject;
import net.sf.json.JSONArray;

import org.apache.hadoop.conf.Configuration;
import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.KeyValue;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.junit.Before;

import com.neo.common.HbaseClient;

/**
 * Hbase Dao层
 *
 * Created by Joseph on 04/11/2017.
 */
public interface PersonasDao {

    /**
     * 获取客户DAO
     *
     * @param
     * @return
     */ 
    String findByRowKey(String tableName, String row) throws IOException;
}