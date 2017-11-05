package com.joseph.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import com.joseph.dao.PersonasDao;
import com.joseph.common.Entity;
import com.joseph.service.PersonasService;

/**
 * 客户画像逻辑实现
 *
 * Created by Joseph on 05/11/2017.
 */
@Service
public class PersonasServiceImpl implements PersonasService {

    @Autowired
    private PersonasDao personasDao;

    @Override
    public Entity getPersonas(Map<String, String> request) throws IOException {
        String row = personasDao.findByRowKey(request.get("table"), request.get("key"));
        JSONObject obj = JSON.parseObject(row);
        return new Entity(obj);
    }
}