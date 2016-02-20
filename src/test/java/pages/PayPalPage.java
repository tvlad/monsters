package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PayPalPage {
	private static WebDriver driver;

	public PayPalPage(WebDriver _driver) {
		driver = _driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "cancel_return")
	public WebElement backFromPayment;

}
