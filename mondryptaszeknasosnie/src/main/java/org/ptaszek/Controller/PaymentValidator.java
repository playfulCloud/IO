package org.ptaszek.Controller;

public class PaymentValidator {
    public boolean validate(String title, String date, int amount, int senderId, int receiverId, String currency) {
        if (title == null || date == null || senderId == null || receiverId == null || currency == null) {
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
