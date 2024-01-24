package org.ptaszek.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

// import jdk.jpackage.internal.Executor;

public class RegistrationDataDBManager extends DBManager<RegistrationData> {

	@Override
	public boolean insert(RegistrationData obj) {
		Connection connection;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306", "root", "");
		} catch (Exception r) { return false; }


		try {
			var s = connection.createStatement();
			var seks = s.executeQuery("insert into Users values (null,"
					+ "\'" +obj.name + "\', "
					+ "\'" +obj.surname + "\', "
					+ "\'" +obj.PESEL + "\', "
					+ "\'" +obj.IDNumber + "\', "
					+ "\'" +obj.mailAdress + "\', "
					+ "\'" +obj.birthDate + "\', "
					+ "\'" +obj.data.getLogin() + "\', "
					+ "\'" +obj.data.getPassword() + "\' "
					+ ")");
		} catch (Exception e) {return false; }

		return true;
	}

	@Override
	public List<RegistrationData> select() {
		Connection connection;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306", "root", "");
		} catch (Exception r) { return null; }

		var aaa = new ArrayList<RegistrationData>();
		try {
			var s = connection.createStatement();
			var seks = s.executeQuery("select * from User");

			while (seks.next()) {
				var id = seks.getInt("id");
				var name = seks.getString("name");
				var surname = seks.getString("surname");
				var pesel = seks.getString("pesel");
				var idnumber = seks.getString("IDNumber");
				var mailAddress = seks.getString("mailAddress");
				var birthDate = seks.getDate("birthDate");
				
				var login = seks.getString("login");
				var password = seks.getString("password");

				var o = new RegistrationData(
					name,
					surname,
					pesel,
					idnumber,
					mailAddress,
					birthDate,
					new  UserData(login, password)
				);


				aaa.add(o);
			}

		} catch (Exception e) { return null; }

		return aaa;
	}
}
