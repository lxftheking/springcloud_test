package com.thekingqj.springcloud.dao;

import com.thekingqj.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PaymentDao
{
    public void create(Payment payment);

    public Payment getPaymentById(Long id);

   public  void update(Payment payment);

    List<Payment> list();

    void delete(Long id);
}
