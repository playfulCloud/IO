package org.ptaszek.Controller;

import org.ptaszek.Model.RegistrationData;
import org.ptaszek.Model.UserData;

public class RegistrationDataValidator implements Validator {


    @Override
    public boolean validate(RegistrationData data) {
        return
                checkNullCondition(data.name) &&
                checkNullCondition(data.surname) &&
                checkNullCondition(data.PESEL) &&
                checkNullCondition(data.IDNumber) &&
                        checkEmailAdress(data.mailAdress) &&
                        checkPassword(data.data.getPassword()) &&
                        checkPesel(data.PESEL) &&
                        checkIDNumber(data.IDNumber) &&
                        checkLengthCondition(data.data.getLogin()) &&
                        checkLengthCondition(data.data.getPassword());
    }

    @Override
    public boolean validate(UserData data) {
        return false;
    }

    @Override
    public boolean checkLengthCondition(String data){
        return data.length() > 5 && data.length() < 50;
    }

    @Override
    public boolean checkNullCondition(String data){
        return data != null;
    }

    @Override
    public boolean validate(RecurrentPaymentForm form) {
        return false;
    }

    public boolean checkPassword(String password){
        return password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9]).*$");
    }

    public boolean checkEmailAdress(String email){
        return email.matches("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$");
    }

    public boolean checkPesel(String pesel){
        return pesel.length() == 11;
    }

    public boolean checkIDNumber(String id){
        return id.length() == 10;
    }
}
