package org.ptaszek.Controller;

import org.ptaszek.Model.RegistrationData;
import org.ptaszek.Model.UserData;

public class UserDataValidator implements Validator {

    @Override
    public boolean validate(UserData data){
       String login = data.getLogin();
       String password = data.getPassword();

       return checkNullCondition(login) && checkNullCondition(password) && checkLengthCondition(login) && checkLengthCondition(password);
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

    @Override
    public boolean validate(RegistrationData data) {
        return false;
    }
}
