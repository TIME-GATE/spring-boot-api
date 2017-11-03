package com.neo.controller;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

import com.neo.service.PersonasService;

@RestController
public class PersonasController {
	
    //@Autowired
    private PersonasService personasService = new PersonasService();

    @RequestMapping(value = "/v1/api/getPersonas", method = RequestMethod.GET)
    public String getPersonas(@RequestParam Map<String, String> request) throws IOException {
        return personasService.getPersonas();
    }

}
