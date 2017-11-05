package com.neo.common;

import java.io.IOException;
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

}