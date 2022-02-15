package accountType;

public class MoneyMarket extends Savings {
	private int withdrawCounter;
	
	public MoneyMarket() {
		super(true);
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
		return "Monkey Market";
	}
	
	@Override
	public void withdraw(double amount) {
		if(amount < 0 || amount > this.balance) {
			this.withdrawCounter++;
		}
		super.withdraw(amount);
		
	}
	
	public void checkLoyalty() {
		if(this.getBalance()< 2500) {
			this.setLoyalCustomer(false);
		}
	}

}
