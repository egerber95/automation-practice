package tests;

import pages.BrowseProductsPage;
import pages.CheckoutPage;

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

public class CartEditTests {
  
	WebDriver driver;
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", "/Users/Eric/Desktop/chromedriver");
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com");
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.id("header_logo")));
	}
	
	/**
	 * Adds a product to the cart and asserts that the product was added correctly
	 */
	@Test
	public void addProductToCart() {
		BrowseProductsPage browseProductsPage = new BrowseProductsPage(driver);
		CheckoutPage checkoutPage = new CheckoutPage(driver);
		browseProductsPage.navigateToProductsPage();
		browseProductsPage.addProductToCart();
		checkoutPage.navigateToCart();
		// TODO add assertions
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
