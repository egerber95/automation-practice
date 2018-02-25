package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	/**
	 * Checks if the user is currently on the login page
	 * 
	 * @return true if on login page, false if not
	 */
	public boolean isOnLoginPage() {
		try {
			return driver.findElement(By.className("navigation_page")).getText().contains("Authentication");
		} catch (NoSuchElementException e) {
			return false;
		}
	}
	
	/**
	 * Navigates to the login page
	 */
	public void navigateToLoginPage() {
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.className("login"))).click();
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.id("login_form")));
	}
	
	/**
	 * Logs in on the login page 
	 *
	 * @param username
	 * @param password
	 */
	public void loginWithCredentials(String username, String password) {
		if (username == null) {
			throw new NullPointerException("Passed parameter username cannot be null");
		}
		if (password == null) {
			throw new NullPointerException("Passed parameter password cannot be null");
		}
		
		WebElement loginForm = driver.findElement(By.id("center_column")).findElements(By.className("col-xs-12")).get(1);
		WebElement usernameForm = loginForm.findElements(By.className("account_input")).get(0);
		WebElement passwordForm = loginForm.findElements(By.className("account_input")).get(1);
		
		usernameForm.clear();
		passwordForm.clear();
		usernameForm.sendKeys(username);
		passwordForm.sendKeys(password);
		
		driver.findElement(By.id("SubmitLogin")).click();
	}
}
