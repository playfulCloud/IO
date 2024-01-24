package org.ptaszek.Controller;

import java.util.Date;

import org.ptaszek.Model.*;

public class Application {

    private RecurrentPaymentDBManager recurrentPayments = new RecurrentPaymentDBManager();
    private InternalPaymentProcessor ipp = new InternalPaymentProcessor();
    private ExternalPaymentProcessor epp = new ExternalPaymentProcessor();

    private RecurrentPaymentValidator validator;
    private RegistrationDataValidator registrationDataValidator = new RegistrationDataValidator();
    private UserDataValidator userDataValidator = new UserDataValidator();

    private DBManager<RegistrationData>registrationDataDBManager = new DBManager<>();


    public static Application instance = new Application();

    public static void main(String[] args) {
        var app = new Application();
    }


    public BankResponse register(RegistrationData obj) {

        if(registrationDataValidator.validate(obj)){
            registrationDataDBManager.insert(obj);
            return new BankResponse("Registration Completed", 200);
        }else{
            return new BankResponse("Data is invalid", 400);
        }
    }

    public boolean addPayment(String title, Date date, int amount, int senderId, int receiverId, String currency) {
        if (PaymentValidator.validate(title, date, amount, senderId, receiverId, currency)) {

            var payment = new Payment();
            payment.title = title;
            payment.date = date;
            payment.amount = amount;
            payment.sender = new InternalBankAccount();
            payment.reciever = new InternalBankAccount();
            if (currency == "PLN")
                payment.currency = Currency.PLN;
            else if (currency == "USD")
                payment.currency = Currency.USD;
            else if (currency == "EUR")
                payment.currency = Currency.EUR;

            return ipp.addPayment(payment);
        } else {
            return false;
        }
    }

    public int getPaymentsAmoint() {
	    return 1234; // TODO, or not TODO
    }

    public BankResponse login(UserData obj) {
        if (userDataValidator.validate(obj)) {
            return new BankResponse("Login successful", 200);
        } else {
            return new BankResponse("Login unsuccessful ", 400);
        }
    }


    public BankResponse manageRecurrentPayment(RecurrentPaymentOperation operation, RecurrentPaymentForm form) {
        if (operation == RecurrentPaymentOperation.Update) {
            if (validator.validate(form)){
                throw new RuntimeException("Error during updating");
            }
            recurrentPayments.update(form.getId(), form.getRecurrentPayment());
            return new BankResponse("Succesfull update",200);
        }
        else if (operation == RecurrentPaymentOperation.Delete) {
            if (!validator.validate(form)){
                throw new RuntimeException("Error during updating");
            }
            recurrentPayments.delete(form.getId());
            return new BankResponse("Succesful deletion",200);
        }
        else if (operation == RecurrentPaymentOperation.Insert) {
            if (validator.validate(form)){
                throw new RuntimeException("Error during updating");
            }
            recurrentPayments.insert(form.getRecurrentPayment());
            return new BankResponse("Succesful Insertion",200);
        }
        throw new UnsupportedOperationException();
    }

    public void setValidator(RecurrentPaymentValidator validator) {
        this.validator = validator;
    }



}
