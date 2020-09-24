package com.briup.estore.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ASUS
 */
@Controller
public class ToLoginController {
    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }
}
