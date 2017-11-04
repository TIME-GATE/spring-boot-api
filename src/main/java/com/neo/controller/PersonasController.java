package com.neo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
import java.io.IOException;

import com.neo.service.PersonasService;
import com.neo.common.Context;
import com.alibaba.fastjson.JSONObject;

@RestController
public class PersonasController {
	
    @Autowired
    private PersonasService personasService;

    @RequestMapping(value = "/v1/api/getPersonas", method = RequestMethod.GET)
    public Context getPersonas(@RequestParam Map<String, String> request) throws IOException {
        return personasService.getPersonas(request);
    }

    @RequestMapping(value = "/v1/api/postPersonas", method = RequestMethod.POST)
    public Context postPersonas(@RequestParam Map<String, String> request) throws IOException {
        return personasService.getPersonas(request);
    }

    @RequestMapping(value = "/v1/api/putPersonas", method = RequestMethod.PUT)
    public Context putPersonas(@RequestParam Map<String, String> request) throws IOException {
        return personasService.getPersonas(request);
    }

}
