package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Checkoutpage {
	public WebDriver driver;
	public Checkoutpage(WebDriver driver)
	{
		this.driver = driver;
	}
	By cartBag = By.cssSelector("img[alt='Cart']");
	By checkOutButtn = By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]");
	By promoBtn = By.cssSelector(".promoBtn");
	By placeOrder = By.xpath("//button[contains(text(),'Place Order')]");

	public void CheckOutItem()
	{
		driver.findElement(cartBag).click();;
		driver.findElement(checkOutButtn).click();;
	}
	public boolean VerifyPromoBtn()
	{
		return driver.findElement(promoBtn).isDisplayed();
	}
	public boolean VerifyPlaceOrder()
	{
		return driver.findElement(placeOrder).isDisplayed();
	}
	
}
