package com.neo.common;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.util.Bytes;

import org.junit.Before;
import java.util.List;

public class HbaseConnection {

    // Hbase 链接对象
    Connection connection;
    
    // 数据库元数据操作对象
    Admin admin;

    //@Before
    public void setUp() throws IOException {
        
        // 取得配置对象
        Configuration conf = HBaseConfiguration.create();
        
        // 设置主机IP
        conf.set("hbase.zookeeper.quorum", "localhost");
        
        // 设置主机端口
        conf.set("hbase.zookeeper.property.clientPort", "2181");
        
        // 取得一个数据库连接对象
        connection = ConnectionFactory.createConnection(conf);

        // 取得元数据操作对象
        admin = connection.getAdmin();

        System.out.println("链接成功");
    }

    public void queryTableByRowKey() throws IOException {

        // 取得数据对象
        Table table = connection.getTable(TableName.valueOf("test"));

        // 获取操作对象
        Get get = new Get("row1".getBytes());

        // 获取查询结果
        Result result = table.get(get);

        // 转换为字节
        byte[] row = result.getRow();

        // 打印结果
        System.out.println(new String(row));
    }
}