package com.joseph.common;

import java.io.IOException;
import java.util.Map;
import java.util.HashMap;
import java.util.NavigableMap;
import com.alibaba.fastjson.JSON;
import net.sf.json.JSONObject;

import org.apache.hadoop.hbase.util.Bytes;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;

/**
 * Hbase静态配置
 *
 * Created by Joseph on 04/11/2017.
 */
@Component
public class HbaseClient {

    public static Configuration conf = HBaseConfiguration.create();

    @Value("${database.hbase.host}")
    public void setHbaseHost(String hbaseHost) {
        conf.set("hbase.zookeeper.quorum", hbaseHost);
    }
    
    @Value("${database.hbase.port}")
    public void setHbasePort(String hbasePort) {
        conf.set("hbase.zookeeper.property.clientPort", hbasePort);
    }
    public static String mapToJSONString(NavigableMap<byte[], NavigableMap<byte[], NavigableMap<Long, byte[]>>> map) {

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