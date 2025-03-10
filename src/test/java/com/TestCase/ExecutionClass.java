package com.TestCase;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Pages.AddToCart;
import com.Pages.HomePage;
import com.Utility.ExtentReport;
import com.Utility.Screenshot;
import org.testng.Assert;

public class ExecutionClass {
	
	WebDriver driver;
	HomePage homePage;
	AddToCart addtoCart;
	ExtentReport extentreport;
	Screenshot screenshot;
	
	@Parameters({"bname"})
	@BeforeMethod
	public void setUp(String bname) {
		
		if(bname.equals("Chrome")){
			driver = new ChromeDriver();
		}else if(bname.equals("Firefox")) {
			driver = new FirefoxDriver();
		}else if(bname.equals("Edge")) {
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); 
		driver.get("https://www.demoblaze.com/");
		homePage = new HomePage(driver);
		addtoCart = new AddToCart(driver);
		extentreport = new ExtentReport();
		screenshot = new Screenshot();
		
	}

	@Test(priority = 1)
	public void signupNew() throws InterruptedException {
		
		Thread.sleep(3000);
		homePage.signupPage("test@615", "Pass1245");
		Screenshot.captureScreenshot(driver, "signup_screenshot");
		System.out.println("SignUp Successful");
	}

	@Test(priority = 2)
	public void login() throws InterruptedException {
		
		Thread.sleep(3000);
		homePage.loginPage("test@615", "Pass1245");
		Thread.sleep(3000);
		WebElement loginName = driver.findElement(By.id("nameofuser"));
		Assert.assertTrue(loginName.isDisplayed());
		Thread.sleep(3000);
		if (loginName.getText().contains("test@615")) {
			System.out.println("Login Successful");
			Screenshot.captureScreenshot(driver, "login_success_screenshot");
		    extentreport.logPass("Login successful");
		} else {
			System.out.println("Login Failed!");
			Screenshot.captureScreenshot(driver, "login_failed_screenshot");
		    extentreport.logFail("Login failed");
		}
	}

	@Test(priority = 3)
	public void checkout() throws InterruptedException {
		
		homePage.loginPage("test@615", "Pass1245");
		addtoCart.productselection();
		addtoCart.checkout("Test", "USA", "Newyork", "12345678", "12", "2025");
		Thread.sleep(3000);
		Assert.assertTrue(driver.findElement(By.xpath("//h2[normalize-space()='Thank you for your purchase!']")).isDisplayed());
		System.out.println("Order Placed Successfully");
		Screenshot.captureScreenshot(driver, "checkout_screenshot");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
		extentreport.generateReport();
	}

}
