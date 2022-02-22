package accounts;
import date.Date;

/**
 
 @author Jah C. Speed, Abe Vitangcol
 */
public class Profile {
	private String fname;
	private String lname;
	private Date dob;
	
	public Profile(String fname, String lname, Date dob) {
		this.fname = fname;
		this.lname = lname;
		this.dob = dob;
	}
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
		if(this.fname.toLowerCase().equals(person2.getfName().toLowerCase())) {
			if(this.lname.toLowerCase().equals(person2.getlName().toLowerCase())) {
				if(this.dob.compareTo(person2.getDOB()) == 0) {
					return 0;
				}
			}
		}
		return -1;
	}
	
	public String toString() {
		return fname + " " + lname + " " + dob.toString();
	}
}