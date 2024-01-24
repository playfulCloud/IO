package org.ptaszek.Controller;

import org.ptaszek.Model.Payment;

public class InternalPaymentProcessor implements PaymentProcessor {

@Override
    public boolean addPayment(Payment payment) {
        return true;
    }
}
