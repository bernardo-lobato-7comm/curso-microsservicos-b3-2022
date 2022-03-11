package com.br.paymentservice.application.domain;

import lombok.Data;

@Data
public class Payment {

    private PaymentStatus paymentStatus;

    public Payment() {
    }

    public Payment(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}
