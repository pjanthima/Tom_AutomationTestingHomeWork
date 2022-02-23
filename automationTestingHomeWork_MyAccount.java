package HomeWork;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class automationTestingHomeWork_MyAccount {
	WebDriver driver;
	private String url = "http://practice.automationtesting.in/";

	@Before
	public void beforeMethod() {
		WebDriverManager.chromedriver().setup();
//		1) Open the browser
		driver = new ChromeDriver();
//		2) Enter the URL “http://practice.automationtesting.in/”
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	
	@Test
	public void dashBoard1() {
//		3) Click on My Account Menu
		myAccountMenu();
//		4) Enter registered username in username textbox
		enterValidUsername();
//		5) Enter password in password textbox
		enterValidPassword();
//		6) Click on login button
		clickLogin();
//		7) User must successfully login to the web page
		loginPageNavigateCheck();
//		8) Click on Myaccount link which leads to Dashboard
		myAccountMenu();
//		9) User must view Dashboard of the site
		WebElement loginPageNavigate = driver
				.findElement(By.xpath("//nav[@class='woocommerce-MyAccount-navigation']/ul/li[1]/a"));
		Assert.assertTrue(loginPageNavigate.isDisplayed());
		System.out.println("TEST PASSED : " + loginPageNavigate.getText());
	}

	@Ignore
	@Test
	public void orderViewByLink2() {
//		3) Click on My Account Menu
		myAccountMenu();
//		4) Enter registered username in username textbox
		enterValidUsername();
//		5) Enter password in password textbox
		enterValidPassword();
//		6) Click on login button
		clickLogin();
//		7) User must successfully login to the web page
		loginPageNavigateCheck();
//		8) Click on Myaccount link
		myAccountMenu();
//		9) Click on Orders link
		orderLink();
//		10) User must view their orders on clicking orders link
		WebElement orderView = driver.findElement(By.xpath("//div[@class='woocommerce-MyAccount-content']/table"));
		Assert.assertTrue(orderView.isDisplayed());
		System.out.println("\nORDER VIEW SHOW UP : TEST PASSED  \n" + orderView.getText());
		// driver.findElement(By.xpath("//td[@class='order-number']/a")).click();
	}

	@Ignore
	@Test
	public void orderViewByButton3() {
//		3) Click on My Account Menu
		myAccountMenu();
//		4) Enter registered username in username textbox
		enterValidUsername();
//		5) Enter password in password textbox
		enterValidPassword();
//		6) Click on login button
		clickLogin();
//		7) User must successfully login to the web page
		loginPageNavigateCheck();
//		8) Click on Myaccount link
		myAccountMenu();
//		9) Click on Orders link
		orderLink();
//		10) Click view button
		driver.findElement(By.xpath("//td[@class='order-actions']/a")).click();
//		11) User must view his Order details,customer details and billing details on clicking view button
		WebElement orderDetails = driver.findElement(By.xpath("//div[@class='woocommerce-MyAccount-content']"));
		Assert.assertTrue(orderDetails.isDisplayed());
		System.out.println("\nORDER VIEW SHOW UP PASSED : \n" + orderDetails.getText());
	}

	@Ignore
	@Test
	public void addressFunctionality5() {
//		3) Click on My Account Menu
		myAccountMenu();
//		4) Enter registered username in username textbox
		enterValidUsername();
//		5) Enter password in password textbox
		enterValidPassword();
//		6) Click on login button
		clickLogin();
//		7) User must successfully login to the web page
		loginPageNavigateCheck();
//		8) Click on Myaccount link which leads to Dashboard
		myAccountMenu();
//		9) Click on Address link
		addressLink();
//		10) User must view billing address and ship address
		WebElement billingDetails = driver
				.findElement(By.xpath("//div[@class='u-columns woocommerce-Addresses col2-set addresses']"));
		Assert.assertTrue(billingDetails.isDisplayed());
		System.out.println("\nORDER BILLING DETAILS HOSW UP, PASSED : \n" + billingDetails.getText());
	}

	@Ignore
	@Test
	public void editAddressFunctionality6() throws InterruptedException {
//		3) Click on My Account Menu
		myAccountMenu();
//		4) Enter registered username in username textbox
		enterValidUsername();
//		5) Enter password in password textbox
		enterValidPassword();
//		6) Click on login button
		clickLogin();
//		7) User must successfully login to the web page
		loginPageNavigateCheck();
//		8) Click on Myaccount link
		myAccountMenu();
//		9) Click on Address link
		addressLink();
//		10) Click Edit on Shipping Address
		driver.findElement(By.xpath("//div[@class='u-column2 col-2 woocommerce-Address']/header/a")).click();
//		11) User can Edit Shipping address
		driver.findElement(By.id("shipping_first_name")).clear();
		driver.findElement(By.id("shipping_first_name")).sendKeys("Michael");
		driver.findElement(By.id("shipping_last_name")).clear();
		driver.findElement(By.id("shipping_last_name")).sendKeys("Jackson");
		driver.findElement(By.id("shipping_company")).clear();
		driver.findElement(By.id("shipping_company")).sendKeys("Warner Records");
		driver.findElement(By.xpath("//div[@id='s2id_shipping_country']")).click();
		driver.findElement(By.xpath("//input[@id='s2id_autogen1_search']")).sendKeys("Japan", Keys.ENTER);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0, 300);");
		Thread.sleep(3000);
		driver.findElement(By.id("shipping_address_1")).clear();
		driver.findElement(By.id("shipping_address_1")).sendKeys("23 Arigato ST");
		driver.findElement(By.id("shipping_city")).clear();
		driver.findElement(By.id("shipping_city")).sendKeys("Machida");
		driver.findElement(By.xpath("//div[@id='s2id_shipping_state']")).click();
		driver.findElement(By.xpath("//input[@id='s2id_autogen2_search']")).sendKeys("Tokyo", Keys.ENTER);
		Thread.sleep(3000);
		driver.findElement(By.id("shipping_postcode")).clear();
		driver.findElement(By.id("shipping_postcode")).sendKeys("668-7699");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='save_address']")).click();
		// shipping address change message will show up
		detailsChangeVerify();
	}

	@Ignore
	@Test
	public void accountDetails7() throws InterruptedException {
//		3) Click on My Account Menu
		myAccountMenu();
//		4) Enter registered username in username textbox
		enterValidUsername();
//		5) Enter password in password textbox
		enterValidPassword();
//		6) Click on login button
		clickLogin();
//		7) User must successfully login to the web page
		loginPageNavigateCheck();
//		8) Click on Myaccount link
		myAccountMenu();
//		9) Click on Account details
		driver.findElement(By.xpath("//nav[@class='woocommerce-MyAccount-navigation']/ul/li[5]/a")).click();
//		10) User can view account details where he can change his pasword also.

		driver.findElement(By.id("account_first_name")).clear();
		driver.findElement(By.id("account_first_name")).sendKeys("Phanuwat");

		driver.findElement(By.id("account_last_name")).clear();
		driver.findElement(By.id("account_last_name")).sendKeys("Janthima");
		driver.findElement(By.id("password_current")).sendKeys("Selenium9889!");
		driver.findElement(By.id("password_1")).sendKeys("Selenium9981&");
		driver.findElement(By.id("password_2")).sendKeys("Selenium9981&");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='save_account_details']")).click();
		// account details changes message will show up
		detailsChangeVerify();
	}

	@Ignore
	@Test
	public void logOut8() throws InterruptedException {
//		3) Click on My Account Menu
		myAccountMenu();
//		4) Enter registered username in username textbox
		enterValidUsername();
//		5) Enter password in password textbox
		enterValidPassword();
//		6) Click on login button
		clickLogin();
//		7) User must successfully login to the web page
		loginPageNavigateCheck();
//		8) Click on Myaccount link
		myAccountMenu();
//		9) Click on Logout button
		Thread.sleep(3000);
		driver.findElement(By.xpath("//nav[@class='woocommerce-MyAccount-navigation']/ul/li[6]/a")).click();
//		10) On clicking logout,User successfully comes out from the site
		String actualTitle = driver.getTitle();
		String expected = "My Account – Automation Practice Site";
		Assert.assertEquals(actualTitle, expected);
		System.out.println("LOG OUT SUCCESSFUL , TEST PASSED: " + actualTitle);
	}

	public void detailsChangeVerify() {
		WebElement detailsChange = driver.findElement(By.xpath("//div[@class='woocommerce-message']"));
		Assert.assertTrue(detailsChange.isDisplayed());
		System.out.println("TEST PASSED : " + detailsChange.getText());
	}

	public void addressLink() {
		driver.findElement(By.xpath("//nav[@class='woocommerce-MyAccount-navigation']/ul/li[4]/a")).click();
	}

	public void orderLink() {
		driver.findElement(By.xpath("//nav[@class='woocommerce-MyAccount-navigation']/ul/li[2]/a")).click();
	}

	public void loginPageNavigateCheck() {
		WebElement loginPageNavigate = driver
				.findElement(By.xpath("//div[@class='woocommerce-MyAccount-content']/p[1]"));
		Assert.assertTrue(loginPageNavigate.isDisplayed());
		System.out.println("SUCCESSFUL LOGIN, PASSED : " + loginPageNavigate.getText());
	}

	public void clickLogin() {
		driver.findElement(By.xpath(" //input[@name='login']")).click();
	}

	public void myAccountMenu() {
		driver.findElement(By.xpath("//li[@id='menu-item-50']/a")).click();
	}

	public void enterValidPassword() {
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Selenium9889!");
	}

	public void enterValidUsername() {
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("tom_sdet@gmail.com");
	}

	@After
	public void afterMethod() {
		driver.quit();
	}
}
