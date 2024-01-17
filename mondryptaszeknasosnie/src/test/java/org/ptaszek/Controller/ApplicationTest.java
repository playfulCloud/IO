package org.ptaszek.Controller;


import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.ptaszek.Model.BankResponse;
import org.ptaszek.Model.RegistrationData;
import org.ptaszek.Model.UserData;

import java.util.Date;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@Tag("Facade")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ApplicationTest {
//Specific test method order to test TestMethodOrderer functionality
    private RegistrationData correctData;
    private RegistrationData incorrectData;
    private BankResponse expectedResponse;
    private RecurrentPaymentForm form;


    @Mock
    private RecurrentPaymentValidator validatorMock;

    private BankResponse updateResponse;


    @InjectMocks
    private Application application;

    private UserData data;
    private UserData data2;

    @BeforeEach
    void setUp() {

        data = new UserData("IgorSosna", "KochamJave123*");
        data2 = new UserData("IgorSosna", "");


        expectedResponse = new BankResponse("Registration Completed", 200);
        updateResponse = new BankResponse("Succesfull update", 200);

        form = new RecurrentPaymentForm();
        MockitoAnnotations.initMocks(this);
    }


    @Test
    @Order(1)
    void correctRegistrationProcess() {
        String name = "Jan";
        String surname = "Kowalski";
        String PESEL = "90090515836";
        String IDNumber = "ABC1234567";
        String mailAdress = "jan.kowalski@example.com";
        Date birthDate = new Date();
        data = new UserData("IgorSosna", "KochamJave123*");
        correctData = new RegistrationData(name, surname, PESEL, IDNumber, mailAdress, birthDate, data);

        Application application = new Application();
        BankResponse actualResponse = application.register(correctData);

        assertEquals(actualResponse.getMessage(), expectedResponse.getMessage());
        assertEquals(actualResponse.getCode(), expectedResponse.getCode());
    }

    @Test
    @Order(2)
    void exceptionDuringRegistrationProcess() {
        String name = "Jan";
        String surname = "Kowalski";
        String PESEL = "90090515836";
        String IDNumber = "ABC1234567";
        String mailAdress = "jan.kowalski@example.com";
        Date birthDate = new Date();

        incorrectData = new RegistrationData(name, surname, PESEL, IDNumber, mailAdress, birthDate, data2);

        Application application = new Application();
        assertThrows(UnsupportedOperationException.class, () -> {
            application.register(incorrectData);
        });
    }


    @Test
    @Order(3)
    void exceptionDuringManagingPayments() {
        when(validatorMock.validate(form)).thenReturn(true);
        assertThrows(RuntimeException.class, () -> {
            application.manageRecurrentPayment(RecurrentPaymentOperation.Update, form);
        });
    }


    @Test
    @Order(5)
    void correctRecurrentPaymentManaged() {
        when(validatorMock.validate(form)).thenReturn(false);
        BankResponse actual = application.manageRecurrentPayment(RecurrentPaymentOperation.Update, form);

        assertEquals(actual.getMessage(), updateResponse.getMessage());
        assertEquals(actual.getCode(), updateResponse.getCode());
    }

    @ParameterizedTest
    @Order(6)
    @MethodSource("allLoginData")
    void allLoginExampleTest(UserData data) {
        Application application = new Application();
        BankResponse expected = application.login(data);
        assertEquals(expected.getMessage(), "Login Completed");
    }

    private static Stream<Arguments> allLoginData() {
        return Stream.of(
                Arguments.of(new UserData("Igor123", "Sosna1")),
                Arguments.of(new UserData("Łukasz123", "Mądry5")),
                Arguments.of(new UserData("Kuba123", "Ptaszek")),
                Arguments.of(new UserData("Daniel", "Wombat")),
                Arguments.of(new UserData("Tomasz", "Kapucyn")));
    }


}