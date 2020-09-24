package com.briup.estore.web.controller;

import com.briup.estore.bean.Customer;
import com.briup.estore.bean.ShopCar;
import com.briup.estore.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * @author wangm
 */
@Controller
public class LoginController {

    @Autowired
    private ICustomerService customerService;

    @RequestMapping("/login")
    public String login(@RequestParam String name, @RequestParam String password,HttpSession session){

        try {
            Customer customer = customerService.login(name,password);

            ShopCar shopCar = new ShopCar();

            session.setAttribute("customer",customer);
            session.setAttribute("shopCar", shopCar);
            return  "forward:toindex";
        } catch (Exception e) {
            session.setAttribute("msg", "用户名或密码错误!!!");
            return "forward:toLogin";
        }
    }
}
