package tests;

import pages.LoginPage;
import pages.QuickNavBarPage;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class LoginTests {
	
	WebDriver driver;
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", "/Users/Eric/Desktop/chromedriver");
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com");
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.id("header_logo")));
	}
	
	@BeforeMethod
	public void beforeMethod() {
		LoginPage loginPage = new LoginPage(driver);
		QuickNavBarPage quickNavBarPage = new QuickNavBarPage(driver);
		
		if (quickNavBarPage.isUserLoggedIn()) {
			quickNavBarPage.logout();
		}
		if (!loginPage.isOnLoginPage()) {
			loginPage.navigateToLoginPage();
		}
	}
	
	/**
	 * Logs in with a valid username and password. 
	 * Asserts that the user was logged in successfully and is no longer on the login page.
	 */
	@Test
	public void validLogin() {
		LoginPage loginPage = new LoginPage(driver);
		QuickNavBarPage quickNavBarPage = new QuickNavBarPage(driver);
		loginPage.loginWithCredentials("fakeemail@gmail.com", "password");
		Assert.assertFalse(loginPage.isOnLoginPage());;
		Assert.assertTrue(quickNavBarPage.isUserLoggedIn());
	}
	
	@DataProvider(name="invalidCredentials")
	public static Object[][] credentials() {
		return new Object[][] {
			{"Invalid email and password", "invalidEmail", "invalidPassword"},
			{"Valid email with invalid password", "fakeemail@gmail.com", "invalidPassword"},
			{"Valid email with no password", "fakemeail@gmail.com", ""},
			{"Blank email and password", "", ""}
		};
	}
	
	/**
	 * Attempts to log in with invalid credentials.
	 * Asserts that the user remains on the login screen, and was not successfully logged in 
	 *
	 * @param the name of the scenario
	 * @param username
	 * @param password
	 */
	@Test(dataProvider="invalidCredentials")
	public void invalidLogins(String scenarioName, String username, String password) {
		LoginPage loginPage = new LoginPage(driver);
		QuickNavBarPage quickNavBarPage = new QuickNavBarPage(driver);
		loginPage.loginWithCredentials(username, password);
		Assert.assertTrue(loginPage.isOnLoginPage());
		Assert.assertFalse(quickNavBarPage.isUserLoggedIn());
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
