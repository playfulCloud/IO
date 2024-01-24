package org.ptaszek.Controller;

import java.util.Date;

public class PaymentValidator {
    public static boolean validate(String title, Date date, int amount, int senderId, int receiverId, String currency) {
        if (title == null || date == null || senderId == 0 || receiverId == 0 || currency == null) {
            return false;
        }

        if (senderId == receiverId) {
            return false;
        }

        if (currency != "PLN" && currency != "EUR" && currency != "USD") {
            return false;
        }
        return true;
    }
}
