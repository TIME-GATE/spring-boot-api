package com.joseph.service.impl;

import java.io.IOException;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import com.joseph.dao.PersonasDao;
import com.joseph.common.Entity;
import com.joseph.service.PersonasService;

/**
 * 逻辑实现
 *
 * Created by Joseph on 05/11/2017.
 */
@Service
public class PersonasServiceImpl implements PersonasService {

    @Autowired
    private PersonasDao personasDao;

    @Override
    public Entity getPersonas(Map<String, String> request) throws IOException {
        String row = personasDao.findByRowKey(request);
        JSONObject obj = JSON.parseObject(row);
        return new Entity(obj);
    }

    @Override
    public Entity getColumnVersion(Map<String, String> request) throws IOException {
        String row = personasDao.findByRowColumn(request);
        JSONObject obj = JSON.parseObject(row);
        return new Entity(obj);
    }

    @Override
    public Entity regixRowByPre(Map<String, String> request) throws IOException {
        String allRow = personasDao.findAllRowByPre(request);
        JSONObject obj = JSON.parseObject(allRow);
        return new Entity(obj);
    }

    @Override
    public Entity regixTableFilter(Map<String, String> request) throws IOException {
        String allRow = personasDao.findAllRowByFilter(request);
        JSONObject obj = JSON.parseObject(allRow);
        return new Entity(obj);
    }

    @Override
    public Entity putPersonas(Map<String, String> request) throws IOException {
        String row = personasDao.putByRowKey(request);
        JSONObject obj = JSON.parseObject(row);
        return new Entity(obj);
    }

}