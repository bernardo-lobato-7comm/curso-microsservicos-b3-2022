package com.br.paymentservice.application.port.inbound;

public interface PaymentInbound {
    void paymentApproved(String orderId);
}
