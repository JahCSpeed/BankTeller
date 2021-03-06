package date;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 The DateTest class is a JUnit4 test for specifically the Date class.
 Assesses whether the isValid function is working as intended or not.
 @author Jah C. Speed, Abe Vitangcol
 */
public class DateTest {
	@Test
	public void isValid() {
		boolean not_a_date = new Date("0/00/1000").isValid();
		assertFalse(not_a_date);
		
		boolean outside_day = new Date("1/5000/2020").isValid();
		assertFalse(outside_day);
		
		boolean outside_month = new Date("13/02/2022").isValid();
		assertFalse(outside_month);
		
		boolean outside_year = new Date("1/01/10000").isValid();
		assertFalse(outside_year);
		
		boolean bad_February = new Date("2/31/2023").isValid();
		assertFalse(bad_February);
		
		boolean good_Feb = new Date("2/29/2020").isValid();
		assertTrue(good_Feb);
		
		boolean good_date1 = new Date("2/10/2015").isValid();
		assertTrue(good_date1);
	
		boolean todays_date = new Date().isValid();
		assertTrue(todays_date);
		
	}
		
}
