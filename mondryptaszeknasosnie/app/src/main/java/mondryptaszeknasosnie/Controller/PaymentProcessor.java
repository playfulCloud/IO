package mondryptaszeknasosnie.Controller;

import mondryptaszeknasosnie.Model.*;

public interface PaymentProcessor {

	/**
	 * 
	 * @param payment
	 */
	abstract void pay(Payment payment);

}