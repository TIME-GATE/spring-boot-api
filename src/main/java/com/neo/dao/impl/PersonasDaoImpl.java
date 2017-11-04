package com.neo.dao.impl;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.NavigableMap;
import com.alibaba.fastjson.JSON;
import net.sf.json.JSONObject;
import net.sf.json.JSONArray;
import org.springframework.stereotype.Repository;

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
import com.neo.dao.PersonasDao;

/**
 * Hbase Dao层
 *
 * Created by Joseph on 04/11/2017.
 */
@Repository("PersonasDao")
public class PersonasDaoImpl implements PersonasDao {

    @Override
    public String findByRowKey(String tableName, String row) throws IOException {
        // 取得数据对象
        HTable table = new HTable(HbaseClient.conf, tableName);
        Get get = new Get(Bytes.toBytes(row));
        Result result = table.get(get);
        
        NavigableMap<byte[], NavigableMap<byte[], NavigableMap<Long, byte[]>>> map = result.getMap();
        Map<String, Map<String, Map<String, String>>> map_1 = new HashMap<String, Map<String, Map<String, String>>>();
            
        for(byte[] key1 : map.keySet()){
            NavigableMap<byte[], NavigableMap<Long, byte[]>> map1 = map.get(key1);
            Map<String, Map<String, String>> map_2 = new HashMap<String, Map<String, String>>();
            for(byte[] key2 : map1.keySet()){
                NavigableMap<Long, byte[]> map2 = map1.get(key2);
                Map<String, String> map_3 = new HashMap<String, String>();
                for(Long key3 : map2.keySet()){
                    map_3.put(Long.toString(key3), Bytes.toString(map2.get(key3)));
                }
                map_2.put(Bytes.toString(key2), map_3);
            }
            map_1.put(Bytes.toString(key1), map_2);
        }

        return JSON.toJSONString(map_1);

    }

}