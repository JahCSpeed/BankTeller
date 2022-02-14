package accountType;

import accounts.Account;

public class Savings extends Account {

	@Override
	public double monthlyInterest() {
		return 0.003;
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
		// TODO Auto-generated method stub
		return "Savings";
	}

}
