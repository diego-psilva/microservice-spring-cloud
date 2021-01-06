package com.dev.hrpayroll.service;

import com.dev.hrpayroll.entities.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public Payment getPayment (Long id, Integer days){

        return new Payment("Bob", 200.0, days);
    }

}
