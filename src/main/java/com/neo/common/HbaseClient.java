package com.neo.common;

import java.io.IOException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;

/**
 * Hbase静态配置
 *
 * Created by Joseph on 04/11/2017.
 */
public class HbaseClient {

    public static Configuration conf = null;

    static {
        conf = HBaseConfiguration.create();
        conf.set("hbase.zookeeper.quorum", "localhost");
        conf.set("hbase.zookeeper.property.clientPort", "2181");
    }

}