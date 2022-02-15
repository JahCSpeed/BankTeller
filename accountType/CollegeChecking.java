package accountType;

<<<<<<< HEAD:accountType/CollegeChecking.java
public class CollegeChecking extends Checking{
=======
public class CollageChecking extends Checking{
	private int campusCode;
	
	public void CollageCehcking(int campusCode){
		this.campusCode = campusCode;
	}
>>>>>>> ec3ea4db2c5d8e36aed607a13e7c2000f0cc9d76:accountType/CollageChecking.java
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
