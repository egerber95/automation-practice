package tests;

import pages.BrowseProductsPage;
import pages.CheckoutPage;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class CartEditTests {
  
	WebDriver driver;
	
	/**
	 * Sets properties for driver as well as the web page
	 */
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Eric\\Desktop\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com");
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.id("header_logo")));
	}
	
	/**
	 * Adds a product to the cart and asserts that the product was added correctly
	 * Deletes the product and asserts the cart is empty
	 */
	@Test
	public void addProductToCartAndDelete() {
		BrowseProductsPage browseProductsPage = new BrowseProductsPage(driver);
		CheckoutPage checkoutPage = new CheckoutPage(driver);
		browseProductsPage.navigateToProductsPage();
		browseProductsPage.addProductToCart();
		checkoutPage.navigateToCart();
		Assert.assertTrue(checkoutPage.getNumUniqueProducts() == 1);
		checkoutPage.deleteAllItemsInCart();
		Assert.assertTrue(checkoutPage.getNumUniqueProducts() == 0);
	}
	
	/**
	 * Quits the driver once all tests are completed
	 */
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
