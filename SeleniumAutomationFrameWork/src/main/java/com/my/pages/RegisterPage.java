package com.my.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.openqa.selenium.support.ui.Select;

import okhttp3.internal.connection.RouteSelector.Selection;

public class RegisterPage extends BasePage{
	
	public RegisterPage(WebDriver driver) {
		super(driver);
		
		RegisterPage registerPage;
		Actions actions = new Actions(driver);
		
		
	}
	
	@FindBy(id = "gender-male")
	WebElement maleCheckbox;
	
	
	@FindBy(id = "FirstName")
	WebElement firstName;
	
	@FindBy(id = "LastName")
	WebElement lastName;
	
//	@FindBy(className = "date-picker-wrapper")
//	WebElement daySelect;
//	
//	@FindBy(name = "DateOfBirthMonth")
//	WebElement monthSelect;
//	
//	@FindBy(name = "DateOfBirthYear")
//	WebElement yearSelect;
	
	@FindBy(xpath = "//input[@name='Email']")
	WebElement emailField;
	
	@FindBy(xpath = "//input[@name='Company']")
	WebElement companyField;
	
	@FindBy(xpath = "//input[@name='Password']")
	WebElement passwordField;
	
	@FindBy(xpath = "//input[@name='ConfirmPassword']")
	WebElement repassField;
	
	@FindBy(xpath = "//input[@name='register-button']")
	WebElement registerBtn;
	
	public void RegisterPage (){
		PageFactory.initElements(driver, this);
	}
	
	
	public String validateRegisterPageTitle() {
		return driver.getTitle();
	}
	
	
	public void checkMaleBtn() {
		maleCheckbox.click();
	}
	
	//time: pausing time
	public void checkMaleBtn(int time) {
		
		try {
			Thread.sleep(time);
			maleCheckbox.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	public void personalInfo(String FN,String LN, String EM, String CF, String PSW1, String PSW2, String RB,int time) {
		
		try {
			Thread.sleep(time);
			firstName.sendKeys(FN);
			Thread.sleep(time);
			lastName.sendKeys(LN);
			Thread.sleep(time);
			this.pickDAY(2000);
			emailField.sendKeys(EM);
			Thread.sleep(time);
			companyField.sendKeys(CF);
			Thread.sleep(time);
			passwordField.sendKeys(PSW1);
			Thread.sleep(time);
			repassField.sendKeys(PSW2);
			Thread.sleep(time);
			registerBtn.click();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	public void pickDAY (int time) {
		try {
		Select select1 = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthDay']")));
		select1.selectByIndex(10);
		Thread.sleep(time);
		Select select2 = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']")));
		select2.selectByValue("4");
		Thread.sleep(time);
		Select select3 = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthYear']")));
		select3.selectByValue("1990");
		Thread.sleep(time);
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
