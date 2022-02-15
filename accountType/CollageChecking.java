package accountType;

import accounts.Profile;

public class CollageChecking extends Checking{
	private int campusCode;
	
	
	public CollageChecking(Profile holder, boolean closed, double balance, int campusCode) {
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
	
	@Override
	public String getType() {
		return "Collage Checking";
	}
	
	public int getCampusCode() {
		return this.campusCode;
	}
}
