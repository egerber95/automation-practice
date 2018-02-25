package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class QuickNavBarPage {
	WebDriver driver;
	
	public QuickNavBarPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean isUserLoggedIn() {
		List<WebElement> headerInfo = driver.findElements(By.className("header_user_info"));
		if (headerInfo.size() < 2) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public void logout() {
		driver.findElement(By.className("logout")).click();
	}
}
