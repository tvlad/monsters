package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Service.Help;


public class CartPage {
	private static WebDriver driver;

	public CartPage(WebDriver _driver) {
		driver = _driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".template-number.js-dynamic-cart-data")
	public List<WebElement> templateId;
	
	@FindBy(css = ".template-price.js-total-price")
	public WebElement totalPrice;
	
	@FindBy(css = ".js-popup-cart-item.js-license.clearfix.js-license-default.js-license-regular")
	public List<WebElement> templatePrices;
	
	@FindBy(css = ".cart-summary.js-cart-summary .tm-icon.icon-cross")
	public List<WebElement> closeIcon;
	
	@FindBy(css = ".button.btn-big-height.btn-important")
	public WebElement goToShoppingButt;

	// -------------------------------------------------------------------------

	public void emptyCart() throws InterruptedException {
		HeaderPage headerPage = new HeaderPage(driver);
		if (headerPage.getCartQuantity() > 0){
			driver.get("https://secure.templatemonster.com/cart.php");
			int count = 0;
			for (WebElement el : closeIcon) {
				Help.mouseOver(templateId.get(count));
				el.click();	
				count += 1;
			}
		Help.waitForElement(10, goToShoppingButt).click();
//		driver.get(WebDrInit.baseUrl);
		Thread.sleep(2000);
		}
	}
	
	public void removeFirstItemFromCart() throws InterruptedException {

		Help.mouseOver(templateId.get(0));
		closeIcon.get(0).click();
		Thread.sleep(1500);
	}
	
	
	public int getTotalPrice (){
		return Integer.parseInt(totalPrice.getAttribute("data-price"));
	}
	
	public int getTemplatePrice (WebElement el){
		return Integer.parseInt(el.getAttribute("data-price"));
	}
}
