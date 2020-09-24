package com.briup.estore.web.controller;

import com.briup.estore.bean.Book;
import com.briup.estore.bean.OrderLine;
import com.briup.estore.bean.ShopCar;
import com.briup.estore.service.IBookservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * @author wangm
 */
@Controller
public class AddShopCarController {
    @Autowired
    //@Resource
    private IBookservice bookservice;

    @RequestMapping("/user/addShopCar")
    public String addShopCar(@RequestParam String id,@RequestParam String num,HttpSession session){
        if (id != null && num != null) {
            Book book = bookservice.selectBookById(Integer.parseInt(id));

            OrderLine line = new OrderLine();
            line.setBook(book);
            line.setNum(Integer.parseInt(num));
            line.setCost(book.getPrice() * line.getNum());

            ShopCar shopCar = (ShopCar) session.getAttribute("shopCar");
            if (shopCar != null) {
                shopCar.addShopCar(line);
            }
        }
        return "/user/shopCar";
    }
}
