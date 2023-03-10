package org.example.domain.registry;

import org.example.domain.registry.values.PaymentId;
import org.example.domain.registry.values.PaymentInfo;
import org.example.generic.Entity;

public class Payment extends Entity<PaymentId> {

    private PaymentInfo paymentInfo;

    public Payment (PaymentId entityId, PaymentInfo paymentInfo){
        super(entityId);
        this.paymentInfo = paymentInfo;
    }

    public void updatePaymentInfo(PaymentInfo newPaymentInfo){
        paymentInfo = newPaymentInfo;
    }
}
