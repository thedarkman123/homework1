package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseTest {
	WebDriver driver;
	
	@Parameters("browser")
	@BeforeClass
	protected void setup(String browser) { 
		if (browser.equals("chrome")) {
			ChromeOptions cOptions = new ChromeOptions();
			cOptions.addArguments("disable-infobars");
			driver = new ChromeDriver(cOptions);
		} else if (browser.equals("firefox")) {
			driver = new FirefoxDriver();
		}		
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
	}
	
	@AfterClass
	protected void tearDown() {
		driver.quit();
	}
}
