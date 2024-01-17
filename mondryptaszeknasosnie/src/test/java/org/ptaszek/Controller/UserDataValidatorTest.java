package org.ptaszek.Controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.ptaszek.Model.UserData;

import static org.junit.jupiter.api.Assertions.*;

class UserDataValidatorTest {


    @BeforeEach
    void setUp() {

    }


    @Test
    void validationFailDueToNulls() {
        UserData userDataWithNulls = new UserData(
                null,
                null
        );

        UserDataValidator validator = new UserDataValidator();
        boolean validationWithIncorrectData = validator.validate(userDataWithNulls);
        assertFalse(validationWithIncorrectData);
    }

    @Test
    void validationFailDueToTooShortData() {
        UserData tooShortData = new UserData(
                "luki",
                "m"
        );
        UserDataValidator validator = new UserDataValidator();
        boolean validationWithTooShortData = validator.validate(tooShortData);
        assertFalse(validationWithTooShortData);
    }


    @Test
    void successfulValidation() {
        UserData correctlyCreatedData = new UserData(
                "IgorSonsa",
                "WoliWCeplusie"
        );
        UserDataValidator validator = new UserDataValidator();
        boolean validationWithCorrectData = validator.validate(correctlyCreatedData);
        assertTrue(validationWithCorrectData);
    }
}