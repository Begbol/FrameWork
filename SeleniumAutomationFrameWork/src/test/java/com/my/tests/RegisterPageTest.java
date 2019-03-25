package com.my.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.my.pages.BasePage;

import com.my.pages.RegisterPage;
import com.my.utils.BrowserUtil;

public class RegisterPageTest {
	
	WebDriver driver = BasePage.initializeMyBrowser();
	@BeforeTest
	public void beforeEachTestStart() {
		
		BrowserUtil.startBrowser(driver);
	
	}
	@AfterTest
	public void afterEachTestEnd() {
		try {
			
				
			Thread.sleep(3 * 1000);

			driver.close(); 
			driver.quit(); 

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void registerTest() {
		RegisterPage page = new RegisterPage(driver);
		page.checkMaleBtn();
		page.pickDAY(2000);
		page.personalInfo("Begbol", "Oghuz", "begbolo@gmail.com", "Tester", "begbol900", "begbol900", null,2000);
		driver.navigate().to("https://demo.nopcommerce.com/");
		
	}
	
	
	

}
