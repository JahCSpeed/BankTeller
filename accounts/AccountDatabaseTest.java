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
	public AccountDatabase database = new AccountDatabase();
	public Profile testProfile = new Profile("Jah", "Caffie-Speed", new Date("5/6/2001"));
	public Profile testProfile2 = new Profile("John", "Doe", new Date("2/3/2001"));
	public Checking testChecing = new Checking(testProfile, 300);
	public Checking testChecing2 = new Checking(testProfile2, 300);
	public CollegeChecking testCollege = new CollegeChecking(testProfile,300,0);
	public Savings testSavings = new Savings(testProfile,300,true);
	public MoneyMarket testMoneyMrk = new MoneyMarket(testProfile,300);
	@Test
	public void open_accounts() {
		assertTrue(database.open(testChecing));
		assertTrue(database.open(testCollege));
		assertTrue(database.open(testSavings));
		assertTrue(database.open(testMoneyMrk));
	}
	@Test
	public void close_accounts() {
		assertTrue(database.close(testChecing));
		assertTrue(database.close(testCollege));
		assertTrue(database.close(testSavings));
		assertTrue(database.close(testMoneyMrk));
	}
	@Test
	public void close_null_account() {
		assertFalse(database.close(null));

	}
	@Test
	public void open_null_account() {
		assertFalse(database.open(null));
	}
	@Test
	public void close_account_twice() {
		assertFalse(database.close(testChecing));
	}
	@Test
	public void close_account_not_in_database() {
		assertFalse(database.close(testChecing2));
	}
	
	
}
