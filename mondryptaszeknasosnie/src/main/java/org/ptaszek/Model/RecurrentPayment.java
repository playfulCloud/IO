package org.ptaszek.Model;

import java.time.Period;
import java.util.Date;

public class RecurrentPayment {
    public Period period;
    public Date firstPayment;
    public Payment template;

    public RecurrentPayment(Period period, Date firstPayment, Payment template) {
        this.period = period;
        this.firstPayment = firstPayment;
        this.template = template;
    }

    /**
     *
     * @param date
     */
    public boolean between(Date date) {
        // TODO - implement RecurrentPayment.between
        throw new UnsupportedOperationException();
    }
}
