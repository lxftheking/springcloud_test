package com.thekingqj.springcloud.service;

import com.thekingqj.springcloud.entities.Payment;

import java.util.List;

public  interface PaymentService {

    public void create(Payment payment);

    public void delete(Long id);

    public void update(Payment payment);

    public Payment getPaymentById(Long id);

    public List<Payment> list();

}
