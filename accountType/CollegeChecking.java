package accountType;


public class CollegeChecking extends Checking{

	private int campusCode;
	
	public void CollegeChecking(int campusCode){
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
