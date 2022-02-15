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
		return "Collage " + super.getType();
	}
	
	public int getCampusCode() {
		return this.campusCode;
	}
	
	public String toString(){
		switch(campusCode) {
		case 0:
			return super.toString() + "::NEW_BRUNSWICK";
		case 1:
			return super.toString() + "::NEWARK";
		case 2:
			return super.toString() + "::CAMDEN";
		default:
			return null;
		
		
		}
	}
}
