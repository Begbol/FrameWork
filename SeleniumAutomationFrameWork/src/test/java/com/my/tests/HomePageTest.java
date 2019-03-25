package com.my.tests;

import org.testng.annotations.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.my.pages.BasePage;

import com.my.pages.HomePage;
import com.my.pages.LoginPage;
import com.my.pages.RegisterPage;
import com.my.pages.ShoppingPage;
import com.my.utils.BrowserUtil;

public class HomePageTest {
		
	WebDriver driver = BasePage.initializeMyBrowser();
	
	
	@BeforeTest
	public void beforeEachTestStart() {

		BrowserUtil.startBrowser(driver);
	
	}
	
	@AfterTest
	public void afterEachTestEnd() {
		try {
			
				
			Thread.sleep(3000);

			driver.close(); // close the browser
			driver.quit(); // kills/deletes the driver object

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@BeforeMethod
	public void beforeEachMethodStart() {

		System.out.println("I am staring a method");
	
	}
	
	@AfterMethod
	public void screenShot(ITestResult result){
		//using ITestResult.FAILURE is equals to result.getStatus then it enter into if condition
			if(ITestResult.FAILURE==result.getStatus()){
				try{
					// To create reference of TakesScreenshot
					TakesScreenshot screenshot=(TakesScreenshot)driver;
					// Call method to capture screenshot
					File src=screenshot.getScreenshotAs(OutputType.FILE);
					// Copy files to specific location 
					// result.getName() will return name of test case so that screenshot name will be same as test case name
					FileUtils.copyFile(src, new File("takenPhoto-"+result.getName()+".png"));
					
					System.out.println("Successfully captured a screenshot");
				}catch (Exception e){
					System.out.println("Exception while taking screenshot "+e.getMessage());
				} 
		}
		}
	
	
	@Test(priority = 1)
	public void homepageTest() {
		HomePage homePage = new HomePage(driver);
		homePage.navigateToRegister();
		
	}
	@Test(priority = 2)
	public void registerTest() {
		
		try {
			RegisterPage registerPage = new RegisterPage(driver);
			
			registerPage.checkMaleBtn(2000);
			
			registerPage.personalInfo("Begbol", "Oghuz", "begbolo@gmail.com", "Tester", "begbol900", "begbol900", null,2000);
			
			//registerPage.pickDAY(2000);
			
			
			driver.navigate().to("https://demo.nopcommerce.com/");
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	@Test(priority = 3)
	public void loginTest() {
		try {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginButton();
		Thread.sleep(2000);
		loginPage.loginFields(driver, "begbolo@gmail.com", "begbol900");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 4)
	public void selectFrame() {
		try {
		ShoppingPage shop = new ShoppingPage(driver);
		shop.mouseOver();
		Thread.sleep(2000);
		shop.buyShoes();
		
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		}
	
	@Test(priority = 5)

	public void calculate() {
		try {
		ShoppingPage shop2 = new ShoppingPage(driver);
		shop2.estimateItem(driver, "1234", "1234", "94583");
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
}
