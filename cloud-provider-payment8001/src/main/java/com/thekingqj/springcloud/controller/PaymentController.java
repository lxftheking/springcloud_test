package com.thekingqj.springcloud.controller;



import com.thekingqj.springcloud.entities.CommonResult;
import com.thekingqj.springcloud.entities.Payment;
import com.thekingqj.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;

import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RefreshScope
public class PaymentController {

    @Value("${myName}")
    private String name;
    @Value("${redis.name}")
    private String redisName;
    @Value("${jdbc.name}")
    private String jdbcName;

    @Resource
    private PaymentService paymentService;

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment){

          paymentService.create(payment);
          return  new CommonResult(200,"ok",payment);

    }
    @GetMapping("/hi")
    public String hello(HttpServletRequest request){
        System.out.println(request.getRequestURL().toString());
        System.out.println(request.getRequestURI());
        return "hi";
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult getPayment(@PathVariable("id") long id){
        System.out.println(name+"\t"+redisName+"\t"+jdbcName);
        Payment payment = paymentService.getPaymentById(id);
        return  new CommonResult(200,"ok",payment);
    }
   @PutMapping("/payment/update")
    public CommonResult update(@RequestBody Payment payment){
          paymentService.update(payment);
        return new CommonResult(200,"ok",payment);
   }

   @DeleteMapping("/payment/delete/{id}")
   public CommonResult delete(@PathVariable("id") long id){
       paymentService.delete(id);
       return new CommonResult(200,"ok",id);
   }
   
   @GetMapping("/payment/list")
   public CommonResult delete(){
       List<Payment> list = paymentService.list();
       return new CommonResult(200,"ok",list);
   }


}
