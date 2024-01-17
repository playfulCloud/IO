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



    }

    @Test
    void validationFailDueToNulls() {
        String name = "Jan";
        String PESEL = "90090515836";
        String IDNumber = "ABC1234567";
        String mailAdress = "jan.kowalski@example.com";
        Date birthDate = new Date();
        UserData data = new UserData("IgorSosna", "KochamJave123*");

        oneOfParametersIsNull = new RegistrationData(name, null, PESEL, IDNumber, mailAdress, birthDate, data);

        RegistrationDataValidator validator = new RegistrationDataValidator();
        boolean response = validator.validate(oneOfParametersIsNull);
        assertFalse(response);
    }

    @Test
    void validationFailDueToInvalidData() {
        String name = "Jan";
        String surname = "Kowalski";
        String PESEL = "90090515836";
        String IDNumber = "ABC1234567";
        Date birthDate = new Date();
        UserData data = new UserData("IgorSosna", "KochamJave123*");

        oneOfParameterIsInvalid = new RegistrationData(name, surname, PESEL, IDNumber, "", birthDate, data);

        RegistrationDataValidator validator = new RegistrationDataValidator();
        boolean response = validator.validate(oneOfParameterIsInvalid);
        assertFalse(response);
    }


    @Test
    void successfulValidation() {
        String name = "Jan";
        String surname = "Kowalski";
        String PESEL = "90090515836";
        String IDNumber = "ABC1234567";
        String mailAdress = "jan.kowalski@example.com";
        Date birthDate = new Date();
        UserData data = new UserData("IgorSosna", "KochamJave123*");

        corrrectData = new RegistrationData(name, surname, PESEL, IDNumber, mailAdress, birthDate, data);

        RegistrationDataValidator validator = new RegistrationDataValidator();
        boolean response = validator.validate(corrrectData);
        assertTrue(response);
    }

}