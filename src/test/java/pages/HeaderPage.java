package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import Service.Help;

public class HeaderPage {
	private static WebDriver driver;

	public HeaderPage(WebDriver _driver) {
		driver = _driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = ".sendpulse-prompt-btn.sendpulse-disallow-btn")
	public WebElement geoPositionDisButt;

	@FindBy(id = "signin-link")
	public WebElement signInLink;

	@FindBy(id = "signin-form-email")
	public WebElement emailField;

	@FindBy(id = "signin-form-password")
	public WebElement passwordField;

	@FindBy(id = "signin-form-submit")
	public WebElement signInButt;

	@FindBy(id = "signout-link")
	public WebElement signOutLink;
	
	@FindBy(css = ".js-typeahead2.keyword-search-field.js-placeholder.form-control.tt-input")
	public WebElement searchField;
	
	@FindBy(id = "searchFormSubmit")
	public WebElement searchButt;
	
	@FindBy(css = "#cart-count span")
	public WebElement cartQuantity;
	
	@FindBy(css = ".shop-cart.js-btn.link-click .icon-cart")
	public WebElement cartIcon;
	
	@FindBy(css = ".js-close-banner")
	public WebElement closeBanner;

	// ------------------------------------------------------------------------- 

	public void signIn(String email, String password) throws InterruptedException {
		signInLink.click();
		emailField.sendKeys(email);
		passwordField.sendKeys(password);
		signInButt.click();
		new WebDriverWait(driver, 20)
		.until(ExpectedConditions.elementToBeClickable(signOutLink));
	}
	
	public void signOut()  {
		if (Help.isElementPresent(signOutLink) == true) {
			signOutLink.click();
			@SuppressWarnings("unused")
			WebElement element = (new WebDriverWait(driver, 3)).
			until(ExpectedConditions.elementToBeClickable(signInLink));
			
		}
	}
	
	public int getCartQuantity()  {
		return Integer.parseInt(cartQuantity.getText());
	}
	
	public void closeBanner()  {
		if (Help.isElementPresent(closeBanner) == true) {
			closeBanner.click();			
		}
	}
}
