package com.dev.hrpayroll.service;

import com.dev.hrpayroll.entities.Payment;
import com.dev.hrpayroll.entities.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentService {

    @Value("${hr-worker.localhost}")
    private String workerHost;

    @Autowired
    RestTemplate restTemplate;

    public Payment getPayment (Long workerId, Integer days){

        Map<String, String> uriVariable = new HashMap<>();

        uriVariable.put("id",workerId.toString());

        Worker worker = restTemplate.getForObject(workerHost + "/workers/{id}", Worker.class, uriVariable);

        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }

}
