package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowseProductsPage {
	WebDriver driver;
	
	public BrowseProductsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	/**
	 * Navigates to the browse products page
	 */
	public void navigateToProductsPage() {
		driver.findElement(By.id("block_top_menu")).findElements(By.cssSelector("li")).get(0).click();
		new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(By.id("subcategories")));
	}
	
	/**
	 * Adds a product to the cart and continues shopping after
	 */
	public void addProductToCart() {
		List<WebElement> products = driver.findElement(By.className("product_list")).findElements(By.className("ajax_block_product"));
		products.get(0).click();
		products.get(0).findElement(By.className("ajax_add_to_cart_button")).click();
		new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(By.id("layer_cart")));
		driver.findElement(By.className("continue")).click();
		new WebDriverWait(driver, 5).until(ExpectedConditions.invisibilityOfElementLocated(By.id("layer_cart")));
	}
}
