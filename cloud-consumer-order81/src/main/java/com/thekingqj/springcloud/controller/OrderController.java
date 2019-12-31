package com.thekingqj.springcloud.controller;


import com.thekingqj.springcloud.entities.CommonResult;
import com.thekingqj.springcloud.entities.Payment;
import com.thekingqj.springcloud.feign.ConsumerFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    // public static final String PaymentSrv_URL = "http://localhost:8001";
    //    @Autowired
    //    private RestTemplate restTemplate;


    public static final String PaymentSrv_URL = "http://cloud-payment-service";

    @Autowired
    private ConsumerFeign feign;


    @GetMapping("/consumer/payment/create") //客户端用浏览器是get请求，但是底层实质发送post调用服务端8001
    public CommonResult create(Payment payment) {

        return feign.create(payment);
    }


    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult getPayment(@PathVariable Long id) {
        CommonResult payment = feign.getPayment(id);
        return  payment;
    }

    @GetMapping("/consumer/payment/list")
    public CommonResult list() {
        return  null;
    }



//    @GetMapping("/consumer/payment/update") //客户端用浏览器是get请求，但是底层实质发送post调用服务端8001
//    public CommonResult update(Payment payment)
//    {
//
//        return restTemplate.put();
//    }

//    @GetMapping("/consumer/payment/delete/{id}")
//    public CommonResult delete(@PathVariable Long id)
//    {
//
//        return restTemplate.delete(PaymentSrv_URL + "/payment/delete/"+id,id);
//    }

}
