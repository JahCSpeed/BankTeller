package accountType;

import accounts.Profile;

public class MoneyMarket extends Savings {
	private int withdrawCounter;
	
	public MoneyMarket(Profile holder,double balance) {
		super(holder,balance, true);
	}
	
	@Override
	public double monthlyInterest() {
		return (this.isLoyalCustomer()?0.0095:0.008);
	}

	@Override
	public double fee() {
		if(this.balance >= 2500 && !(this.withdrawCounter >= 2)) {
			return 0;
		}else {
			return 10;
		}
	}

	@Override
	public String getType() {
		return "Money Market";
	}
	
	@Override
	public void withdraw(double amount) {
		super.withdraw(amount);
		this.withdrawCounter++;
	}
	
	public void checkLoyalty() {
		if(this.getBalance()< 2500) {
			this.setLoyalCustomer(false);
		}
	}
	
	public String toString() {
		return super.toString() + "::withdrawl: " + this.withdrawCounter;
	}

}
