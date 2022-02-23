package HomeWork;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class automationTestingHomeWork_Shop {
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
	public void priceFunctionality1() throws InterruptedException {
//		3) Click on Shop Menu
		shopMenuTab();
//		4) Adjust the filter by price between 150 to 450 rpsa
		// set explicit wait for slider handle to be click
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//div[@class='price_slider_wrapper']/div[1]/span[2]")));
		// slider handle element
		WebElement slider = driver.findElement(By.xpath("//div[@class='price_slider_wrapper']/div[1]/span[2]"));
		// action class to make slider handle move as requested
		Actions action = new Actions(driver);
		action.dragAndDropBy(slider, -28, 0).build().perform();

		Thread.sleep(2000);// visual purpose
//		5) Now click on Filter button
		filterTab();
//		6) User can view books only between 150 to 450 rps price
		// use JavascriptExecutor to scroll down for better book view
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0, 480);");
		Thread.sleep(3000);
		jse.executeScript("window.scrollBy(0, 500);");
		Thread.sleep(3000);
		// new view after price adjust
		viewBook();
		// Assert method to make sure only between 150 to 450 rps price
		WebElement priceRange = driver.findElement(By.xpath("//div[@class='price_label']"));
		Assert.assertTrue(priceRange.isDisplayed());
		System.out.println("TEST PASSED : " + priceRange.getText());

	}

	@Ignore
	@Test
	public void categoriesFunctionality2() throws InterruptedException {
//		3) Click on Shop Menu
		shopMenuTab();
//		4) Click any of the product links available in the product category
		// Please choose >>>>>[ 1 - Android, 2 - ]HTML, 3 - JavaScript, 4 - Selenium ]
		int selectProductCategories = 2; // select (1 - 4)
		driver.findElement(By.xpath("//div[@id='text-3']//following::li[" + selectProductCategories + "]/a")).click();
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0, 100);");
		Thread.sleep(3000);

		// Assert to make sure only view particular product
		WebElement particularBook = driver.findElement(By.xpath("//ul[@class='products masonry-done']"));
		Assert.assertTrue(particularBook.isDisplayed());
		// 5) Now user can view only that particular product
		viewBook();
		System.out.println("TEST PASSED");
	}

	@Ignore
	@Test
	public void sortByPopularityItem3() throws InterruptedException {
//		3) Click on Shop Menu
		shopMenuTab();
//		4) Click on Sort by Popularity item in Default sorting dropdown
		WebElement sort = driver.findElement(By.xpath("//select[@name='orderby']"));
		Select select = new Select(sort);
		Thread.sleep(3000);
		// use JavascriptExecutor to scroll down for better book view
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0, 480);");
		Thread.sleep(3000);
		// sort by popularity
		select.selectByVisibleText("Sort by popularity");
		jse.executeScript("window.scrollBy(0, 400);");
		Thread.sleep(3000);
		jse.executeScript("window.scrollBy(0, 710);");
		Thread.sleep(3000);
//		5) Now user can view the popular products only
		viewBook();
		// Assert method to make sure Sort by Popularity item
		sortByCheck(2);
	}

	@Ignore
	@Test
	public void sortByAverageRating4() throws InterruptedException {
//		3) Click on Shop Menu
		shopMenuTab();
//		4) Click on Sort by Average ratings in Default sorting dropdown
		WebElement sort = driver.findElement(By.xpath("//select[@name='orderby']"));
		Select select = new Select(sort);
		Thread.sleep(3000);
		// use JavascriptExecutor to scroll down for better book view
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0, 480);");
		Thread.sleep(3000);
		// sort by popularity
		select.selectByVisibleText("Sort by average rating");
		jse.executeScript("window.scrollBy(0, 400);");
		Thread.sleep(3000);
		jse.executeScript("window.scrollBy(0, 710);");
		Thread.sleep(3000);
//		5) Now user can view the popular products only
		viewBook();
		// Assert method to make sure Sort by Average ratings
		sortByCheck(3);
	}
	@Ignore
	@Test
	public void sortByNewnessRating5() throws InterruptedException {
//		3) Click on Shop Menu
		shopMenuTab();
//		4) Click on Sort by Newness ratings in Default sorting dropdown
		WebElement sort = driver.findElement(By.xpath("//select[@name='orderby']"));
		Select select = new Select(sort);
		Thread.sleep(3000);
		// use JavascriptExecutor to scroll down for better book view
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0, 480);");
		Thread.sleep(3000);
		// sort by popularity
		select.selectByVisibleText("Sort by newness");
		jse.executeScript("window.scrollBy(0, 400);");
		Thread.sleep(3000);
		jse.executeScript("window.scrollBy(0, 710);");
		Thread.sleep(3000);
//		5) Now user can view the popular products only
		viewBook();
		// Assert method to make sure Sort by Newness ratings
		sortByCheck(4);
	}

	@Ignore
	@Test
	public void sortByLowToHigh6() throws InterruptedException {
//		3) Click on Shop Menu
		shopMenuTab();
//		4) Click on Sort by Low to High Item in Default sorting dropdown
		WebElement sort = driver.findElement(By.xpath("//select[@name='orderby']"));
		Select select = new Select(sort);
		Thread.sleep(3000);
		// use JavascriptExecutor to scroll down for better book view
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0, 480);");
		Thread.sleep(3000);
		// sort by popularity
		select.selectByVisibleText("Sort by price: low to high");
		jse.executeScript("window.scrollBy(0, 450);");
		Thread.sleep(3000);
		jse.executeScript("window.scrollBy(0, 750);");
		Thread.sleep(3000);
//		5) Now user can view the popular products only
		viewBook();
		// Assert method to make sure it was sort by low to high
		sortByCheck(5);
	}

	@Ignore
	@Test
	public void sortByHighToLow7() throws InterruptedException {
//		3) Click on Shop Menu
		shopMenuTab();
//		4) Click on Sort by high to low Item in Default sorting dropdown
		WebElement sort = driver.findElement(By.xpath("//select[@name='orderby']"));
		Select select = new Select(sort);
		Thread.sleep(3000);
		// use JavascriptExecutor to scroll down for better book view
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0, 480);");
		Thread.sleep(3000);
		// sort by popularity
		select.selectByVisibleText("Sort by price: high to low");
		jse.executeScript("window.scrollBy(0, 450);");
		Thread.sleep(3000);
		jse.executeScript("window.scrollBy(0, 750);");
		Thread.sleep(3000);
//		5) Now user can view the popular products only
		viewBook();
		// Assert method to make sure it was sort by high to low
		sortByCheck(6);
	}

	@Ignore
	@Test
	public void readMoreFunctionality8() throws InterruptedException {
//		3) Click on Shop Menu
		shopMenuTab();
//		4) Click on read more button in home page
		// use JavascriptExecutor to scroll down for better book view
		List<WebElement> listEachBookButtonProduct = driver.findElements(By.xpath("//div[@id=\"content\"]/ul/li/a[2]"));
		for (int i = 1; i <= listEachBookButtonProduct.size(); i++) {
			WebElement eachButton = driver.findElement(By.xpath("//div[@id='content']/ul/li[" + i + "]/a[2]"));
			String eachButtonText = eachButton.getText();
			if (eachButtonText.contains("READ MORE")) {
				// scroll down for better vision on clicking read more button
				JavascriptExecutor jse = (JavascriptExecutor) driver;
				jse.executeScript("window.scrollBy(0, 500);");
				Thread.sleep(3000);
//				4) Click on read more button in home page
				eachButton.click();
				// 5) Read More option indicates the Out Of Stock.
				WebElement outOfStock = driver.findElement(By.xpath("//p[@class='stock out-of-stock']"));
				Assert.assertTrue(outOfStock.isDisplayed());
				// 6) User cannot add the product which has read more option as it was out of
				// stock.
				WebElement bookName = driver.findElement(By.xpath("//h1[@class='product_title entry-title']"));
				String bookNameText = bookName.getText();
				// books that out of stock
				System.out.println(bookNameText + " - " + outOfStock.getText());
				// will navigate back to previous page after each book has been click
				driver.navigate().back();
			}
		}

	}

	@Ignore
	@Test
	public void saleFunctionality9() throws InterruptedException {
//		3) Click on Shop Menu
		shopMenuTab();
//		4) Click on Sale written product in home page
		// get all list of book
		List<WebElement> listEachBook = driver
				.findElements(By.xpath("//ul[@class='products masonry-done']/li/a[1]/span[1]"));
		// int size = listEachBook.size();

		for (int i = 1; i <= listEachBook.size(); i++) {
			WebElement eachBooks = driver
					.findElement(By.xpath("//ul[@class='products masonry-done']/li[" + i + "]/a[1]/span[1]"));

			String bookText = eachBooks.getText();
			// to find which book are on sale
			if (bookText.contains("SALE!")) {
				// scroll down for better vision
				JavascriptExecutor jse = (JavascriptExecutor) driver;
				jse.executeScript("window.scrollBy(0, 500);");
				Thread.sleep(3000);
				// click the book that on sale
				eachBooks.click();
				WebElement bookNameText = driver.findElement(By.xpath("//div[@class='summary entry-summary']/h1"));
				Assert.assertTrue(bookNameText.isDisplayed());
				WebElement discountPrice = driver.findElement(By.xpath("//p[@class='price']"));
				String discountPriceText = discountPrice.getText();
//				5) User can clearly view the actual price with old price striken for the sale written products
				System.out.println(bookNameText.getText() + " : ON " + bookText + " - " + discountPriceText
						+ "\n\t\t---------------");
				driver.navigate().back();
			}

		}

	}

	@Ignore
	@Test
	public void viewBasketFunctionality10() throws InterruptedException {
//		3) Click on Shop Menu
		shopMenuTab();
//		4) Click on the Add To Basket button which adds that book to your basket
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0, 1200);");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@id='content']/ul/li[6]/a[2]")).click();
		Thread.sleep(3000);
//		5) User can view that Book in the Menu item with price .
//		6) Now click on View Basket link which navigates to proceed to check out page.
		driver.findElement(By.xpath("//a[@title='View Basket']")).click();

		navigateToProceedToCheckOutPage();
//		7) Now user can find total and subtotal values just above the Proceed to Checkout button.
//		8) The total always > subtotal because taxes are added in the subtotal
		verifySubTotal();
		verifyTotal();
//		9) Now click on Proceed to Check out button which navigates to payment gateway page.
		proceedToCheckout();
//		10) User can view Billing Details,Order Details,Additional details and Payment gateway details.
		fillUpDetails();

		jse.executeScript("window.scrollBy(0, 400);");

//		11) Now user can fill his details in billing details form and can opt any payment in the payment gateway like Direct bank transfer,cheque,cash or paypal.
		// select payment method
		Thread.sleep(3000);
		driver.findElement(By.id("payment_method_cod")).click();
		// verify order review
		WebElement orderReview = driver.findElement(By.xpath("//div[@id='order_review']"));
		Assert.assertTrue(orderReview.isDisplayed());
		System.out.println("\nTEST PASSED : " + orderReview.getText());
		Thread.sleep(3000);
//		12) Now click on Place Order button to complete process
		driver.findElement(By.id("place_order")).click();
//		13) On clicking place order button user completes his process where the page navigates to Order confirmation page with order details,bank details,customer details and billing details
		WebElement orderDetails = driver.findElement(By.xpath("//div[@class='woocommerce']"));
		Assert.assertTrue(orderDetails.isDisplayed());
		System.out.println("\nTEST PASSED : " + orderDetails.getText());
		Thread.sleep(5000);
	}

	@Ignore
	@Test
	public void viewBasketThroughItemLink11() throws InterruptedException {
//		3) Click on Shop Menu
		shopMenuTab();
//		4) Click on the Add To Basket button which adds that book to your basket
//		5) User can view that Book in the Menu item with price .
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0, 600);");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@id='content']/ul/li[3]/a[2]")).click();
		Thread.sleep(3000);
//		6) Now click on Item link which navigates to proceed to check out page.
		driver.findElement(By.xpath("//a[@title='View your shopping cart']")).click();
//		7) Now user can find total and sub-total values just above the Proceed to Checkout button.
//		8) The total always > sub-total because taxes are added in the sub-total
		verifySubTotal();
		verifyTotal();
//		9) Now click on Proceed to Check out button which navigates to payment gateway page.
		navigateToProceedToCheckOutPage();
		proceedToCheckout();
//		10) User can view Billing Details,Order Details,Additional details and Payment gateway details.
		fillUpDetails();
		jse.executeScript("window.scrollBy(0, 400);");
//		11) Now user can fill his details in billing details form and can opt any payment in the payment gateway like Direct bank transfer,cheque,cash or paypal.
		Thread.sleep(3000);
		driver.findElement(By.xpath("//li[@class='wc_payment_method payment_method_cod']/input")).click();
//		12) Now click on Place Order button to complete process
		Thread.sleep(3000);
		driver.findElement(By.id("place_order")).click();
//		13) On clicking place order button user completes his process where the page navigates to Order confirmation page
//		with order details,bank details,customer details and billing details
		WebElement orderDetails = driver.findElement(By.xpath("//div[@class='woocommerce']"));
		Assert.assertTrue(orderDetails.isDisplayed());
		System.out.println("\nTEST PASSED : " + orderDetails.getText());
		Thread.sleep(5000);
	}

	@Ignore
	@Test
	public void viewBasketTaxFunctionality12() throws InterruptedException {
//		3) Click on Shop Menu
		shopMenuTab();
//		4) Click on the Add To Basket button which adds that book to your basket
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0, 600);");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@id='content']/ul/li[1]/a[2]")).click();
		Thread.sleep(3000);
//		5) User can view that Book in the Menu item with price .
//		6) Now click on Item link which navigates to proceed to check out page.
		driver.findElement(By.xpath("//a[@title='View your shopping cart']")).click();
//		7) Now user can find total and subtotal values just above the Proceed to Checkout button.
//		8) The total always > subtotal because taxes are added in the subtotal
		verifySubTotal();
		verifyTotal();
//		9) The tax rate variers for India compared to other countries
//		10) Tax rate for indian should be 2% and for abroad it should be 5%
		String basketTotal = driver.findElement(By.xpath("//table[@class='shop_table shop_table_responsive']"))
				.getText();
		System.out.println(basketTotal);
		String subTotal = driver.findElement(By.xpath("//td[@data-title='Subtotal']")).getText().replace("₹", "");

		double dSubtotal = Double.parseDouble(subTotal);
		double indiaTaxRate = 0.02;
		double indiatotal = dSubtotal * indiaTaxRate;

		System.out.println("\n~With India Tax Rate~\nSubtotal : ₹" + dSubtotal + "\n" + "India Tax Rate(2%) : ₹"
				+ (dSubtotal * indiaTaxRate) + "\n" + "Total : ₹" + (dSubtotal + indiatotal));
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

	public void navigateToProceedToCheckOutPage() {
		WebElement proceedToCheckOut = driver.findElement(By.xpath("//div[@class='wc-proceed-to-checkout']/a"));
		Assert.assertTrue(proceedToCheckOut.isDisplayed());
		System.out.println("TEST PASSED : " + proceedToCheckOut.getText());
	}

	public void sortByCheck(int i) {
		WebElement sortByDisplay = driver.findElement(By.xpath("//select[@name='orderby']//option[" + i + "]"));
		Assert.assertTrue(sortByDisplay.isDisplayed());
		System.out.println("TEST PASSED : " + sortByDisplay.getText());
	}

	public void viewBook() {
		String books = "//ul[@class='products masonry-done']/li";
		List<WebElement> eachBooks = driver.findElements(By.xpath(books));
		int numBooks = eachBooks.size();
		System.out.println("Number of Books: " + numBooks);

		for (WebElement eachBooksIndex : eachBooks) {
			String print = eachBooksIndex.getText();
			System.out.println("----------\n" + print + "\n----------");
		}
	}

	public void filterTab() {
		driver.findElement(By.xpath("//button[text()='Filter']")).click();
	}

	public void shopMenuTab() {
		driver.findElement(By.xpath("//a[text()='Shop']")).click();
	}

	@After
	public void afterMethod() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
}
