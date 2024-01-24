package org.ptaszek.Controller;

import org.ptaszek.Model.Payment;

public interface PaymentProcessor {
    public boolean addPayment(Payment payment);
}
