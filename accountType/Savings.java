package accountType;

import accounts.Account;
import accounts.Profile;

/**
 
 @author Jah C. Speed, Abe Vitangcol
 */
public class Savings extends Account {
	
	private boolean loyalCustomer;
	private static final double BALANCE_THRESHOLD = 300;
	private static final double ANNUAL_INTEREST_RATE = 0.003;
	private static final double LOYAL_ANNUAL_INTEREST_RATE = 0.0045;
	public Savings(Profile holder,double balance,boolean loyalCustomer) {
		this.holder = holder;
		this.closed = false;
		this.balance = balance;
		this.loyalCustomer = loyalCustomer;
	}
	
	@Override
	public double monthlyInterest() {
		return (this.loyalCustomer?LOYAL_ANNUAL_INTEREST_RATE:ANNUAL_INTEREST_RATE) / 12;
	}

	@Override
	public double fee() {
		if(this.balance >= BALANCE_THRESHOLD) {
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
	public String toString() {
		return super.toString() + (this.isLoyalCustomer()? "::Loyal":"");
	}
	

}
