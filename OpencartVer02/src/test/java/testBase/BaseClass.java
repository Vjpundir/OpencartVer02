package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.apache.logging.log4j.LogManager; // Log4j
import org.apache.logging.log4j.Logger; // Log4j

public class BaseClass {
	
public Properties p;
	
public static WebDriver driver;
public Logger logger;
	
	@BeforeClass (groups="Master")
	@Parameters({"os","broswer"})
	public void setUp(String os, String br) throws IOException {
		
	FileReader file = new FileReader (System.getProperty("user.dir")+ "\\src\\test\\resources\\config.properties");
	p = new Properties();
	p.load(file);
	
	logger = LogManager.getLogger(this.getClass());
	ChromeOptions options = new ChromeOptions();
	EdgeOptions optionss = new EdgeOptions();
	FirefoxOptions optionsss = new FirefoxOptions();
    options.addArguments("--incognito");
    
		switch(br)
		{
		case "chrome": driver = new ChromeDriver(options);break;
		case "edge": driver = new EdgeDriver(optionss);break;
		case "firefox": driver = new FirefoxDriver(optionsss);break;
		default : System.out.println("browser is invalid"); return;
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("AppUrl1"));
		driver.manage().window().maximize();
	}

	@AfterClass (groups="Master")
	public void tearDown()
	{
		driver.quit();
	}
	
	public String randomString()
	{
		String generatedString=RandomStringUtils.randomAlphabetic(5);
		return generatedString;
		
	}
	
	public String randomNumber()
	{
		String generatedNumber = RandomStringUtils.randomNumeric(10);
		return generatedNumber;
	}
	
	public String randomAlphaNumeric()
	{
		String generatedString=RandomStringUtils.randomAlphabetic(5);
		String generatedNumber = RandomStringUtils.randomNumeric(10);
		return (generatedString + "@" + generatedNumber);
	}

	
	public String captureScreen(String tname) throws IOException
	{
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File sourceFile = ts.getScreenshotAs(OutputType.FILE);
		
//		String targetFilePath = System.getProperty("user.dir")+ "\\screenshots" + tname + "_" + timeStamp + ".png";
		String targetFilePath = System.getProperty("user.dir") + File.separator + "screenshots" + File.separator + tname + "_" + timeStamp + ".png";

		 
		File targetFile = new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
		
		return targetFilePath;
		
	}
}
