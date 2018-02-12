package com.yopselmopsel.service.web.api;

import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class ExceptionHandlerController {

    @ExceptionHandler(RestException.class)
    public @ResponseBody
    String handleException(RestException e){
        return "Error: " + e.getMessage();
    }
}
