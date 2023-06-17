package com.dailycodebuffer.paymentservice.service;

import com.dailycodebuffer.paymentservice.entity.Payment;
import com.dailycodebuffer.paymentservice.model.PaymentRequest;
import com.dailycodebuffer.paymentservice.repository.PaymentRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@Log4j2
public class PaymentServiceImpl implements PaymentService{

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public long doPayment(PaymentRequest paymentRequest) {

       log.info("Recording Payment Details: {}", paymentRequest);

        Payment payment = Payment.builder()
                .paymentDate(Instant.now())
                .paymentMode(paymentRequest.getPaymentMode().name())
                .paymentStatus("SUCCESS")
                .orderId(paymentRequest.getOrderId())
                .amount(paymentRequest.getAmount())
                .build();


        paymentRepository.save(payment);


        log.info("Payment Completed with Id: {}", payment.getId());

        return payment.getId();
    }
}
