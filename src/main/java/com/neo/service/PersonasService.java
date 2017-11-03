package com.neo.service;

import java.io.IOException;
import org.apache.hadoop.conf.Configuration;
import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.util.Bytes;
import java.util.List;

import com.neo.common.HbaseModel;
import com.neo.common.HbaseConnection;

public class PersonasService {
    HbaseConnection hbase = new HbaseConnection();
    public String getPersonas() throws IOException {
        Configuration conf = HBaseConfiguration.create();
        // conf.set("hbase.zookeeper.quorum", "master");
        // conf.set("hbase.zookeeper.property.clientPort", "2181");

        // HBaseAdmin admin = new HBaseAdmin(conf);
        // HTableDescriptor tableDescriptor = admin.getTableDescriptor(Bytes.toBytes("test"));
        // byte[] name = tableDescriptor.getName();
        // System.out.println("+++++++++++++++++");
        // System.out.println(new String(name));
        // System.out.println("+++++++++++++++++");


        HbaseModel.queryTableByRowKey("mytable", "row-key");
        //hbase.setUp();
        //hbase.queryTableByRowKey(); 
    
        return "Hello World";
    }
}