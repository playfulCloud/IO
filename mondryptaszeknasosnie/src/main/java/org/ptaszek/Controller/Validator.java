package org.ptaszek.Controller;

import org.ptaszek.Model.RegistrationData;
import org.ptaszek.Model.UserData;

public interface Validator{

    boolean validate(RegistrationData data);
    boolean validate(UserData data);
    boolean checkLengthCondition(String data);
    boolean checkNullCondition(String data);

    boolean validate(RecurrentPaymentForm form);
}
