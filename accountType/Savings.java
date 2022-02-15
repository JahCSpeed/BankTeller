package accountType;

import accounts.Account;

public class Savings extends Account {
	
	private boolean loyalCustomer;
	
	public Savings(boolean loyalCustomer) {
		this.loyalCustomer = loyalCustomer;
	}
	@Override
	public double monthlyInterest() {
		return (this.loyalCustomer?0.0045:0.003);
	}

	@Override
	public double fee() {
		if(this.balance >= 300) {
			return 0;
		}else {
			return 6;
		}
	}

	@Override
	public String getType() {
		return "Savings";
	}
	
	public boolean isLoyalCustomer() {
		return this.loyalCustomer;
	}
	public void setLoyalCustomer(boolean value) {
		this.loyalCustomer = value;
	}

}
