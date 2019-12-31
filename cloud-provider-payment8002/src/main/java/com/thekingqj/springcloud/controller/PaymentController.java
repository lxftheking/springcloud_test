package com.thekingqj.springcloud.controller;


import com.thekingqj.springcloud.entities.CommonResult;
import com.thekingqj.springcloud.entities.Payment;
import com.thekingqj.springcloud.service.PaymentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment){

          paymentService.create(payment);

          return  new CommonResult(200,"ok",payment);

    }

    @GetMapping("/payment/get/{id}")
    public CommonResult getPayment(@PathVariable("id") long id){
        System.out.println("111");
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
