package com.my.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import bsh.This;

public class BasePage {

	protected static WebDriver driver;
	
	public BasePage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	public static WebDriver initializeMyBrowser() {
		System.out.print("initializing my browser");
		
		System.setProperty("webdriver.chrome.driver", "/Users/user/Downloads/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");

		return driver;
	}
	
}
