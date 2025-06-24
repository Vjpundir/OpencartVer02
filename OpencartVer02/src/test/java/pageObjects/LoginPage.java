package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
		
	}

//	############ WebElements#######################
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement userEmailId;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement userPassword;
	
	@FindBy(xpath="//input[@class='btn btn-primary']")
	WebElement loginButton;
	
	// ############## Action ###################
	
	public void setEmailId(String email) 
	{
		userEmailId.sendKeys(email);
		
	}
	
	public void setPassword(String pwd)
	{
		userPassword.sendKeys(pwd);
	}
	
	public void clickLoginBtn()
	{
		loginButton.click();
	}
}

