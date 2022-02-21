package accounts;

import java.text.DecimalFormat;

import accountType.Checking;
import accountType.CollegeChecking;
import accountType.MoneyMarket;
import accountType.Savings;

public class AccountDatabase {
	private Account [] accounts;
	private int numAcct;
	private final int INCREASESIZE = 4;
	
	
	public AccountDatabase() {
		this.numAcct = 0;
		this.accounts = new Account[numAcct];
	}
	/**
	 Finds a specific account in this array of accounts and returns the index.
	 @param account The specific account to be found.
	 @return The index of the account found, -1 otherwise.
	 */
	private int find(Account account) { //return the index, or NOT_FOUND
		for(int i = 0; i < this.numAcct; i++) {
			if(this.accounts[i].equals(account)) {
				return i;
			}
		}
		return -1;
	}
	public Account getAccount(Account account) { //return the index, or NOT_FOUND
		for(int i = 0; i < this.numAcct; i++) {
			//System.out.println("Person 1: " + this.accounts[i].toString() + " \tPerson 2: " + account.toString());
			if(this.accounts[i].equals(account)) {
				return this.accounts[i];
			}
			
		}
		return null;
	}
	
	public int checkDupChecking(Account account) {
		for(int i = 0; i < this.numAcct; i++) {
			if(this.accounts[i].equals(account)) {
				return i;
			}
			if(this.accounts[i].getHolder().compareTo(account.getHolder()) == 0) {
				if(this.accounts[i] instanceof Checking && account instanceof CollegeChecking) {
					return i;
				}
				if(this.accounts[i] instanceof CollegeChecking && account instanceof Checking) {
					return i;
				}
				
			}
			
			
		}
		return -1;
	}
	/**
	 Grows the capacity of the accounts array by 4.
	 Helpful especially when the old array is out of space.
	 */
	private void grow() {
		Account [] prevList = this.accounts;
		this.accounts = new Account[this.numAcct + INCREASESIZE];
		for(int i = 0; i < prevList.length; i++) {
			this.accounts[i] = prevList[i];
		}
	}
	/**
	 Adds an account into the array if there is room, and grows the array if there is no room.
	 @param account The specific account to be added to this array.
	 @return true if this operation was successful.
	 */
	public boolean open(Account account) {
		if(this.numAcct == this.accounts.length) {
			this.grow();
		}
		if(account == null) {
			return false;
		}
		this.accounts[this.numAcct++] = account;
		return true;
	}
	
	/**
	 Closes a specific account, making it unable to be used.
	 @param account The specific account to be closed.
	 @return True if this action was successful.
	 */
	public boolean close(Account account) {
		int index = this.find(account);
		if(index == -1) {
			return false;
		}
		if(this.accounts[index].closed) {
			return false;
		}
		if(this.accounts[index] instanceof Savings || this.accounts[index] instanceof MoneyMarket) {
			((Savings)this.accounts[index]).setLoyalCustomer(false);
		}
		this.accounts[index].balance = 0;
		return (this.accounts[index].closed = true);
	}
	public boolean reopen(Account account) {
		
		int index = this.find(account);
		if(index == -1) {
			return false;
		}
		this.accounts[index].closed = false;
		this.accounts[index].balance = account.getBalance();
		if(account instanceof Savings || account instanceof MoneyMarket) {
			((Savings)this.accounts[index]).setLoyalCustomer(((Savings)account).isLoyalCustomer());
		}
		return true;
	}
	
	public void deposit(Account account) { 
		int index = this.find(account);
		if(index == -1) {
			return;
		}
		if(this.accounts[index].isClosed()) {
			return;
		}
		this.accounts[index].deposit(account.balance);
	}
	
	//return false if insufficient fund
	public boolean withdraw(Account account) {
		int index = this.find(account);
		if(index == -1) {
			return false;
		}
		if(this.accounts[index].isClosed()) {
			return false;
		}
		double bal = this.accounts[index].balance;
		if(bal < account.balance) {
			return false;
		}
		this.accounts[index].withdraw(account.balance);
		return true;
	} 
	
	/**
	 Prints the accounts in the database in the current order.
	 */
	public void print() {
		if(this.numAcct == 0) {
			System.out.println("Account Database is empty!");
			return;
		}

		System.out.println("\n*list of accounts in the database*");
		for(int i = 0; i < this.numAcct; i++) {
			System.out.println(this.accounts[i].toString());
		}
		System.out.println("*end of list*" + "\n");
	}
	
	/**
	 Prints the accounts in this database sorted by their account type.
	 */
	public void printByAccountType() {
		
		if(this.numAcct == 0) {
			System.out.println("Account Database is empty!");
			return;
		}
		System.out.println("\n*list of accounts by account type.");
		for(int i = 0; i < this.numAcct; i++) {
			if(this.accounts[i].getType().equals("Checking")) {
				System.out.println(this.accounts[i].toString());
			}
		}
		for(int i = 0; i < this.numAcct; i++) {
			if(this.accounts[i].getType().equals("College Checking")) {
				System.out.println(this.accounts[i].toString());
			}		
		}
		
		for(int i = 0; i < this.numAcct; i++) {
			if(this.accounts[i].getType().equals("Money Market Savings")) {
				System.out.println(this.accounts[i].toString());
			}
		}
		
		for(int i = 0; i < this.numAcct; i++) {
			if(this.accounts[i].getType().equals("Savings")) {
				System.out.println(this.accounts[i].toString());
			}		
		}
		System.out.println("*end of list." + "\n");
		
	}
	
	public void printFeeAndInterest() { 
		if(this.numAcct == 0) {
			System.out.println("Account Database is empty!");
			return;
		}
		System.out.println("\n*list of accounts with fee and monthly interest");
		DecimalFormat numberFormat = new DecimalFormat("#,##0.00");
		double fee;
		double montlyInterst;
		for(int i = 0; i < this.numAcct; i++) {
			fee = this.accounts[i].fee();
			montlyInterst = ( (this.accounts[i].getBalance() * (this.accounts[i].monthlyInterest())));
			System.out.println(this.accounts[i].toString() + "::fee $" + numberFormat.format(fee) + "::monthly interest $" + numberFormat.format(montlyInterst));
		}
	}
	
	public void updateDatabase() {
		if(this.numAcct == 0) {
			System.out.println("Account Database is empty!");
			return;
		}
		System.out.println("\n*list of accounts with updated balance");
		double fee;
		double montlyInterst;
		for(int i = 0; i < this.numAcct; i++) {
			fee = this.accounts[i].fee();
			montlyInterst = ( (this.accounts[i].getBalance() * (this.accounts[i].monthlyInterest())));
			this.accounts[i].balance+=montlyInterst;
			this.accounts[i].balance-=fee;
			System.out.println(this.accounts[i].toString());
		}
	}
}