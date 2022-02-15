package accounts;

public class AccountDatabase {
	private Account [] accounts;
	private int numAcct;
	
	private int find(Account account) {
		return 0; 
		
	}
	
	private void grow() { 
		
	}
	
	public boolean open(Account account) { 
		return true;
	}
	
	public boolean close(Account account) { 
		return true;
	}
	
	public void deposit(Account account) { 
		
	}
	
	//return false if insufficient fund
	public boolean withdraw(Account account) { 
		return true;
	} 
	
	public void print() {
		
	}
	
	public void printByAccountType() {
		
	}
	
	public void printFeeAndInterest() { 
		
	}
}