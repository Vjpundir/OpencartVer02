package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDDT extends BaseClass
{
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class,groups="DDT")
	public void verify_LoginDDT(String email, String pwd , String expected) throws InterruptedException
	{
		
		try {
		HomePage hp= new HomePage(driver);
		logger.info("******* Starting TC_003_LoginDDT ***************");
		hp.clickMyAccount();
		hp.clickLoginLink();
		
		logger.info("***** Enter the email and password on login page...........");
		
		LoginPage lp = new LoginPage(driver);
		lp.setEmailId(email);
		lp.setPassword(pwd);
		lp.clickLoginBtn();
		
		MyAccountPage mac= new MyAccountPage(driver);
		boolean targetPage=mac.isMyAccountPageExists();
		
		if(expected.equalsIgnoreCase("valid"))
		{
			if(targetPage==true)
			{
			mac.clickLogoutOptions();
			Assert.assertTrue(true);	
		     }
		else
		{
			Assert.assertTrue(false);
		 }
	}
		
	if(expected.equalsIgnoreCase("invalid"))
	{
		if(targetPage==true)
		{
			   mac.clickLogoutOptions();
			   Assert.assertTrue(false);
	    }
		
		else
		{
			Assert.assertTrue(true);	
		}
	   }
	
		}
	     catch(Exception e)
		{
	    	 Assert.fail();
		}
		Thread.sleep(3000);
		logger.info("******** Finished TC_003_LoginDDT ************");
		
   }
}

