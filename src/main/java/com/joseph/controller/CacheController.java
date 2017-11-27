package com.joseph.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
import java.io.IOException;

import com.joseph.service.CacheService;
import com.joseph.common.Entity;

/**
 * Api
 *
 * Created by Joseph on 05/11/2017.
 */
@RestController
public class CacheController {
	
    @Autowired
    private CacheService cacheService;

    @RequestMapping(value = "/v1/api/getCache", method = RequestMethod.GET)
    public Entity getCache(@RequestParam Map<String, String> request) throws IOException {
        return cacheService.getCache(request);
    }

    @RequestMapping(value = "/v1/api/setCache", method = RequestMethod.POST)
    public Entity setCache(@RequestParam Map<String, String> request) throws IOException {
        return cacheService.setCache(request);
    }

}
