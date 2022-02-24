package accountType;

import accounts.Account;
import accounts.Profile;

/**
 
 @author Jah C. Speed, Abe Vitangcol
 */
public class Checking extends Account{
	private static final double BALANCE_THRESHOLD = 1000;
	private static final double ANNUAL_INTEREST_RATE = 0.001; 
	public Checking(Profile holder,double balance) {
		this.holder = holder;
		this.closed = false;
		this.balance = balance;
	}

	public double monthlyInterest() {
		return ANNUAL_INTEREST_RATE / 12;
	}

	public double fee() {
		if(this.balance >= BALANCE_THRESHOLD) {
			return 0;
		}else {
			return 25;
		}
	}

	public String getType() {
		return "Checking";
	}
	
	public String toString() {
		return super.toString();
	}

}
