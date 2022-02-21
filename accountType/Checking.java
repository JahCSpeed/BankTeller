package accountType;

import accounts.Account;
import accounts.Profile;

public class Checking extends Account{
	public Checking(Profile holder,double balance) {
		this.holder = holder;
		this.closed = false;
		this.balance = balance;
	}

	public double monthlyInterest() {
		return 0.001;
	}

	public double fee() {
		if(this.balance >= 1000) {
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
