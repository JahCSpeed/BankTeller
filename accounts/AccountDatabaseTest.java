package accounts;
import org.junit.Test;

import accountType.Checking;
import accountType.CollegeChecking;
import accountType.MoneyMarket;
import accountType.Savings;
import date.Date;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
public class AccountDatabaseTest {
	AccountDatabase database = new AccountDatabase();
	Profile testProfile = new Profile("Jah", "Caffie-Speed", new Date("5/6/2001"));
	Profile testProfile2 = new Profile("John", "Doe", new Date("2/3/2001"));
	Checking testChecing = new Checking(testProfile, 300);
	Checking testChecing2 = new Checking(testProfile2, 300);
	CollegeChecking testCollege = new CollegeChecking(testProfile,300,0);
	Savings testSavings = new Savings(testProfile,300,true);
	MoneyMarket testMoneyMrk = new MoneyMarket(testProfile,300);
	@Test
	public void openANDclose() {
		assertFalse(database.open(null));
		assertTrue(database.open(testChecing));
		assertTrue(database.open(testCollege));
		assertTrue(database.open(testSavings));
		assertTrue(database.open(testMoneyMrk));
		assertTrue(database.close(testChecing));
		assertFalse(database.close(testChecing));
		assertFalse(database.close(testChecing2));
		assertTrue(database.close(testCollege));
		assertTrue(database.close(testSavings));
		assertTrue(database.close(testMoneyMrk));
	}
	
}
