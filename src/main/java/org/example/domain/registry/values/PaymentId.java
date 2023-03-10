package org.example.domain.registry.values;

import org.example.generic.Identity;

public class PaymentId extends Identity {

    private PaymentId(String uuid){
        super(uuid);
    }

    public PaymentId(){}

    public static PaymentId of (String uuid){
        return new PaymentId(uuid);
    }
}
