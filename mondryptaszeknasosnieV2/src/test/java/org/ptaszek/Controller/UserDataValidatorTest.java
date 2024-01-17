package org.ptaszek.Controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.ptaszek.Model.UserData;

import static org.junit.jupiter.api.Assertions.*;

class UserDataValidatorTest {
    UserData correctlyCreatedData;
    UserData userDataWithNulls;
    UserData tooShortData;

    @BeforeEach
    void setUp() {
        correctlyCreatedData = new UserData(
                "IgorSonsa",
                "WoliWCeplusie"
        );

        userDataWithNulls = new UserData(
                null,
                null
        );

        tooShortData = new UserData(
                "luki",
                "m"
        );
    }


    @Test
    void validationFailDueToNulls() {
        UserDataValidator validator = new UserDataValidator();
        boolean validationWithIncorrectData = validator.validate(userDataWithNulls);
        assertFalse(validationWithIncorrectData);
    }

    @Test
    void validationFailDueToTooShortData() {
        UserDataValidator validator = new UserDataValidator();
        boolean validationWithTooShortData = validator.validate(tooShortData);
        assertFalse(validationWithTooShortData);
    }


    @Test
    void successfulValidation() {
        UserDataValidator validator = new UserDataValidator();
        boolean validationWithCorrectData = validator.validate(correctlyCreatedData);
        assertTrue(validationWithCorrectData);
    }
}