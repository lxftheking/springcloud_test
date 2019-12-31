package com.thekingqj.springcloud.feign;

import com.thekingqj.springcloud.entities.CommonResult;
import com.thekingqj.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient("cloud-payment-service")
public interface ConsumerFeign {

    @GetMapping("/payment/get/{id}")
    CommonResult getPayment(@PathVariable("id") long id);

    @PostMapping("/payment/create")
    CommonResult create(@RequestBody Payment payment);

    @PutMapping("/payment/update")
    CommonResult update(@RequestBody Payment payment);

    @DeleteMapping("/payment/delete/{id}")
    CommonResult delete(@PathVariable("id") long id);

    @GetMapping("/payment/list")
    CommonResult delete();

}
