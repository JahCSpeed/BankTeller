package bankTeller;

import java.util.Scanner;

import accounts.AccountDatabase;
import accounts.Profile;

/**
 
 @author Jah C Speed, Abe Vitangcol
 */
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
	
	/**
	 Ends the BankTeller and stops taking in commands.
	 */
	private void endBankTeller() {
		System.out.println("Bank Teller is terminated.");
		this.isRunning = !this.isRunning;
	}
	
	/**
	 Performs a command that requires additional params to execute.
	 Deals with Opening, Closing, Depositing, and Withdrawing from accounts.
	 @param command
	        (more params)
	 */
	private void doNameCommand(int command) {
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
				break;
		}
	}
	
	/**
	 Performs a command, primarily printing commands, updating commands, or the stop command.
	 None of these commands require further params.
	 @param command The command typed in that wants to be executed.
	 @return 0 if the command has been done successfully or if invalid, -1 otherwise.
	 */
	private int doNoNameCommand(int command) {
		switch(command) {
			case 5:
				this.mainDatabase.print();
				return 0;
			case 6:
				this.mainDatabase.printByAccountType();
				return 0;
			case 7:
				this.mainDatabase.printFeeAndInterest();
				return 0;
			case 8:
				//UB command
			case 9:
				this.endBankTeller();
				return 0;
			case -1:
				System.out.println("Invalid command!");
				return 0;
			default:
				return -1;
		}
	}
	
	/**
	 Gets the id of the command from the string command.
	 @param input The command string inputted into the system
	 @return The proper id of the command, -1 otherwise.
	 */
	private int getCommand(String input) {
		switch(input) {
			case("O"):
				return Commands.O.id;
			case("C"):
				return Commands.C.id;
			case("D"):
				return Commands.D.id;
			case("W"):
				return Commands.W.id;
			case("P"):
				return Commands.P.id;
			case("PT"):
				return Commands.PT.id;
			case("PI"):
				return Commands.PI.id;
			case("UB"):
				return Commands.UB.id;
			case("Q"):
				return Commands.Q.id;
			default:
				break;
		}
		return -1;
	}
	
	/**
	 Checks if the person already has an account in the system.
	 @param person
	 @return
	 */
	private boolean checkProfile(Profile person) {
		
	}
	
	//private Profile createProfile(String fname, String lname, Date dob) {
		
	//}
	
	private 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
