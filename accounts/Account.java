package accounts;
public abstract class Account {
	protected Profile holder;
	protected boolean closed;
	protected double balance;
	
	@Override
	public boolean equals(Object obj) {
		Account compareAccount = (Account)obj;
		if(this.holder.compareTo(compareAccount.holder) == 0) {
			if(this.closed == compareAccount.closed) {
				if(this.balance == compareAccount.balance) {
					return true;
				}
			}
		}
		return false; 
		
	}
	
	
	@Override
	public String toString() { 
		return "";
	}
	public void withdraw(double amount) {
		if(amount < 0 || amount > this.balance) {
			return;
		}
		this.balance-= amount;
		
	}
	public void deposit(double amount) { 
		if(amount < 0) {
			return;
		}
		this.balance+= amount;
	}
	public abstract double monthlyInterest(); //return the monthly interest
	public abstract double fee(); //return the monthly fee
	public abstract String getType(); //return the account type (class name)
}