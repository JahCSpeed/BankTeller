package accountType;

public class CollageChecking extends Checking{
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
}
