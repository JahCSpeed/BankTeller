package accounts;


public class AccountDatabase {
	private Account [] accounts;
	private int numAcct;
	private final int INCREASESIZE = 4;
	
	
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
		this.accounts[this.numAcct++] = account;
		return true;
	}
	
	public boolean close(Account account) {
		int index = this.find(account);
		this.accounts[index].closed = true;
		return true;
	}
	
	public void deposit(Account account, double amount) { 
		int index = this.find(account);
		this.accounts[index].deposit(amount);
	}
	
	//return false if insufficient fund
	public boolean withdraw(Account account, double amount) {
		int index = this.find(account);
		Account acct = this.accounts[index];
		if(amount < 0 || amount > acct.balance) {
			return false;
		}
		acct.withdraw(amount);
		return true;
	} 
	
	public void print() {
		if(this.numAcct == 0) {
			System.out.println("Account Database is empty!");
			return;
		}

		System.out.println("\n" + "*list of accounts in the database*");
		for(int i = 0; i < this.numAcct; i++) {
			System.out.println(this.accounts[i].toString());
		}
		System.out.println("*end of list*" + "\n");
	}
	
	public void printByAccountType() {
		if(this.numAcct == 0) {
			System.out.println("Account Database is empty!");
			return;
		}
		
	}
	
	public void printFeeAndInterest() { 
		if(this.numAcct == 0) {
			System.out.println("Account Database is empty!");
			return;
		}
		
	}
}