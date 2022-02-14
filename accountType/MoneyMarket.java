package accountType;

public class MoneyMarket extends Savings {
	@Override
	public double monthlyInterest() {
		return 0.008;
	}

	@Override
	public double fee() {
		if(this.balance >= 2500) {
			return 0;
		}else {
			return 10;
		}
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "Monkey Market";
	}

}
