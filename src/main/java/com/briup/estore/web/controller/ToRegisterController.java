package com.briup.estore.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author wangm
 */
@Controller
public class ToRegisterController{

	@RequestMapping("/toRegister")
	public String toRegister(){
		return "register";
	}
}
