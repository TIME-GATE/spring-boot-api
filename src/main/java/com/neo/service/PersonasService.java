package com.neo.service;

import java.io.IOException;
import org.apache.commons.lang.StringUtils;
import java.util.Map;

import com.neo.common.Entity;

/**
 * Service 接口层
 *
 * Created by Joseph on 04/11/2017.
 */
public interface PersonasService {

    /**
     * 获取客户画像
     *
     * @param
     * @return
     */ 
    Entity getPersonas(Map<String, String> request) throws IOException;
}