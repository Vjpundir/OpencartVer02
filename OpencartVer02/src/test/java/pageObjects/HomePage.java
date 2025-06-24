package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver) {
		super(driver);
		
	}
	
//########### WebElements ########################

@FindBy(xpath="//span[text()='My Account']")
WebElement myAccount;

@FindBy(xpath="//a[text()='Register']")
WebElement registerLink;

@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[text()='Login']")
WebElement loginLink;


//############### Actions ############################

public void clickMyAccount()
{
	myAccount.click();
}

public void clickRegisterLink()
{
	registerLink.click();
}

public void clickLoginLink()
{
	loginLink.click();
}
	

}
