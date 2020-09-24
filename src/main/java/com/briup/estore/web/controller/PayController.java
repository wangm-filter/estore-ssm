package com.briup.estore.web.controller;

import com.alipay.api.AlipayClient;
import com.alipay.api.domain.AlipayTradePayModel;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.briup.estore.util.AlipayConfig;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@Controller
public class PayController {
    @RequestMapping("/pay")
    public void pay(@RequestParam String amount, HttpServletResponse response) {
        // 设置参数
        try {
            AlipayClient alipayClient =
                    AlipayConfig.getAlipayClient();
            //设置请求参数
            AlipayTradePagePayRequest alipayRequest =
                    new AlipayTradePagePayRequest();

            AlipayTradePayModel model =
                    new AlipayTradePayModel();
            //生成订单号
            String outTradNo = "";
            Date date = new Date();
            for(int i = 0;i<3;i++){
                long no = date.getTime();
                outTradNo = no+""+(int)Math.random()*10;
            }
            // 设定订单号 必须要写
            model.setOutTradeNo(outTradNo);
            // 设置订单金额
            model.setTotalAmount(amount);
            // 订单名字
            model.setSubject("书籍订单");
            // 订单描述
            model.setBody(System.currentTimeMillis() + "");

            // 产品码
            model.setProductCode("FAST_INSTANT_TRADE_PAY");


            alipayRequest.setBizModel(model);

            // 设置回调地址
            alipayRequest.setReturnUrl(AlipayConfig.return_url);
            String result = alipayClient.pageExecute(alipayRequest).getBody();


            response.setContentType("text/html;charset=utf-8");
            response.getWriter().println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
