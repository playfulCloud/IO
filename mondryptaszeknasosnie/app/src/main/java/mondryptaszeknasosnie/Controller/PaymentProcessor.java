package Controller;

import Model.*;

public interface PaymentProcessor {

	/**
	 * 
	 * @param payment
	 */
	abstract void pay(Payment payment);

}