package com.joseph.dao.impl;

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
import org.springframework.beans.factory.annotation.Value;
import org.junit.Before;

import com.joseph.common.HbaseClient;
import com.joseph.dao.PersonasDao;

/**
 * Hbase Dao实现层
 *
 * Created by Joseph on 04/11/2017.
 */
@Repository("PersonasDao")
public class PersonasDaoImpl implements PersonasDao {

    @Override
    public String findByRowKey(Map<String, String> request) throws IOException {

        // 取得数据对象
        HTable table = new HTable(HbaseClient.conf, request.get("table"));
        Get get = new Get(Bytes.toBytes(request.get("row")));
        Result result = table.get(get);
        
        NavigableMap<byte[], NavigableMap<byte[], NavigableMap<Long, byte[]>>> map = result.getMap();
        return HbaseClient.mapToJSONString(map);

    }

    @Override
    public String putByRowKey(Map<String, String> request) throws IOException {
        // 插入数据
        if(!"personas".equals(request.get("table"))) return null;
        HTable table = new HTable(HbaseClient.conf, request.get("table"));
        List<Put> putList = new ArrayList<Put>();
            
        Put put;
        for(int i=0; i<10; i++) {
            put = new Put(Bytes.toBytes("row" + i));
            put.addColumn(Bytes.toBytes("base"), Bytes.toBytes("name"), Bytes.toBytes("bookName" + i));
            putList.add(put);
        }
        table.put(putList);

        return null;
    }


}