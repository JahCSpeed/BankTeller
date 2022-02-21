package accounts;

import java.text.DecimalFormat;

import accountType.Checking;
import accountType.CollegeChecking;

public abstract class Account {
	protected Profile holder;
	protected boolean closed;
	protected double balance;
	
	/**
	 Checks if this account is the same as another account.
	 @param obj The object of interest to check if this account is the same as it.
	 @return true if the two are the same, false otherwise.
	 */
	@Override
	public boolean equals(Object obj) {
		Account compareAccount = (Account)obj;
		if(this.holder.compareTo(compareAccount.holder) == 0) {
			if(this.getType().equals(((Account)obj).getType())) {
				return true;
			}
			
		}
		return false; 
		
	}
	
	/**
	 Turns this account into a readable string.
	 Format: "Type :: Holder :: $Balance"
	 @return This account tyoe in a readable string format.
	 */
	@Override
	public String toString() { 
		DecimalFormat numberFormat = new DecimalFormat("#,##0.00");
		return getType() + "::" + holder.toString() + "::Balance $" + numberFormat.format(getBalance()) + (!this.closed? "":"::CLOSED");
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
	
	/**
	 Gets the Balance of this account.
	 @return The balance of this account in a double format.
	 */
	public double getBalance() {
		return this.balance;
	}
	/**
	 Gets the Holder of this account.
	 @return The holder of this account in a Profile format.
	 */
	public Profile getHolder() {
		return this.holder;
	}
	
	public boolean isClosed() {
		return this.closed;
	}
	
	public abstract double monthlyInterest(); //return the monthly interest
	public abstract double fee(); //return the monthly fee
	public abstract String getType(); //return the account type (class name)
}