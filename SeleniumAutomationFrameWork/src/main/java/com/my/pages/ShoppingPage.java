package com.my.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class ShoppingPage extends BasePage{
	
	public ShoppingPage(WebDriver driver) {
		super(driver);
		ShoppingPage shoppingPage;
		
	}

	@FindBy(id = "customerCurrency")
	WebElement selectCurrency;
	
	@FindBy(id = "checkout_attribute_1")
	WebElement giftWrap;
	
	@FindBy(id = "discountcouponcode")
	WebElement discountCode;
	
	@FindBy(id = "giftcardcouponcode")
	WebElement giftCode;
	
	@FindBy(id = "applydiscountcouponcode")
	WebElement discBTN;
	
	@FindBy(id = "applygiftcardcouponcode")
	WebElement giftBtn;
	
	@FindBy(id = "CountryId")
	WebElement selectCountry;
	
	@FindBy(id = "StateProvinceId")
	WebElement selectState;
	
	@FindBy(id = "ZipPostalCode")
	WebElement postCode;
	
	@FindBy(id = "estimate-shipping-button")
	WebElement estimateBtn;
	
	
	
	
	public void ShoppingPage() {
		PageFactory.initElements(driver, this);
		
	}
	
	public String validateShoppingPageTitle() {
		return driver.getTitle();
	}
	
	public void mouseOver() {
		try {
		
		WebElement electronicsLink = driver.findElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[3]/a"));
		Actions actions = new Actions(driver);
		actions.moveToElement(electronicsLink).build().perform();
		electronicsLink.sendKeys(Keys.DOWN);
		Thread.sleep(1000);
		electronicsLink.sendKeys(Keys.DOWN);
		Thread.sleep(1000);
		electronicsLink.sendKeys(Keys.DOWN);
		Thread.sleep(1000);
		electronicsLink.sendKeys(Keys.UP);
		Thread.sleep(1000);
		electronicsLink.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		actions.build().perform();
		Assert.assertTrue(driver.getCurrentUrl().equals("https://demo.nopcommerce.com/apparel"));
			
		Thread.sleep(5000);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void buyShoes() {
		try {
		driver.findElement(By.xpath("//a[@title='Show products in category Shoes']")).click();
		Thread.sleep(2000);
		Select sortBy = new Select(driver.findElement(By.id("products-orderby")));
		sortBy.selectByVisibleText("Price: Low to High");
		Thread.sleep(2000);
		
		driver.findElement(By.partialLinkText("adidas Consortium Campus 80s Running Shoes")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@value='Add to cart'][@class='button-1 add-to-cart-button']")).click();
		
		
		Thread.sleep(6000);
		driver.findElement(By.xpath("//span[@class='cart-label']")).click();
		
		
		
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void estimateItem(WebDriver driver, String DC, String GD, String PD) {
		try {
		new Select(selectCurrency).selectByVisibleText("US Dollar");
		Thread.sleep(2000);
		new Select(giftWrap).selectByValue("2");
		Thread.sleep(2000);
		discountCode.sendKeys(DC);
		giftCode.sendKeys(GD);
		Thread.sleep(2000);
		discBTN.click();
		Thread.sleep(2000);
		giftBtn.click();
		Thread.sleep(2000);
		new Select(selectCountry).selectByVisibleText("United States");
		Thread.sleep(2000);
		new Select(selectState).selectByVisibleText("California");
		Thread.sleep(2000);
		estimateBtn.click();
		postCode.sendKeys(PD);
		Thread.sleep(2000);
		driver.findElement(By.id("termsofservice")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("checkout")).click();
		
		
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
}
