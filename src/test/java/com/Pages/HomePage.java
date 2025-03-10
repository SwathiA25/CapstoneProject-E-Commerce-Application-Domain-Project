package com.Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	public WebDriver driver;
	
	public HomePage(WebDriver d) {
		this.driver = d;
		PageFactory.initElements(driver, this); 
	}
	
	@FindBy(id="login2") private WebElement login;
	@FindBy(id="signin2") private WebElement signup;
	@FindBy(id="loginusername") private WebElement userName;
	@FindBy(id="loginpassword") private WebElement pass;
	@FindBy(xpath="//button[normalize-space()='Log in']") private WebElement loginButton;
	@FindBy(id="sign-username") private WebElement signupName;
	@FindBy(id="sign-password") private WebElement signupPass;
	@FindBy(xpath="//button[normalize-space()='Sign up']") private WebElement signupButton;

	public WebElement getLogin() {
		return login;
	}

	public WebElement getSignup() {
		return signup;
	}

	public WebElement getUserName() {
		return userName;
	}

	public WebElement getPass() {
		return pass;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}

	public WebElement getSignupName() {
		return signupName;
	}

	public WebElement getSignupPass() {
		return signupPass;
	}
	
	public WebElement getSignupButton() {
		return signupButton;
	}

	
	
	public void signupPage(String UN,String Pass)
	{
		
		getSignup().click();
		getSignupName().sendKeys(UN);
		getSignupPass().sendKeys(Pass);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		getSignupButton().click();;
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Alert a = driver.switchTo().alert();
		a.accept();

	}
	
	public void loginPage(String UN,String Pass)
	{
		getLogin().click();
		getUserName().sendKeys(UN);
		getPass().sendKeys(Pass);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		getLoginButton().click();;

	}

}
