package com.dailycodebuffer.paymentservice.repository;

import com.dailycodebuffer.paymentservice.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
