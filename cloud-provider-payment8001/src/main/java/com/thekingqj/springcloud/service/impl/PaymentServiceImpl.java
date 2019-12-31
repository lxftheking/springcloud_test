package com.thekingqj.springcloud.service.impl;

import com.thekingqj.springcloud.dao.PaymentDao;
import com.thekingqj.springcloud.entities.Payment;
import com.thekingqj.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;


    @Override
    public void create(Payment payment) {
        paymentDao.create(payment);
    }

    @Override
    public void delete(Long id) {
        paymentDao.delete(id);
    }

    @Override
    public void update(Payment payment) {
         paymentDao.update(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return  paymentDao.getPaymentById(id);
    }

    @Override
    public List<Payment> list() {
        return paymentDao.list();
    }
}
