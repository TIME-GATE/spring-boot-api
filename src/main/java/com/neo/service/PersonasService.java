package com.neo.service;

import java.io.IOException;
import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.hbase.client.Result;
import java.util.List;

import com.neo.common.HbaseClient;

public class PersonasService {
        
    public Result getPersonas() throws IOException {

        return HbaseClient.queryTableByRowKey("test", "row1");

    }
}