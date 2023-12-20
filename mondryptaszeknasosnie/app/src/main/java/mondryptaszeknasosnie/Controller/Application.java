package mondryptaszeknasosnie.Controller;

import mondryptaszeknasosnie.Model.*;

public class Application {

	private RecurrentPaymentDBManager recurrentPayments = new RecurrentPaymentDBManager();
	private InternalPaymentProcessor ipp = new InternalPaymentProcessor();
	private ExternalPaymentProcessor epp = new ExternalPaymentProcessor();

	private RecurentPaymentValidator validator = new RecurentPaymentValidator();

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
	public void manageRecurrentPayment(RecurrentPaymentOperation operation, form: Object) {
		if (operation == RecurrentPaymentOperation.Update) {
			if (!validator.validate(form)) return;

			recurentPayments.update(((RecurrentPaymentFormUpdate)form).id, ((RecurrentPaymentFormUpdate)form).obj);
		}
		else if (operation == RecurrentPaymentOperation.Delete) {
			if (!validator.validate(form)) return;

			recurentPayments.delete(((RecurrentPaymentFormDelete)form).id);
		}
		else if (operation == RecurrentPaymentOperation.Insert) {
			if (!validator.validate(form)) return;

			recurentPayments.insert(((RecurrentPaymentFormUpdate)form).obj);
		}
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
