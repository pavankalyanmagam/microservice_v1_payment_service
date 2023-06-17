package com.dailycodebuffer.paymentservice.service;

import com.dailycodebuffer.paymentservice.model.PaymentRequest;

public interface PaymentService {
    long doPayment(PaymentRequest paymentRequest);
}
