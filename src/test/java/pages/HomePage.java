package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	private static WebDriver driver;

	public HomePage(WebDriver _driver) {
		driver = _driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".template-number")
	public List<WebElement> templateNumbers;

	@FindBy(css = ".template-price.js-template-price")
	public List<WebElement> templatePrice;

	@FindBy(css = ".block.live-chat.live-chat-out")
	public WebElement liveChatButton;
	
	@FindBy(id = "live-chat-form-name")
	public WebElement nameChat;
	
	@FindBy(id = "live-chat-form-email")
	public WebElement emailChat;
	
	@FindBy(id = "live-chat-form-submit")
	public WebElement submitChat;

	
	
//	---------------------------------------------------
	public String getTemplateNumber() {
		return templateNumbers.get(0).getText();
	}

}
