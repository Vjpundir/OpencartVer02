package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage{

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);

	}

	//############## WebElements ##################################

	@FindBy(xpath="//h1[text()='Register Account']")
	WebElement registrationPageTitle;

	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement userFirstName;

	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement userLastName;

	@FindBy(xpath="//input[@id='input-email']")
	WebElement userEmailId;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement userTelephone;

	@FindBy(xpath="//input[@id='input-password']")
	WebElement userPassword;

	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement confirmPassword;

	@FindBy(xpath="//div[@class='radio']//input[@type='radio']")
	WebElement newsRadioBtn;

	@FindBy(xpath="//input[@name='agree']")
	WebElement policyCheckBox;

	@FindBy(xpath="//input[@value='Continue']")
	WebElement continueBtn;

	@FindBy(xpath="//h1[text()='Your Account Has Been Created!']")
	WebElement successMessage;

	//############### Actions ############################

	public void enterUserFname(String fname)
	{ 
		userFirstName.sendKeys(fname);

	}

	public void enteruserLname(String lname)
	{
		userLastName.sendKeys(lname);

	}

	public void enterEmailId(String emailId)
	{
		userEmailId.sendKeys(emailId);
	}
	
	public void enterTelephone(String tele)
	{
		userTelephone.sendKeys(tele);
	}

	public void enterPassword(String pwd)
	{
		userPassword.sendKeys(pwd);

	}

	public void confirmPassword(String confirmpwd)
	{
		confirmPassword.sendKeys(confirmpwd);
	}

	public void clickNewLetterRadioBtn() {
		newsRadioBtn.click();
	}

	public void setPolicyPrivacy()
	{
		policyCheckBox.click();
	}

	public void clickContinueBtn() 
	{
		continueBtn.click();
	}

	public String getConfirmMessage()
	{
		try {
			return (successMessage.getText());	

		}catch(Exception e)
		{
			return(e.getMessage());
		}

	}
}
