package com.my.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class HomePage extends BasePage{
	
	public HomePage (WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(id = "customerCurrency")
	WebElement currencyDropDown;
	
	@FindBy(linkText = "Register")
	WebElement registerLink;
	
	
	public void navigateToRegister() {
		try {
		new Select(currencyDropDown).selectByVisibleText("Euro");
		Thread.sleep(2000);
		registerLink.click();
		Thread.sleep(2000);
		Assert.assertTrue(driver.getCurrentUrl().equals("https://demo.nopcommerce.com/register"));
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	
	
}
