package com.my.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
		LoginPage loginPage;
	}
	
	
	@FindBy(xpath = "//*[contains(text(),'Log in')]")
	WebElement loginLink;
	
	@FindBy(id = "Email")
	WebElement emailField;
	
	@FindBy(id = "Password")
	WebElement passWord;
	
	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[3]/input")
	WebElement loginBtn;
	
	
	public void LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void loginButton() {
		loginLink.click();
		Assert.assertTrue(driver.getCurrentUrl().equals("https://demo.nopcommerce.com/login"));
	}
	
	public void loginFields(WebDriver driver, String EL, String PF) {
		try {
		emailField.sendKeys(EL);
		Thread.sleep(2000);
		passWord.sendKeys(PF);
		Thread.sleep(2000);
		loginBtn.click();
		Thread.sleep(2000);
		driver.navigate().to("https://demo.nopcommerce.com/");
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	

}
