package com.my.pages;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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
	public void failed() {
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile, new File("/Users/user/git/FrameWork/SeleniumAutomationFrameWork/screenshots"));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
}
