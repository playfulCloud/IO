package org.ptaszek.Model;

import java.util.Date;

public class Payment {
    public String title;
    public Date date;
    public int amount;
    public Account sender;
    public Account reciever;
    public Currency currency;


}
