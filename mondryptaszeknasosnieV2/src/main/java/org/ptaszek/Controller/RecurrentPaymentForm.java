package org.ptaszek.Controller;

import org.ptaszek.Model.RecurrentPayment;

public class RecurrentPaymentForm {
    private int id;
    public RecurrentPayment getRecurrentPayment(){
        return new RecurrentPayment(null,null,null);
    }

    public int getId() {
        return id;
    }
}
