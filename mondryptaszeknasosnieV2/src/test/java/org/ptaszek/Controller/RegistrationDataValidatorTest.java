package org.ptaszek.Controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.ptaszek.Model.RegistrationData;
import org.ptaszek.Model.UserData;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
@Tag("Registration")
class RegistrationDataValidatorTest {


    private RegistrationData corrrectData;
    private RegistrationData oneOfParameterIsInvalid;
    private RegistrationData oneOfParametersIsNull;

    @BeforeEach
    void setUp() {
        String name = "Jan";
        String surname = "Kowalski";
        String PESEL = "90090515836";
        String IDNumber = "ABC1234567";
        String mailAdress = "jan.kowalski@example.com";
        Date birthDate = new Date();
        UserData data = new UserData("IgorSosna", "KochamJave123*");

        corrrectData = new RegistrationData(name, surname, PESEL, IDNumber, mailAdress, birthDate, data);
        oneOfParameterIsInvalid = new RegistrationData(name, surname, PESEL, IDNumber, "", birthDate, data);
        oneOfParametersIsNull = new RegistrationData(name, null, PESEL, IDNumber, mailAdress, birthDate, data);
    }




    @Test
    void validationFailDueToNulls() {
       RegistrationDataValidator validator = new RegistrationDataValidator();
        boolean validationWithIncorrectData = validator.validate(oneOfParametersIsNull);
        assertFalse(validationWithIncorrectData);
    }

    @Test
    void validationFailDueToInvalidData() {
        RegistrationDataValidator validator = new RegistrationDataValidator();
        boolean validationWithInvalidData = validator.validate(oneOfParameterIsInvalid);
        assertFalse(validationWithInvalidData);
    }


    @Test
    void successfulValidation() {
        RegistrationDataValidator validator = new RegistrationDataValidator();
        boolean validationWithCorrectData = validator.validate(corrrectData);
        assertTrue(validationWithCorrectData);
    }

}