package org.ptaszek.Model;

import java.util.Date;

public class RegistrationData  {

    public String name;
    public String surname;
    public String PESEL;
    public String IDNumber;
    public String mailAdress;
    public Date birthDate;

    public UserData data;


    public RegistrationData(String name, String surname, String PESEL, String IDNumber, String mailAdress, Date birthDate, UserData data) {
        this.name = name;
        this.surname = surname;
        this.PESEL = PESEL;
        this.IDNumber = IDNumber;
        this.mailAdress = mailAdress;
        this.birthDate = birthDate;
        this.data = data;
    }
}
