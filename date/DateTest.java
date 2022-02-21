package date;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class DateTest {
	@Test
	public void isValid() {
		boolean not_a_date = new Date("0/00/1000").isValid();
		assertEquals(not_a_date, false);
		
		boolean outside_day = new Date("1/5000/2020").isValid();
		assertEquals(outside_day, false);
		
		boolean outside_month = new Date("13/02/2022").isValid();
		assertEquals(outside_month, false);
		
		boolean outside_year = new Date("1/01/10000").isValid();
		assertEquals(outside_year, false);
		
		boolean bad_February = new Date("2/31/2023").isValid();
		assertEquals(bad_February, false);
		
		boolean good_Feb = new Date("2/29/2020").isValid();
		assertEquals(good_Feb, true);
		
		boolean good_date1 = new Date("2/10/2015").isValid();
		assertEquals(good_date1, true);
		
	}
		
}
