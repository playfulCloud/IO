package org.ptaszek.Controller;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.ptaszek.Model.RegistrationData;
import org.ptaszek.Model.UserData;

public class Fixture {
	public int a;

	    public String name;
	    public String surname;
	    public String PESEL;
	    public String IDNumber;
	    public String mailAdress;
	    public java.util.Date birthDate;

	    private String data_login;
	    private String data_password;

	public Fixture() {}

	public void setName(String v) { name = v; }
	public void setSurname(String v) { surname = v; }
	public void setPESEL(String v) { PESEL = v; }
	public void setIDNumber(String v) { IDNumber = v; }
	public void setMailAdress(String v) { mailAdress = v; }
	public void setBirthDate(String v) { try { birthDate = new SimpleDateFormat("yyyy-mm/dd").parse(v); } catch(Exception e){} } // .-.


	public void setLogin(String v) { data_login = v; }
	public void setPassword(String v) { data_password = v; }
	
	public int register() {
		var ud = new UserData(data_login, data_password);
		var rd = new RegistrationData(name, surname, PESEL, IDNumber, mailAdress, birthDate, ud);

		var a = new Application();
		var response = a.register(rd);

		return response.getCode();
	}
}
