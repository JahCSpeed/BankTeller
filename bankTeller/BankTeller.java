package bankTeller;

import java.util.Scanner;

import accounts.AccountDatabase;

public class BankTeller {
	private boolean isRunning;
	private Scanner scanInput;
	private AccountDatabase mainDatabase;
	
	/**
	 Constructs and initializes the variables to enable the BankTeller to run.
	 */
	public BankTeller() {
		this.isRunning = false;
		this.scanInput = new Scanner(System.in);
		this.mainDatabase = new AccountDatabase();
	}
	
	public void run() {
		//Runs the Bank Teller
	}
	
	private void endBankTeller() {
		System.out.println("Bank Teller is terminated.");
		this.isRunning = !this.isRunning;
	}
	
	private int doNameCommand(int command) {
		switch(command) {
			case 1:
				//O command
			case 2:
				//C command
			case 3:
				//D command
			case 4:
				//W command
			default:
				return -1;
		}
	}
	
	private int doNoNameCommand(int command) {
		switch(command) {
			case 5:
				//P command
			case 6:
				//PT command
			case 7:
				//PI command
			case 8:
				//UB command
			case 9:
				//Q command
			default:
				return -1;
		}
	}
	
	/**
	 Checks if the person already has an account in
	 @param person
	 @return
	 */
	private boolean checkProfile(Profile person) {
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
