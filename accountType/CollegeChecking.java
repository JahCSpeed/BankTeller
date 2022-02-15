package accountType;

import accounts.Profile;

public class CollegeChecking extends Checking{
	private int campusCode;
	
	public CollegeChecking(Profile holder, boolean closed, double balance, int campusCode) {
		super(holder, closed, balance);
		this.campusCode = campusCode;
	}

	@Override
	public double fee() {
		return 0;
	}
	public double monthlyInterest() {
		return 0.0025;
	}
	
	/**
	 Gets the type of this checking account and returns it as a string.
	 */
	@Override
	public String getType() {
		return "Collage Checking";
	}
	
	/**
	 Gets the campus code of this particular college checking.
	 Necessary to open a college checking
	 */
	public int getCampusCode() {
		return this.campusCode;
	}
}
