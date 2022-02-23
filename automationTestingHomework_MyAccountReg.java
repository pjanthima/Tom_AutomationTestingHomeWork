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

public class automationTestingHomework_MyAccountReg {
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

//>>>>>>>The main purpose of using thread sleep throw are just to for visual purpose<<<<<<<<<<<<<<<<<<
	
	@Test
	public void test1() {// Each time of this test require both new email and password
//		3) Click on My Account Menu
		myAccountMenu();
//		4) Enter registered Email Address in Email-Address textBox
		driver.findElement(By.id("reg_email")).sendKeys("tom_556@gmail.com");
//		5) Enter your own password in password textBox
		driver.findElement(By.id("reg_password")).sendKeys("Seleniumfun919$");
//		6) Click on Register button
		registerButton();
//		7) User will be registered successfully and will be navigated to the Home page
		String expectedTitle = "My Account – Automation Practice Site";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
		System.out.println("TEST PASSED : " + actualTitle);
	}

	@Ignore
	@Test
	public void test2() {
//		3) Click on My Account Menu
		myAccountMenu();
//		4) Enter invalid Email Address in Email-Address textbox
		driver.findElement(By.id("reg_email")).sendKeys("t0m_199@gmailcom");
//		5) Enter your own password in password textbox
		driver.findElement(By.id("reg_password")).sendKeys("Javafun2022$$");
//		6) Click on Register button
		registerButton();
//		7) Registration must fail with a warning message(ie You must provide a valid email address)
		properErrorDisplay();
	}

	@Ignore
	@Test
	public void test3() {
//		3) Click on My Account Menu
		myAccountMenu();
//		4) Enter empty Email Address in Email-Address textbox
		enterEmptyEmail();
//		5) Enter your own password in password textbox
		driver.findElement(By.id("reg_password")).sendKeys("Seleniumfun8899!!");
//		6) Click on Register button
		registerButton();
//		7) Registration must fail with a warning message(ie please provide valid email address)
		properErrorDisplay();
	}

	@Ignore
	@Test
	public void test4() {
//		3) Click on My Account Menu
		myAccountMenu();
//		4) Enter valid Email Address in Email-Address textbox
		driver.findElement(By.id("reg_email")).sendKeys("tomjr_898@gmail.com");
//		5) Enter empty password in password textbox
		enterEmptyPassword();
//		6) Click on Register button
		registerButton();
//		7) Registration must fail with a warning message(ie please enter an account password)
		properErrorDisplay();
	}
	@Ignore
	@Test
	public void test5() {
//		3) Click on My Account Menu
		myAccountMenu();
//		4) Enter empty Email Address in Email-Address textbox
		enterEmptyEmail();
//		5) Enter empty password in password textbox
		enterEmptyPassword();
//		6) Click on Register button
		registerButton();
//		7) Registration must fail with a warning message(ie please provide valid email address)
		properErrorDisplay();
	}

	public void properErrorDisplay() {
		WebElement errorDisplay = driver.findElement(By.xpath("//ul[@class='woocommerce-error']/li"));
		Assert.assertTrue(errorDisplay.isDisplayed());
		System.out.println("TEST PASSED : " + errorDisplay.getText());
	}

	public void enterEmptyPassword() {
		driver.findElement(By.id("reg_password")).sendKeys("");

	}

	public void enterEmptyEmail() {
		driver.findElement(By.id("reg_email")).sendKeys("");

	}

	public void registerButton() {
		driver.findElement(By.xpath("//input[@name='register']")).click();
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
