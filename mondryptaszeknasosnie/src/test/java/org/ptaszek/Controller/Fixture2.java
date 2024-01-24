package org.ptaszek.Controller;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.ptaszek.Model.RegistrationData;
import org.ptaszek.Model.UserData;

public class Fixture2 {
	    public String tile;
	    public java.util.Date date;
	    public int amount;
	    public int senderid;
	    public int recieverid;
	    public String currentcy;


	public Fixture2() {}

	public void setTitle(String v) { tile = v; }
	public void setDate(String v) {  try { date = new SimpleDateFormat("yyyy-mm-dd").parse(v); } catch(Exception e){} }
	public void setAmount(int v) { amount = v; }
	public void setSenderId(int v) { senderid = v; }
	public void setReceiverId(int v) { recieverid = v; }
	public void setCurrency(String v) { currentcy = v; } // .-.

	
	public boolean addPayment() {
		return Application.instance.addPayment(tile, date, amount,senderid, recieverid, currentcy);
	}

	

	public int getPaymentsAmount() {
		return Application.instance.getPaymentsAmoint();
	}
}

