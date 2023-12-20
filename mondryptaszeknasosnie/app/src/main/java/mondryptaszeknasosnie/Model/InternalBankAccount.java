package Model;

public class InternalBankAccount implements Account {

	public float balance;
	public bool autoCurrencyDenomination;
	public int id;
	public AccountNumber address;

	public float getBalance() {
		return this.balance;
	}

	public AccountNumber getAddress() {
		return this.address;
	}

	public Currency currency() {
		// TODO - implement InternalBankAccount.currency
		throw new UnsupportedOperationException();
	}

	public Payment[] transfers() {
		// TODO - implement InternalBankAccount.transfers
		throw new UnsupportedOperationException();
	}

	public RecurrentPayment[] recurringTransfers() {
		// TODO - implement InternalBankAccount.recurringTransfers
		throw new UnsupportedOperationException();
	}

	public bool getAutoCurrencyDenomination() {
		return this.autoCurrencyDenomination;
	}

	/**
	 * 
	 * @param autoCurrencyDenomination
	 */
	public void setAutoCurrencyDenomination(bool autoCurrencyDenomination) {
		this.autoCurrencyDenomination = autoCurrencyDenomination;
	}

}