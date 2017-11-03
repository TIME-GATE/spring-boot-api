package com.neo.service;

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

import java.util.List;

public class PersonasService {

    public String getPersonas() {
        Configuration conf = HBaseConfiguration.create();
        conf.set("hbase.zookeeper.quorum", "master");
        conf.set("hbase.zookeeper.property.clientPort", "2181");
        // HBaseAdmin admin = new HBaseAdmin(conf);
        // HTableDescriptor tableDescriptor = admin.getTableDescriptor(Bytes.toBytes("test"));
        // byte[] name = tableDescriptor.getName(); 
        // System.out.println("cf:");
        return "Hello World";
    }
}