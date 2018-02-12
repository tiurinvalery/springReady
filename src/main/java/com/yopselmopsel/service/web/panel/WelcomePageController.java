package com.yopselmopsel.service.web.panel;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class WelcomePageController {
    @RequestMapping("/")
    public String rootPage(Map<String, Object> map) {
        return "rootPage";
    }
}
