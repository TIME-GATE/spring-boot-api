package com.neo.common;

import java.util.Map;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by Joseph on 20/10/2017
 */

public class Context {

    private int code;
    private String msg;
    private String data;

    public Context send() {
        this.code = 0;
        return this;
    }

}