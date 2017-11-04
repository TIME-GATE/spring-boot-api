package com.neo.common;

import java.io.IOException;
import org.junit.Before;
import java.util.List;
import java.util.ArrayList;

import org.apache.hadoop.conf.Configuration;
import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;


public class HbaseClient {

    // 静态配置
    private static Configuration conf = null;

    static {
        conf = HBaseConfiguration.create();
        conf.set("hbase.zookeeper.quorum", "localhost");
        conf.set("hbase.zookeeper.property.clientPort", "2181");
    }

    public static Result queryTableByRowKey(String tableName, String row) throws IOException {
        // 取得数据对象
        HTable table = new HTable(conf, tableName);

        // 获取操作对象
        Get get = new Get(Bytes.toBytes(row));

        // 获取查询结果
        return table.get(get);
    }

}