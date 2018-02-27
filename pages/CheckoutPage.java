package pages;

import java.util.List;

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
		driver.findElement(By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a")).click();
		new WebDriverWait(driver, 5).until(ExpectedConditions.textToBe(By.className("navigation_page"), "Your shopping cart"));
	}
	
	/**
	 * Gets the number of unique products in the cart
	 */
	public int getNumUniqueProducts() {
		try {
			List<WebElement> items = driver.findElement(By.id("cart_summary")).findElements(By.className("cart_item"));
			return items.size();
		} catch (NoSuchElementException e) {
			return 0;
		}
	}
	
	/**
	 * Deletes all products currently in the cart
	 */
	public void deleteAllItemsInCart() {
		List<WebElement> items = driver.findElement(By.id("cart_summary")).findElements(By.className("cart_item"));
		for (int i=0; i<items.size(); i++) {
			WebElement item = driver.findElements(By.className("cart_item")).get(0);
			item.findElement(By.className("cart_quantity_delete")).click();
			new WebDriverWait(driver, 2).until(ExpectedConditions.invisibilityOf(item));
		}
	}
}
