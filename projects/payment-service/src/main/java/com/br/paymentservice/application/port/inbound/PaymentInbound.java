package com.br.paymentservice.application.port.inbound;

import java.util.UUID;

public interface PaymentInbound {
    String paymentApproved(UUID orderId);
}
