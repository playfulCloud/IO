package org.ptaszek.Controller;

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
            return new BankResponse("Chuj ci w dupe - Data is invalid", 400);
        }
    }


    public BankResponse login(UserData obj) {
        if (userDataValidator.validate(obj)) {
            return new BankResponse("Login Completed", 200);
        } else {
            return new BankResponse("Login Completed", 200);
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
            return new BankResponse("Succesfull delete",200);
        }
        else if (operation == RecurrentPaymentOperation.Insert) {
            if (validator.validate(form)){
                throw new RuntimeException("Error during updating");
            }
            recurrentPayments.insert(form.getRecurrentPayment());
            return new BankResponse("Succesfull Insert",200);
        }
        throw new UnsupportedOperationException();
    }

    public void setValidator(RecurrentPaymentValidator validator) {
        this.validator = validator;
    }
//
//    public void executeRecurrentPayments() {
//        var payments = recurrentPayments.select();
//        for (var payment : payments) {
//            if (!payment.between(Date.now()) ) continue;
//
//            if (payment.template.reciever instanceof InternalBankAccount)
//                ipp.pay(payment.template);
//            else if (payment.template.reciever instanceof ExternalPaymentProcessor)
//                epp.pay(payment.template);
//        }
//    }
//


}
