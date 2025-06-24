package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginIntoApplication extends BaseClass{
	
	@Test(groups={"Sanity","Regression","Master"})
	
	public void verify_loginAccount()
	
	{
		try {
		HomePage hp= new HomePage(driver);
		logger.info("***** Starting TC_002_LoginIntoApplication  ...........");
		hp.clickMyAccount();
		hp.clickLoginLink();
		
		logger.info("***** Enter the email and password on login page ........");
		
		LoginPage lp = new LoginPage(driver);
		lp.setEmailId(p.getProperty("Email"));
		lp.setPassword(p.getProperty("Password"));
		lp.clickLoginBtn();
		
		logger.info("***** User directed to My Account Page ........");
		MyAccountPage macc = new MyAccountPage(driver);
		boolean status = macc.isMyAccountPageExists();
		
		Assert.assertEquals(status, true);
		}
		catch(Exception e)
		{
			Assert.fail();
		}
	logger.info("***** Finished TC_002_LoginIntoApplication ********");
	}

}
