package com.neo.service;

import java.io.IOException;
import org.apache.commons.lang.StringUtils;
import java.util.Map;

import com.neo.common.Context;

public interface PersonasService {

    /**
     * 获取客户画像
     *
     * @param
     * @return
     */ 
    Context getPersonas(Map<String, String> request) throws IOException;
}