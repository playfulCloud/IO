package org.ptaszek.Controller;

public class PaymentValidator {
<<<<<<< Updated upstream
    publi2c boolean validate(String title, String date, int amount, int senderId, int receiverId, String currency) {
        if (title == null || date == null || senderId == null || receiverId == null || currency == null) {
=======
    public static boolean validate(String title, String date, int amount, int senderId, int receiverId, String currency) {
        if (title == null || date == null || senderId == 0 || receiverId == 0 || currency == null) {
>>>>>>> Stashed changes
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
