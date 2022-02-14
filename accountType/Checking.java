package accountType;

import accounts.Account;

public class Checking extends Account{

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

}
