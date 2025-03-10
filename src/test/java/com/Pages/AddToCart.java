package com.Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCart {
	
	public WebDriver driver;
	
	public AddToCart(WebDriver d) {
		this.driver = d;
		PageFactory.initElements(driver, this); 
	}
	
	@FindBy(xpath="//a[normalize-space()='Nokia lumia 1520']") private WebElement product;
	@FindBy(xpath="//a[normalize-space()='Add to cart']") private WebElement addtocart;
	@FindBy(id="cartur") private WebElement cart;
	@FindBy(xpath="//button[normalize-space()='Place Order']") private WebElement placeorder;
	@FindBy(id="name") private WebElement name;
	@FindBy(id="country") private WebElement country;
	@FindBy(id="city") private WebElement city;
	@FindBy(id="card") private WebElement card;
	@FindBy(id="month") private WebElement month;
	@FindBy(id="year") private WebElement year;
	@FindBy(xpath="//button[normalize-space()='Purchase']") private WebElement purchase;
	
	public WebElement getProduct() {
		return product;
	}
	
	public WebElement getAddtocart() {
		return addtocart;
	}
	
	public WebElement getCart() {
		return cart;
	}
	
	public WebElement getPlaceorder() {
		return placeorder;
	}
	
	public WebElement getName() {
		return name;
	}
	
	public WebElement getCountry() {
		return country;
	}
	
	public WebElement getCity() {
		return city;
	}
	
	public WebElement getCard() {
		return card;
	}
	
	public WebElement getMonth() {
		return month;
	}
	
	public WebElement getYear() {
		return year;
	}
	
	public WebElement getPurchase() {
		return purchase;
	}
	
	public void productselection()
	{
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		getProduct().click();
		getAddtocart().click();	
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Alert a = driver.switchTo().alert();
		a.accept();

	}
	
	public void checkout(String name, String country, String city, String card, String 
			month, String year)
	{
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		getCart().click();
		getPlaceorder().click();
		
		getName().sendKeys(name);
		getCountry().sendKeys(country);
		getCity().sendKeys(city);
		getCard().sendKeys(card);
		getMonth().sendKeys(month);
		getYear().sendKeys(year);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		getPurchase().click();
		
	}

}
