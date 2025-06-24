package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver) {
		super(driver);
		
	}
	
	//##############WebElement ###############################
	
	@FindBy(xpath="//h2[text()='My Account']")
	WebElement myAccountHeader;
	
	@FindBy(xpath="//div[@class='list-group']//a[text()='Logout']")
	WebElement logoutOptions;
	
	//##################### Actions ############################
	
	public boolean isMyAccountPageExists()
	{ 
		try 
		{	
		    return(myAccountHeader.isDisplayed());
		}
		catch(Exception e)
		{
			return false;
		}	
	}
	public void clickLogoutOptions()
	{
		logoutOptions.click();
	}

}
