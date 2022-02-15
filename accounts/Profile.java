package accounts;
import date.Date;

public class Profile {
	private String fname;
	private String lname;
	private Date dob;
	
	public String getfName() {
		return this.fname;
	}
	
	public String getlName() {
		return this.lname;
	}
	
	public Date getDOB() {
		return this.dob;
	}
	
	public int compareTo(Profile person2) {
		if(this.fname.equals(person2.getfName())) {
			if(this.lname.equals(person2.getlName())) {
				if(this.dob.compareTo(dob) == 0) {
					return 0;
				}
			}
		}
		return -1;
	}
	
	public String toString() {
		return fname + " " + lname + ", DOB: " + dob.toString();
	}
}