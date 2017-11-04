package com.neo.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import com.neo.common.HbaseClient;
import com.neo.common.Context;
import com.neo.service.PersonasService;

/**
 * 客户画像逻辑实现
 *
 * Created by Joseph on 05/11/2017.
 */
@Service
public class PersonasServiceImpl implements PersonasService {

    @Override
    public Context getPersonas(Map<String, String> request) throws IOException {
        String row = HbaseClient.findByRowKey("test", "row1");
        JSONObject obj = JSON.parseObject(row);
        return new Context(obj);
    }
}