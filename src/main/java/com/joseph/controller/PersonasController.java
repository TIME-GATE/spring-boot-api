package com.joseph.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
import java.io.IOException;

import com.joseph.service.PersonasService;
import com.joseph.common.Entity;
import com.alibaba.fastjson.JSONObject;

/**
 * Api
 *
 * Created by Joseph on 05/11/2017.
 */
@RestController
public class PersonasController {
	
    @Autowired
    private PersonasService personasService;

    @RequestMapping(value = "/v1/api/getPersonas", method = RequestMethod.GET)
    public Entity getPersonas(@RequestParam Map<String, String> request) throws IOException {
        return personasService.getPersonas(request);
    }

    @RequestMapping(value = "/v1/api/getPersonasHistory", method = RequestMethod.GET)
    public Entity getPersonasHistory(@RequestParam Map<String, String> request) throws IOException {
        return personasService.getPersonas(request);
    }

    @RequestMapping(value = "/v1/api/putPersonas", method = RequestMethod.PUT)
    public Entity putPersonas(@RequestParam Map<String, String> request) throws IOException {
        return personasService.putPersonas(request);
    }

}
