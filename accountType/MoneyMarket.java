package accountType;

import accounts.Profile;

/**
 
 @author Jah C. Speed, Abe Vitangcol
 */
public class MoneyMarket extends Savings {
	private int withdrawCounter;
	private static final double BALANCE_THRESHOLD = 2500;
	private static final double ANNUAL_INTEREST_RATE = 0.008;
	private static final double LOYAL_ANNUAL_INTEREST_RATE = 0.0095;
	private static final int MAX_WITHDRAW_AMOUNT = 2;
	public MoneyMarket(Profile holder,double balance) {
		super(holder,balance, true);
	}
	
	@Override
	public double monthlyInterest() {
		return (this.isLoyalCustomer()?LOYAL_ANNUAL_INTEREST_RATE:ANNUAL_INTEREST_RATE) / 12;
	}

	@Override
	public double fee() {
		if(this.balance >= BALANCE_THRESHOLD && !(this.withdrawCounter >= MAX_WITHDRAW_AMOUNT)) {
			return 0;
		}else {
			return 10;
		}
	}

	@Override
	public String getType() {
		return "Money Market Savings";
	}
	
	@Override
	public void withdraw(double amount) {
		super.withdraw(amount);
		this.withdrawCounter++;
		this.checkLoyalty();
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
