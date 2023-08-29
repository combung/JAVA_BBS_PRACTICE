package com.web.kms_practice.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Controller;

@Controller
public class PageController {
    
    @GetMapping("/mainpage")
    public String index(){
        return "/mainpage.html";
    }
}
