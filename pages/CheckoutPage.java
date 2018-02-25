package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {

	WebDriver driver;
	
	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
	}
	
	/**
	 * Navigates to the user's cart
	 */
	public void navigateToCart() {
		driver.findElement(By.className("shopping_cart")).click();
		new WebDriverWait(driver, 5).until(ExpectedConditions.textToBe(By.className("navigation_page"), "Your shopping cart"));
	}
}
