package HomeWork;

import java.util.List;
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
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class automationTestingHomeWork_HomePage {
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

//>>>>>The main purpose of using Thread.sleep(); are just to for visual purpose<<<<<<<<
	@Ignore
	@Test
	public void Test1() throws InterruptedException {
//		3) Click on Shop Menu
		clickShopMenu();
//		4) Now click on Home menu button
		homeMenuButton();

		clickArrow();
		Thread.sleep(2000);
		clickArrow();
		Thread.sleep(2000);
		clickArrow();
//		5) Test whether the Home page has Three Sliders only
//		6) The Home page must contains only three sliders
		verifyThreeSlider();

	}

	@Ignore
	@Test
	public void Test2() throws InterruptedException {
//		3) Click on Shop Menu
		clickShopMenu();
//		4) Now click on Home menu button
		homeMenuButton();
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0, 700);");
		Thread.sleep(3000);
//		5) Test whether the Home page has Three Arrivals only
//  	6) The Home page must contains only three Arrivals
		verifyThreeArrival();
	}

	@Ignore
	@Test
	public void Test3() {
//		3) Click on Shop Menu
		clickShopMenu();
//		4) Now click on Home menu button
		homeMenuButton();
//		5) Test whether the Home page has Three Arrivals only
//		6) The Home page must contains only three Arrivals
		verifyThreeArrival();
//		7) Now click the image in the Arrivals
		clickableImage();
//		8) Test whether it is navigating to next page where the user can add that book into his basket.
//		9) Image should be click able and should navigate to next page where user can add that book to his basket
		addToBasketButton();
	}

	@Ignore
	@Test
	public void Test4() throws InterruptedException {
//		3) Click on Shop Menu
		clickShopMenu();
//		4) Now click on Home menu button
		homeMenuButton();
//		5) Test whether the Home page has Three Arrivals only
//		6) The Home page must contains only three Arrivals
		verifyThreeArrival();
//		7) Now click the image in the Arrivals
		clickableImage();
//		8) Test whether it is navigating to next page where the user can add that book into his basket.
//		9) Image should be click able and should navigate to next page where user can add that book to his basket
		addToBasketButton();
//		10) Click on Description tab for the book you clicked on.
//		11) There should be a description regarding that book the user clicked on
		// click review tabs first then click description tabs to check description tab
		// works
		driver.findElement(By.xpath("//li[@class='reviews_tab']")).click();
		Thread.sleep(3000);
		// click description tab
		driver.findElement(By.xpath("//li[@class='description_tab']")).click();
		Thread.sleep(3000);
		// verify that description tab has been click
		WebElement desciptionTab = driver.findElement(By.xpath("//div[@id='tab-description']"));
		Assert.assertTrue(desciptionTab.isDisplayed());
		System.out.println("TEST PASSED : " + desciptionTab.getText());
	}

	@Ignore
	@Test
	public void Test5() throws InterruptedException {
//		3) Click on Shop Menu
		clickShopMenu();
//		4) Now click on Home menu button
		homeMenuButton();
//		5) Test whether the Home page has Three Arrivals only
//		6) The Home page must contains only three Arrivals
		verifyThreeArrival();
//		7) Now click the image in the Arrivals
		clickableImage();
//		8) Test whether it is navigating to next page where the user can add that book into his basket.
//		9) Image should be click able and should navigate to next page where user can add that book to his basket
		addToBasketButton();
		Thread.sleep(3000);
//		10) Now click on Reviews tab for the book you clicked on.
//		11) There should be a Reviews regarding that book the user clicked on
		driver.findElement(By.xpath("//li[@class='reviews_tab']")).click();
		// verify that review tabs has been click
		WebElement reviewTab = driver.findElement(By.xpath("//h2[@class='woocommerce-Reviews-title']"));
		Assert.assertTrue(reviewTab.isDisplayed());
		System.out.println("TEST PASSED : " + reviewTab.getText());
	}

	@Ignore
	@Test
	public void Test6() {
//		3) Click on Shop Menu
		clickShopMenu();
//		4) Now click on Home menu button
		homeMenuButton();
//		5) Test whether the Home page has Three Arrivals only
//		6) The Home page must contains only three Arrivals
		verifyThreeArrival();
//		7) Now click the image in the Arrivals
		clickableImage();
//		8) Test whether it is navigating to next page where the user can add that book into his basket.
//		9) Image should be click able and should navigate to next page where user can add that book to his basket
//		10) Click on the Add To Basket button which adds that book to your basket
		addToBasketButton();
//		11) User can view that Book in the Menu item with price.
		menuItemTab();
//		12) User can add a book by clicking on Add To Basket button which adds that book in to his Basket
	}

	@Ignore
	@Test
	public void Test7() {
//		3) Click on Shop Menu
		clickShopMenu();
//		4) Now click on Home menu button
		homeMenuButton();
//		5) Test whether the Home page has Three Arrivals only
//		6) The Home page must contains only three Arrivals
		verifyThreeArrival();
//		7) Now click the image in the Arrivals
		clickableImage();
//		8) Test whether it is navigating to next page where the user can add that book into his basket.
//		9) Image should be click able and should navigate to next page where user can add that book to his basket
//		10) Click on the Add To Basket button which adds that book to your basket
		addToBasketButton();
//		11) User can view that Book in the Menu item with price.
		menuItemTab();
//		12) User can add a book by clicking on Add To Basket button which adds that book in to his Basket
//		13) Select more books than the books in stock.Ex if the stock has 20 books, try to add 21.
		// stock dynamically change, please update prior to testing
		// clear textBox amount to empty first
		textBoxClear();
		driver.findElement(By.xpath("//td[@class='product-quantity']/div[1]/input")).sendKeys("10000");
//		14) Click the add to basket button
		updateBasket();
//		15) Now it throws an error prompt like you must enter a value between 1 and 20
		System.out.println("Value must be less than or equal to stock limit should pop-up");
	}

	@Ignore
	@Test
	public void Test8() {
//		3) Click on Shop Menu
		clickShopMenu();
//		4) Now click on Home menu button
		homeMenuButton();
//		5) Test whether the Home page has Three Arrivals only
//		6) The Home page must contains only three Arrivals
		verifyThreeArrival();
//		7) Now click the image in the Arrivals
		clickableImage();
//		8) Test whether it is navigating to next page where the user can add that book into his basket.
//		9) Image should be click able and should navigate to next page where user can add that book to his basket
//		10) Click on the Add To Basket button which adds that book to your basket
		addToBasketButton();
//		11) User can view that Book in the Menu item with price.
		menuItemTab();
//		12) Now click on Item link which navigates to proceed to check out page.
//		13) User can click on the Item link in menu item after adding the book in to the basket which leads to the check out page
		navigateToProceedToCheckOutPage();
	}

	@Ignore
	@Test
	public void Test9() throws InterruptedException {
//		3) Click on Shop Menu
		clickShopMenu();
//		4) Now click on Home menu button
		homeMenuButton();
//		5) Test whether the Home page has Three Arrivals only
//		6) The Home page must contains only three Arrivals
		verifyThreeArrival();
//		7) Now click the image in the Arrivals
		clickableImage();
//		8) Test whether it is navigating to next page where the user can add that book into his basket.
//		9) Image should be click able and should navigate to next page where user can add that book to his basket
//		10) Click on the Add To Basket button which adds that book to your basket
		addToBasketButton();
//		11) User can view that Book in the Menu item with price.
		menuItemTab();
//		12) Now click on Item link which navigates to proceed to check out page.
		navigateToProceedToCheckOutPage();
		// create textBox(Input type - node) variables in order to update the quantity
		// of item
		WebElement textBox = driver.findElement(By.xpath("//div[@class='quantity']/input"));
		// before update, textBox must be clear first
		textBoxClear();
		Thread.sleep(2000);
		// after clear, enter the quantity to make total > 450rps to get 50rps off
		textBox.sendKeys("2");
		// update basket
		updateBasket();
		Thread.sleep(3000);
//		13) User can click on the Item link in menu item after adding the book in to the basket which leads to the check out page
//		14) Enter the Coupon code as ‘krishnasakinala’ to get 50rps off on the total.
//		15) User can able to apply coupon by entering ‘krishnasakinala’ in the coupon text box which give 50rps off on the total price
		enterCouponCode();
		Thread.sleep(3000);
		// verify Coupon code applied successfully.
		String applyCouponMessage = driver.findElement(By.xpath("//div[@class='woocommerce-message']")).getText();
		String expected = "Coupon code applied successfully.";
		Assert.assertEquals(applyCouponMessage, expected);
		System.out.println("TEST PASSED : " + applyCouponMessage);
	}

	@Ignore
	@Test
	public void Test10() {
//		3) Click on Shop Menu
		clickShopMenu();
//		4) Now click on Home menu button
		homeMenuButton();
//		5) Test whether the Home page has Three Arrivals only
//		6) The Home page must contains only three Arrivals
		verifyThreeArrival();
//		7) Now click the image in the Arrivals
		clickableImage();
//		8) Test whether it is navigating to next page where the user can add that book into his basket.
//		9) Image should be click able and should navigate to next page where user can add that book to his basket
//		10) Click on the Add To Basket button which adds that book to your basket
		addToBasketButton();
//		11) User can view that Book in the Menu item with price.
		menuItemTab();
//		12) Now click on Item link which navigates to proceed to check out page.
//		13) User can click on the Item link in menu item after adding the book in to the basket which leads to the check out page
		navigateToProceedToCheckOutPage();
//		14) Enter the Coupon code as ‘krishnasakinala’ to get 50rps off on the total.
		enterCouponCode();
//		15) User can not able to apply coupon by entering ‘krishnasakinala’ in the coupon textbox which give 50rps off on the total price
//		because the coupon is applicable for the book price > 450 rps
		WebElement unableToAddCoupon = driver.findElement(By.xpath("//ul[@class='woocommerce-error']/li"));
		Assert.assertTrue(unableToAddCoupon.isDisplayed());
		System.out.println("TEST PASSED, COUPON CANNOT BE APPLIED : " + unableToAddCoupon.getText());
	}

	@Ignore
	@Test
	public void Test11() {
//		3) Click on Shop Menu
		clickShopMenu();
//		4) Now click on Home menu button
		homeMenuButton();
//		5) Test whether the Home page has Three Arrivals only
//		6) The Home page must contains only three Arrivals
		verifyThreeArrival();
//		7) Now click the image in the Arrivals
		clickableImage();
//		8) Test whether it is navigating to next page where the user can add that book into his basket.
//		9) Image should be click able and should navigate to next page where user can add that book to his basket
//		10) Click on the Add To Basket button which adds that book to your basket
		addToBasketButton();
//		11) User can view that Book in the Menu item with price.
		menuItemTab();
//		12) Now click on Item link which navigates to proceed to check out page.
		navigateToProceedToCheckOutPage();
//		13) Now click on Remove this icon in Check out page which removes that book from the grid.
		driver.findElement(By.xpath("//td[@class='product-remove']/a")).click();
//		14) User has the feasibility to remove the book at the time of check out also
		WebElement removeItem = driver.findElement(By.xpath("//div[@class='woocommerce']/p[1]"));
		Assert.assertTrue(removeItem.isDisplayed());
		System.out.println("TEST PASSED, REMOVE ITEM SUCCESSFUL : " + removeItem.getText());
	}

	@Ignore
	@Test
	public void Test12() throws InterruptedException {
//		3) Click on Shop Menu
		clickShopMenu();
//		4) Now click on Home menu button
		homeMenuButton();
//		5) Test whether the Home page has Three Arrivals only
//		6) The Home page must contains only three Arrivals
		verifyThreeArrival();
//		7) Now click the image in the Arrivals
		clickableImage();
//		8) Test whether it is navigating to next page where the user can add that book into his basket.
//		9) Image should be click able and should navigate to next page where user can add that book to his basket
//		10) Click on the Add To Basket button which adds that book to your basket
		addToBasketButton();
//		11) User can view that Book in the Menu item with price.
		menuItemTab();
//		12) Now click on Item link which navigates to proceed to check out page.
		navigateToProceedToCheckOutPage();
//		13) Click on textBox value under quantity in Check out page to add or subtract books.
		WebElement textBox1 = driver.findElement(By.xpath("//div[@class='quantity']/input"));
		textBoxClear();
		Thread.sleep(2000);
		// add 8 item to cart
		textBox1.sendKeys("8");
//		14) Now after the above change ‘Update Basket’ button will turn into Clickable mode.
//		15) Now click on Update Basket to reflect those changes
		updateBasket();
		// verify add basket
		WebElement addBasket = driver.findElement(By.xpath("//div[@class='woocommerce-message']"));
		Assert.assertTrue(addBasket.isDisplayed());
		System.out.println("TEST PASSED - ADD BASKET SUCCESSFUL : " + addBasket.getText());
		Thread.sleep(2000);
		// after add more item test, must also test subtract item
		WebElement textBox2 = driver.findElement(By.xpath("//div[@class='quantity']/input"));
		textBoxClear();
		Thread.sleep(2000);
		textBox2.sendKeys("4");
		updateBasket();
//		16) User has the feasibility to Update Basket at the time of check out.
		// verify subtract item
		WebElement subtractBasket = driver.findElement(By.xpath("//div[@class='woocommerce-message']"));
		Assert.assertTrue(subtractBasket.isDisplayed());
		System.out.println("TEST PASSED - SUBTRACT BASKET SUCCESSFUL : " + subtractBasket.getText());
	}

	@Ignore
	@Test
	public void Test13() throws InterruptedException {
//		3) Click on Shop Menu
		clickShopMenu();
//		4) Now click on Home menu button
		homeMenuButton();
//		5) Test whether the Home page has Three Arrivals only
//		6) The Home page must contains only three Arrivals
		verifyThreeArrival();
//		7) Now click the image in the Arrivals
		clickableImage();
//		8) Test whether it is navigating to next page where the user can add that book into his basket.
//		9) Image should be click able and should navigate to next page where user can add that book to his basket
//		10) Click on the Add To Basket button which adds that book to your basket
		addToBasketButton();
//		11) User can view that Book in the Menu item with price.
		menuItemTab();
//		12) Now click on Item link which navigates to proceed to check out page.
		navigateToProceedToCheckOutPage();
		WebElement textBox = driver.findElement(By.xpath("//div[@class='quantity']/input"));
		textBoxClear(); // 5 item to cart
		textBox.sendKeys("5");
		updateBasket();
		Thread.sleep(3000);
//		13) Now User can find the Total price of the book in the Check out grid.
//		14) User has the feasibility to find the total price of the books at to find the total price of the books at the time of check out
		verifyTotal();
	}

	public void Test14() {
		// Test 14 and Test 12 are the same
	}

	@Ignore
	@Test
	public void Test15() throws InterruptedException {
//		3) Click on Shop Menu
		clickShopMenu();
//		4) Now click on Home menu button
		homeMenuButton();
//		5) Test whether the Home page has Three Arrivals only
//		6) The Home page must contains only three Arrivals
		verifyThreeArrival();
//		7) Now click the image in the Arrivals
		clickableImage();
//		8) Test whether it is navigating to next page where the user can add that book into his basket.
//		9) Image should be click able and should navigate to next page where user can add that book to his basket
//		10) Click on the Add To Basket button which adds that book to your basket
		addToBasketButton();
//		11) User can view that Book in the Menu item with price.
		menuItemTab();
//		12) Now click on Item link which navigates to proceed to check out page.
		navigateToProceedToCheckOutPage();
		WebElement textBox = driver.findElement(By.xpath("//div[@class='quantity']/input"));
		textBoxClear();
		// 12 item to cart
		textBox.sendKeys("12");
		updateBasket();
		Thread.sleep(3000);
//		13) Now user can find total and subtotal values just above the Proceed to Checkout button.
//		14) The total always > subtotal because taxes are added in the total
//		15) Total
		verifySubTotal();
		verifyTotal();
	}

	@Ignore
	@Test
	public void Test16() throws InterruptedException {
//		3) Click on Shop Menu
		clickShopMenu();
//		4) Now click on Home menu button
		homeMenuButton();
//		5) Test whether the Home page has Three Arrivals only
//		6) The Home page must contains only three Arrivals
		verifyThreeArrival();
//		7) Now click the image in the Arrivals
		clickableImage();
//		8) Test whether it is navigating to next page where the user can add that book into his basket.
//		9) Image should be click able and should navigate to next page where user can add that book to his basket
//		10) Click on the Add To Basket button which adds that book to your basket
		addToBasketButton();
//		11) User can view that Book in the Menu item with price.
		menuItemTab();
//		12) Now click on Item link which navigates to proceed to check out page.
		navigateToProceedToCheckOutPage();
		WebElement textBox = driver.findElement(By.xpath("//div[@class='quantity']/input"));
		textBoxClear();
		// 3 item to cart
		textBox.sendKeys("3");
		updateBasket();
		Thread.sleep(3000);
//		13) Now user can find total and subtotal values just above the Proceed to Checkout button.
//		14) The total always > subtotal because taxes are added in the total
		verifySubTotal();
		verifyTotal();
//		15) Now click on Proceed to Check out button which navigates to payment gateway page.
		proceedToCheckout();
//		16) Clicking on Proceed to Checkout button leads to payment gateway page
		String expectedTitle = "Checkout – Automation Practice Site";
		navigatesToPaymentGatewayPage(expectedTitle);
	}

	@Ignore
	@Test
	public void Test17() throws InterruptedException {
//		3) Click on Shop Menu
		clickShopMenu();
//		4) Now click on Home menu button
		homeMenuButton();
//		5) Test whether the Home page has Three Arrivals only
//		6) The Home page must contains only three Arrivals
		verifyThreeArrival();
//		7) Now click the image in the Arrivals
		clickableImage();
//		8) Test whether it is navigating to next page where the user can add that book into his basket.
//		9) Image should be click able and should navigate to next page where user can add that book to his basket
//		10) Click on the Add To Basket button which adds that book to your basket
		addToBasketButton();
//		11) User can view that Book in the Menu item with price.
		menuItemTab();
//		12) Now click on Item link which navigates to proceed to check out page.
		navigateToProceedToCheckOutPage();
		WebElement textBox = driver.findElement(By.xpath("//div[@class='quantity']/input"));
		textBoxClear();
		// 9 item to cart
		textBox.sendKeys("9");
		updateBasket();
		Thread.sleep(3000);
//		13) Now user can find total and subtotal values just above the Proceed to Checkout button.
//		14) The total always > subtotal because taxes are added in the total
		verifySubTotal();
		verifyTotal();
//		15) Now click on Proceed to Check out button which navigates to payment gateway page.
		proceedToCheckout();
		String expectedTitle = "Checkout – Automation Practice Site";
		navigatesToPaymentGatewayPage(expectedTitle);
//		16)User can view Billing Details,Order Details,Additional details and Payment gateway details.
//		17)Now user can fill his details in billing details form and can opt any payment in the payment gateway like Direct bank transfer,cheque,cash or paypal.
		driver.findElement(By.xpath("//*[@id='page-35']/div/div[1]/div[2]/a")).click();
//		18)User has the feasibility to add coupon in the payment gateway page and also he can find billing,order and additional details.
		driver.findElement(By.xpath("//*[@id=\"coupon_code\"]")).sendKeys("krishnasakinala");
		driver.findElement(By.xpath("//form[@class='checkout_coupon']/p[2]/input")).click();
		// verify apply coupon
		WebElement applyCoupon = driver.findElement(By.xpath("//div[@class='woocommerce-message']"));
		Assert.assertTrue(applyCoupon.isDisplayed());
		System.out.println("TEST PASSED : " + applyCoupon.getText());
		Thread.sleep(3000);
		// fill up detail
		fillUpDetails();
		// select payment method
		driver.findElement(By.id("payment_method_ppec_paypal")).click();
		WebElement orderReview = driver.findElement(By.xpath("//div[@id='order_review']"));
		Assert.assertTrue(orderReview.isDisplayed());
		System.out.println("\nTEST PASSED : " + orderReview.getText());
		Thread.sleep(3000);
	}

	@Ignore
	@Test
	public void Test18() throws InterruptedException {
//		3) Click on Shop Menu
		clickShopMenu();
//		4) Now click on Home menu button
		homeMenuButton();
//		5) Test whether the Home page has Three Arrivals only
//		6) The Home page must contains only three Arrivals
		verifyThreeArrival();
//		7) Now click the image in the Arrivals
		clickableImage();
//		8) Test whether it is navigating to next page where the user can add that book into his basket.
//		9) Image should be click able and should navigate to next page where user can add that book to his basket
//		10) Click on the Add To Basket button which adds that book to your basket
		addToBasketButton();
//		11) User can view that Book in the Menu item with price.
		menuItemTab();
//		12) Now click on Item link which navigates to proceed to check out page.
		navigateToProceedToCheckOutPage();
		WebElement textBox = driver.findElement(By.xpath("//div[@class='quantity']/input"));
		textBoxClear();
		// 6 item to cart
		textBox.sendKeys("6");
		updateBasket();
		Thread.sleep(3000);
//		13) Now user can find total and subtotal values just above the Proceed to Checkout button.
//		14) The total always > subtotal because taxes are added in the total
		verifySubTotal();
		verifyTotal();
//		15) Now click on Proceed to Check out button which navigates to payment gateway page.
		proceedToCheckout();
		String expectedTitle = "Checkout – Automation Practice Site";
		navigatesToPaymentGatewayPage(expectedTitle);
//		16)User can view Billing Details,Order Details,Additional details and Payment gateway details.
//		17)Now user can fill his details in billing details form and can opt any payment in the payment gateway like Direct bank transfer,cheque,cash or paypal.
		Thread.sleep(2000);
		// fill up details
		fillUpDetails();
		// select payment method
		driver.findElement(By.id("payment_method_cod")).click();
		// verify order review
		WebElement orderReview = driver.findElement(By.xpath("//div[@id='order_review']"));
		Assert.assertTrue(orderReview.isDisplayed());
		System.out.println("\nTEST PASSED : " + orderReview.getText());
		Thread.sleep(3000);
//		18) Now click on Place Order button to complete process
		driver.findElement(By.id("place_order")).click();
//		19) On clicking place-order button user completes the process where the page navigates to Order confirmation page
//		with order details,bank details,customer details and billing details.
		WebElement orderDetails = driver.findElement(By.xpath("//div[@class='woocommerce']"));
		Assert.assertTrue(orderDetails.isDisplayed());
		System.out.println("\nTEST PASSED : " + orderDetails.getText());
		Thread.sleep(5000);
	}

	public void clickArrow() {
		driver.findElement(By.xpath("//div[@id='n2-ss-6']/div[3]")).click();
	}

	public void fillUpDetails() throws InterruptedException {
		driver.findElement(By.id("billing_first_name")).sendKeys("Phanuwat");
		driver.findElement(By.id("billing_last_name")).sendKeys("Janthima");
		driver.findElement(By.id("billing_company")).sendKeys("Tech Circle");
		driver.findElement(By.id("billing_email")).sendKeys("pj_989@techcircle.edu");
		driver.findElement(By.id("billing_phone")).sendKeys("703-999-9898");
		driver.findElement(By.xpath("//*[@id='s2id_billing_country']/a/span[2]/b")).click();
		driver.findElement(By.xpath("//input[@id='s2id_autogen1_search']")).sendKeys("Malaysia", Keys.ENTER);
		Thread.sleep(2000);
		driver.findElement(By.id("billing_address_1")).sendKeys("8998 Neverland City");
		driver.findElement(By.id("billing_city")).sendKeys("Damansara");
		driver.findElement(By.xpath("//*[@id=\"s2id_billing_state\"]/a/span[2]/b")).click();
		driver.findElement(By.xpath("//div[@id='select2-drop']/div/input")).sendKeys("Kuala Lumpur", Keys.ENTER);
		Thread.sleep(2000);
		driver.findElement(By.id("billing_postcode")).sendKeys("98999");
		Thread.sleep(2000);
	}

	public void textBoxClear() {
		WebElement textBox = driver.findElement(By.xpath("//div[@class='quantity']/input"));
		textBox.clear();
	}

	public void navigatesToPaymentGatewayPage(String expectedTitle) {
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
		System.out.println("TEST PASSED : " + actualTitle);
	}

	public void proceedToCheckout() {
		driver.findElement(By.xpath("//div[@class='wc-proceed-to-checkout']/a")).click();
	}

	public void verifySubTotal() {
		WebElement subTotal = driver.findElement(By.xpath("//tr[@class='cart-subtotal']/td[1]/span"));
		Assert.assertTrue(subTotal.isDisplayed());
		System.out.println("SUBTOTAL : " + subTotal.getText());
	}

	public void verifyTotal() {
		WebElement total = driver.findElement(By.xpath("//tr[@class='order-total']/td[1]/strong/span"));
		Assert.assertTrue(total.isDisplayed());
		System.out.println("TOTAL : " + total.getText());
	}

	public void enterCouponCode() {
		driver.findElement(By.xpath("//div[@class='coupon']/input[1]")).sendKeys("krishnasakinala");
		driver.findElement(By.xpath("//div[@class='coupon']/input[2]")).click();
	}

	public void navigateToProceedToCheckOutPage() {
		WebElement proceedToCheckOut = driver.findElement(By.xpath("//div[@class='wc-proceed-to-checkout']/a"));
		Assert.assertTrue(proceedToCheckOut.isDisplayed());
		System.out.println("TEST PASSED : " + proceedToCheckOut.getText());
	}

	public void updateBasket() {
		driver.findElement(By.xpath("//td[@class='actions']/input[1]")).click();
	}

	public void menuItemTab() {
		driver.findElement(By.xpath("//li[@id='wpmenucartli']/a")).click();
	}

	public void addToBasketButton() {
		WebElement addToBasketButton = driver.findElement(By.xpath("//form[@class='cart']/button"));
		Assert.assertTrue(addToBasketButton.isDisplayed());
		System.out.println(addToBasketButton.getText() + " Successful!!");
		addToBasketButton.click();

	}

	public void clickableImage() {
		driver.findElement(By.xpath("//*[@id=\"text-22-sub_row_1-0-2-2-0\"]/div/ul/li/a[1]/img")).click();

	}

	public void verifyThreeArrival() {
		String arrivals = "//*[@id=\"themify_builder_content-22\"]/div[2]/div/div/div/div/div[2]/div";
		List<WebElement> eachArrivals = driver.findElements(By.xpath(arrivals));
		int numArrivals = eachArrivals.size();
		System.out.println("Number of arrivals: " + numArrivals);
		Assert.assertTrue(numArrivals == 3);
		System.out.println("TEST PASSED");


	}

	public void verifyThreeSlider() {
		List<WebElement> list = driver.findElements(By.xpath("//*[@id='n2-ss-6']/div"));
		int numOfSlider = list.size();
		System.out.println("Number of slider are " + numOfSlider);
		Assert.assertTrue(numOfSlider == 3);
		System.out.println("TEST PASSED");

	}

	public void clickShopMenu() {
		driver.findElement(By.xpath("//li[@id='menu-item-40']")).click();
	}

	public void homeMenuButton() {
		driver.findElement(By.xpath("//div[@id='content']/nav/a")).click();
	}

	@After
	public void afterMethod() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
}
