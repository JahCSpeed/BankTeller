package accountType;
import org.junit.Test;

import accounts.Profile;
import date.Date;

import static org.junit.Assert.assertEquals;

/**
 The MoneyMarketTest class is a JUnit4 test specifically for Money Market accounts.
 Assesses whether loyal customers have the proper interest rate compared to non-loyal customers.
 @author Jah C. Speed, Abe Vitangcol
 */
public class MoneyMarketTest {
	public Profile testprofile = new Profile("Jah", "Caffie-Speed", new Date("5/6/2001"));
	public MoneyMarket testAccount =  new MoneyMarket(testprofile,2500);
	
	@Test
	public void test_loyal_account() {
		double loyal = testAccount.monthlyInterest();
		assertEquals(loyal,(0.0095 / 12),-1);
	}
	
	@Test
	public void test_not_loyal_account() {
		testAccount.withdraw(1);
		/*Balance is less then $2,500 so the account should no longer be a loyal customer */
		double not_loyal = testAccount.monthlyInterest();
		assertEquals(not_loyal,(0.008 / 12),-1);
	}
}
