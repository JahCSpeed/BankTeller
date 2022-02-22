package accountType;
import org.junit.Test;

import accounts.Profile;
import date.Date;

import static org.junit.Assert.assertEquals;
public class MoneyMarketTest {
	@Test
	public void monthlyInterest() {
		Profile testprofile = new Profile("Jah", "Caffie-Speed", new Date("5/6/2001"));
		MoneyMarket testAccount =  new MoneyMarket(testprofile,2500);
		double loyal = testAccount.monthlyInterest();
		assertEquals(loyal,(0.0095 / 12),-1);
		
		testAccount.withdraw(1);
		/*Balance is less then $2,500 so the account should no longer be a loyal customer */
		
		double not_loyal = testAccount.monthlyInterest();
		assertEquals(not_loyal,(0.008 / 12),-1);
		
	}
}
