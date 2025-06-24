package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountregistrationTest extends BaseClass{
	
	@Test(groups={"Sanity","Master"})
	public void account_Verification() throws InterruptedException
	{
		logger.info("******* Starting TC001_Accountregistration Test ********");
		
		try {
		HomePage hp = new HomePage(driver);
		Thread.sleep(4000);
		
		logger.info("User click on My Account link...........");
		hp.clickMyAccount();
		
		logger.info("User click on Register Link.............");
		hp.clickRegisterLink();
		
		AccountRegistrationPage arp= new AccountRegistrationPage(driver);
		
		logger.info("Providing the customer details..........");
		
		arp.enterUserFname(randomString().toUpperCase());
		arp.enteruserLname(randomString().toUpperCase());
		arp.enterEmailId(randomString()+ "@gmail.com");
		arp.enterTelephone(randomNumber());
		String password = randomAlphaNumeric();
		arp.enterPassword(password);
		arp.confirmPassword(password);
		
		Thread.sleep(3000);
		
		arp.setPolicyPrivacy();
		
		arp.clickContinueBtn();
		
		logger.info("Validating expected message.........");
		
		String confirmMessage=arp.getConfirmMessage();
		System.out.print("Actual message is :" + confirmMessage);
		
		if(confirmMessage.equals("Your Account Has Been Created!"))
			{
			Assert.assertTrue(true);	
		    }
		else 
		{
			logger.error("test failed.....");
			logger.debug("debug logs....");
			Assert.assertFalse(false);
			
		}
	}
		catch(Exception e)
		{
			
		   Assert.fail();
		}
		logger.info("***** Finished TC001_AccountregistrationTest **********");
	
	}	
}
