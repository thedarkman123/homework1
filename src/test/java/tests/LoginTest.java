package tests;

import java.util.HashMap;
import org.testng.annotations.Test;
import pageobjects.LoginPage;
import utils.DataProviders;

public class LoginTest extends BaseTest{

	//from excel 
	@Test(dataProvider="dp", dataProviderClass = DataProviders.class,priority=1)
	public void loginDataFail(HashMap <String,String> data) throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(data.get("user"),data.get("pass"));
	}
	
	//overloaded fake data method
	@Test(priority=2)
	public void loginDataFake() throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login();//overloading method that uses fake data
	}
	//success
	@Test(priority=3)
	public void lg2_loginSucced() throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login("standard_user", "secret_sauce");
	}
	
	
}
