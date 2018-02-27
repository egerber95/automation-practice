package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class QuickNavBarPage {
	WebDriver driver;
	
	public QuickNavBarPage(WebDriver driver) {
		this.driver = driver;
	}
	
	/**
	 * Checks if there is currently a user logged in
	 * 
	 * @return true if a user is logged in, false if not
	 */
	public boolean isUserLoggedIn() {
		List<WebElement> headerInfo = driver.findElements(By.className("header_user_info"));
		if (headerInfo.size() < 2) {
			return false;
		}
		else {
			return true;
		}
	}
	
	/**
	 * Logs the current user out
	 */
	public void logout() {
		driver.findElement(By.className("logout")).click();
	}
}
