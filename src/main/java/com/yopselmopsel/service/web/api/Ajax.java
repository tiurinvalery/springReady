package com.yopselmopsel.service.web.api;

import java.util.HashMap;
import java.util.Map;

public class Ajax {

    public static Map<String,Object> successResponse(Object object) {
        Map<String,Object> response = new HashMap<>();
        response.put("result","success");
        response.put("data",object);
        return response;
    }

    public static Map<String,Object> emptyResponse() {
        Map<String,Object> responce = new HashMap<>();
        responce.put("result","success");
        return responce;
    }

    public static Map<String,Object> errorMessage(String errorMessage) {
        Map<String,Object> response = new HashMap<>();
        response.put("result", "error");
        response.put("message",errorMessage);
        return response;
    }
}
