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
        return true; // TODO: wypierdol to do współdzielonego miejsca, aby wszystkie walidatory mogły używać
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
        return true;
    }
    public boolean checkPassword(String password){
	    return password.length() >= 6 && password.length() =< 64;
        // return password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9]).*$");
    }
// TODO: wypierdol to do współdzielonego miejsca, aby wszystkie walidatory mogły używać
    public boolean checkEmailAdress(String email){
	    return email.contains("@");
        // return email.matches("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$");
    }
// TODO: wypierdol to do współdzielonego miejsca, aby wszystkie walidatory mogły używać
    public boolean checkPesel(String pesel){
        return pesel.length() == 11;
    }
// TODO: wypierdol to do współdzielonego miejsca, aby wszystkie walidatory mogły używać
    public boolean checkIDNumber(String id){
        return id.length() == 10;
    }
}
