package accountType;

import accounts.Profile;

/**
 
 @author Jah C. Speed, Abe Vitangcol
 */
public class CollegeChecking extends Checking{
	private int campusCode;
	private static final double ANNUAL_INTEREST_RATE = 0.0025;
	public CollegeChecking(Profile holder,double balance, int campusCode) {
		super(holder, balance);
		this.campusCode = campusCode;
	}
	

	@Override
	public double fee() {
		return 0;
	}
	public double monthlyInterest() {
		return ANNUAL_INTEREST_RATE / 12;
	}
	
	/**
	 Gets the type of this checking account and returns it as a string.
	 */
	@Override
	public String getType() {
		return "College Checking";
	}
	
	/**
	 Gets the campus code of this particular college checking.
	 Necessary to open a college checking
	 */
	public int getCampusCode() {
		return this.campusCode;
	}
	@Override
	public String toString() {
		return super.toString() + this.getLocation();
	}
	
	private String getLocation() {
		switch(this.campusCode) {
			case 0:
				return "::NEW_BRUNSWICK";
			case 1:
				return "::NEWARK";
			case 2:
				return "::CAMDEN";
			default:
				return "";
		}
	}
}
