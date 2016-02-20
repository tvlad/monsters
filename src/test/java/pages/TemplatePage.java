package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Service.Help;

public class TemplatePage {

	private static WebDriver driver;

	public TemplatePage(WebDriver _driver) {
		driver = _driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#collapse0 .add-to-cart button")
	public WebElement addToCartButt;
	
	@FindBy(css = ".checkout-button button")
	public WebElement checkoutNowButt;

	@FindBy(css = ".preview-heading")
	public WebElement templateName;

	@FindBy(css = "strong[itemprop='productID']")
	public WebElement templateId;

	@FindBy(css = ".js-fake-social-btn.fake-social-btn.button.btn-main.btn-big-height.btn-full-width")
	public WebElement shareAndDownloadButt;

	@FindBy(css = ".onp-sl-feature-overlay")
	public WebElement shareOnTwitterButt;

	@FindBy(css = ".button.btn-important.btn-full-width.tm-icon.download-icon.js-button-download-sample.onp-sociallocker-content")
	public WebElement downloadTemplateButt;
	
	@FindBy(css = ".key-feature>img")
	public List<WebElement> pictures;
	
	
	

	public String addTemplateToCart(int i) {

		HomePage homePage = new HomePage(driver);
		homePage.templateNumbers.get(i).click();
		String templateIdS = templateId.getText();
		addToCartButt.click();
		Help.waitForElement(15, checkoutNowButt);
		return templateIdS;
	}
	
	

}
