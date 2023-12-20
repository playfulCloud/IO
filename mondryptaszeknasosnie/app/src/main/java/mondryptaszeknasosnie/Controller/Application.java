package mondryptaszeknasosnie.Controller;

import mondryptaszeknasosnie.Model.*;

public class Application {

	private RecurrentPaymentDBManager recurrentPayments = new RecurrentPaymentDBManager();
	private InternalPaymentProcessor ipp = new InternalPaymentProcessor();
	private ExternalPaymentProcessor epp = new ExternalPaymentProcessor();

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO - implement Application.main
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param obj
	 */
	public bankResponse register(RegistrationData obj) {
		// TODO - implement Application.register
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param obj
	 */
	public bankResponse login(LoginData obj) {
		// TODO - implement Application.login
		throw new UnsupportedOperationException();
	}

	/**
	 *  seks
	 * @param operation
	 */
	public void manageRecurrentPayment(RecurrentPaymentOperation operation) {
		// TODO - implement Application.manageRecurrentPayment
		throw new UnsupportedOperationException();
	}

	public void executeRecurrentPayments() {
		var payments = recurrentPayments.select();
		for (var payment : payments) {
			if (!payment.between(Date.now()) ) continue;

			if (payment.template.reciever instanceof InternalBankAccount) 
				ipp.pay(payment.template);
			else if (payment.template.reciever instanceof ExternalPaymentProcessor) 
				epp.pay(payment.template);
		}
	}

	/**
	 * 
	 * @param obj
	 */
	public bankResponse register(RegistrationData obj) {
		// TODO - implement Application.register
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param obj
	 */
	public bankResponse login(LoginData obj) {
		// TODO - implement Application.login
		throw new UnsupportedOperationException();
	}
}
