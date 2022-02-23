package HomeWork;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class automationTestingHomework_MyAccountLogin {
	WebDriver driver;
	private String url = "http://practice.automationtesting.in/";

	@Before
	public void beforeMethod() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
//		1) Open the browser
//		2) Enter the URL “http://practice.automationtesting.in/”
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

//>>>>>>>>The main purpose of using Thread.sleep throw are just to for visual purpose<<<<<<<<<<<<<<<<<<

	@Test
	public void test1() {
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
	}

	@Ignore
	@Test
	public void test2() {
//		3) Click on My Account Menu
		myAccountMenu();
//		4) Enter incorrect username in username textbox
		enterIncorrectUsername();
//		5) Enter incorrect password in password textbox.
		enterIncorrectPassword();
//		6) Click on login button
		clickLogin();
//		7) Proper error must be displayed(ie Invalid username) and prompt to enter login again
		properErrorDisplay();
	}

	@Ignore
	@Test
	public void test3() {
//		3) Click on My Account Menu
		myAccountMenu();
//		4) Enter valid username in username textbox
		enterValidUsername();
//		5) Now enter empty password in the password textbox
		enterEmptyPassword();
//		6) Click on login button.
		clickLogin();
//		7) Proper error must be displayed(ie The password field is empty) and prompt to enter login again
		properErrorDisplay();
	}

	@Ignore
	@Test
	public void test4() {
//		3) Click on My Account Menu
		myAccountMenu();
//		4) Enter empty username in username textbox
		enterEmptyUsername();
//		5) Now enter valid password in the password textbox
		enterValidPassword();
//		6) Click on login button.
		clickLogin();
//		7) Proper error must be displayed(ie Username is required) and prompt to enter login again
		properErrorDisplay();
	}

	@Ignore
	@Test
	public void test5() {
//		3) Click on My Account Menu
		myAccountMenu();
//		4) Enter empty username in username textbox
		enterEmptyUsername();
//		5) Now enter empty password in the password textbox
		enterEmptyPassword();
//		6) Click on login button.
		clickLogin();
//		7) Proper error must be displayed(ie required username) and prompt to enter login again
		properErrorDisplay();
	}

	@Ignore
	@Test
	public void test6() {
//		3) Click on My Account Menu
		myAccountMenu();
//		4) Enter the password field with some characters.
		enterValidPassword();
//		5) The password field should display the characters in asterisks or bullets such that the password is not visible on the screen
		WebElement loginPageNavigate = driver.findElement(By.xpath("//*[@id=\"customer_login\"]/div[1]/form/p[2]"));
		Assert.assertTrue(loginPageNavigate.isDisplayed());
		System.out.println("TEST PASSED : " + loginPageNavigate.getText());
	}

	@Ignore
	@Test
	public void test7() {
//		3) Click on My Account Menu
		myAccountMenu();
//		4) Enter the case changed username in username textbox
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("TOM_sdet@gmail.com");
//		5) Enter the case chenged password in the password tetxbox
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("seLeniUM8989@");
//		6) Now click on login button
		clickLogin();
//		7) Login must fail saying incorrect username/password.
		properErrorDisplay();
	}

	@Ignore
	@Test
	public void test8() throws InterruptedException {
//		3) Click on My Account Menu
		myAccountMenu();
//		4) Enter registered username in username textbox
		enterValidUsername();
//		5) Enter password in password textbox
		enterValidPassword();
//		6) Click on login button
		clickLogin();
		loginPageNavigateCheck();
		Thread.sleep(3000);
//		7) Once your are logged in, sign out of the site
		driver.findElement(By.xpath("//div[@class='woocommerce-MyAccount-content']/p[1]/a")).click();
//		8) Now press back button
		driver.navigate().back();
//		9) User shouldn’t be signed in to his account rather a general webpage must be visible
		String expectedTitle = "My Account – Automation Practice Site";
		navigatesToPage(expectedTitle);
	}

	public void navigatesToPage(String expectedTitle) {
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
		System.out.println("TEST PASSED : " + actualTitle);
	}

	public void properErrorDisplay() {
		WebElement errorDisplay = driver.findElement(By.xpath("//ul[@class='woocommerce-error']/li"));
		Assert.assertTrue(errorDisplay.isDisplayed());
		System.out.println("TEST PASSED : " + errorDisplay.getText());
	}

	public void loginPageNavigateCheck() {
		WebElement loginPageNavigate = driver
				.findElement(By.xpath("//div[@class='woocommerce-MyAccount-content']/p[1]"));
		Assert.assertTrue(loginPageNavigate.isDisplayed());
		System.out.println("TEST PASSED : " + loginPageNavigate.getText());
	}

	public void clickLogin() {
		driver.findElement(By.xpath(" //input[@name='login']")).click();
	}

	public void enterEmptyPassword() {
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(" ");

	}

	public void enterEmptyUsername() {
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(" ");

	}

	public void enterIncorrectPassword() {
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("selenium89$");

	}

	public void enterIncorrectUsername() {
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("tomsde@gmailco");

	}

	public void enterValidPassword() {
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Selenium8989@");

	}

	public void enterValidUsername() {
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("tom_sdet@gmail.com");

	}

	public void myAccountMenu() {
		driver.findElement(By.xpath("//li[@id='menu-item-50']/a")).click();
	}

	@After
	public void afterMethod() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
}
