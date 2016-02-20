package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Service.Help;
import Service.WebDrInit;

public class CheckoutPage {

	private static WebDriver driver;

	public CheckoutPage(WebDriver _driver) {
		driver = _driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "label[for='new-customer-radio']")
	public WebElement newCustomerRadioButt;
	
	@FindBy(css = ".button.btn-important.btn-big-height.tm-icon.right-arrow-circle-icon.js-new-customer-link")
	public WebElement asAGuestButt;
		
	@FindBy(css = "label[for='returning-customer-radio']")
	public WebElement returningCustomerRadioButt;

	@FindBy(id = "checkout-signin-form-submit")
	public WebElement signInSubmitButt;
	
	@FindBy(id = "checkout-signin-form-email")
	public WebElement emailFieldForSignIn;
	
	@FindBy(id = "checkout-signin-form-password")
	public WebElement passwordFieldForSignIn;

	@FindBy(id = "billinginfo-form-fullname")
	public WebElement fullNameField;
	
	@FindBy(id = "freeinfo-form-name")
	public WebElement fullNameFieldForDelivery;

	@FindBy(id = "billinginfo-form-email")
	public WebElement emailField;
	
	@FindBy(id = "freeinfo-form-email")
	public WebElement emailForDelivery;

	@FindBy(id = "billinginfo-form-address")
	public WebElement addressField;

	@FindBy(id = "billinginfo-form-cityname")
	public WebElement citynameField;

	@FindBy(id = "billinginfo-form-postalcode")
	public WebElement postalcodeField;

	@FindBy(id = "billinginfo-form-phone")
	public WebElement phoneField;
	
	@FindBy(id = "freeinfo-form-contactphone")
	public WebElement phoneFieldForDelivery;
	
	@FindBy(id = "freeinfo-form-submit")
	public WebElement submitForDeliveryButt;
	
	@FindBy(css = ".item.panel")
	public List<WebElement> paymentRadio;
	
	
	@FindBy(id = "billinginfo-form-submit")
	public WebElement continuePaymentButt;

	@FindBy(css = ".method-col2>img[alt='PayPal']")
	public WebElement payPalRadioButt;
	
	@FindBy(css = ".method-col2>img[alt='TransactPro']")
	public WebElement payByCartRadioButt;

	@FindBy(css = ".item.panel.selected a")
	public WebElement buyNow;
	
	@FindBy(css = ".block-heading>p")
	public WebElement templateDeliveredText;
	
	@FindBy(css = ".order-status-approved")
	public WebElement templateDeliveredHeader;
	
	@FindBy(css = ".breadcrumb > li.js-step-link")
	public List<WebElement> breadcrumbItems;

	
	
	public void buyTemplate(String userStatus,
			String paymentMethod) throws InterruptedException {
		
		TemplatePage templatePage = new TemplatePage(driver);
		templatePage.addTemplateToCart(0);
		
		Help.waitForElement(15, templatePage.checkoutNowButt).click();
		
		if (userStatus.equals("registeredUser")){
			
			authorizeAsRegistered();
		}
		if (userStatus.equals("newUser")){
			asAGuestButt.click();
			fullNameField.sendKeys("Test Test");
			emailField.sendKeys(Help.randomEmail());
			addressField.sendKeys("25, Street st.");
			citynameField.sendKeys("Lviv");
			postalcodeField.sendKeys("79000");
			phoneField.sendKeys("0674567890");
			continuePaymentButt.click();
			new WebDriverWait(driver, 15)
			.until(ExpectedConditions.urlMatches("https://secure.templatemonster.com/checkout/step2.html"));
		}
		
		makePayment(paymentMethod);
		
	}
	
	public void authorizeAsRegistered(){
		returningCustomerRadioButt.click();
		emailFieldForSignIn.sendKeys(WebDrInit.getEmail());
		passwordFieldForSignIn.sendKeys(WebDrInit.getPassword());
		signInSubmitButt.click();
		new WebDriverWait(driver, 15)
		.until(ExpectedConditions.urlMatches("https://secure.templatemonster.com/checkout/step3.html"));
	}
	
	public void newCustomerForDelivery(String email){
		newCustomerRadioButt.click();
		asAGuestButt.click();
		fullNameFieldForDelivery.sendKeys("Test Test");
		emailForDelivery.sendKeys(email);
		phoneFieldForDelivery.sendKeys("0674567890");
		Help.waitForElement(15, submitForDeliveryButt).click();
	}
	
	
	
	public void makePayment(String paymentMethod) throws InterruptedException{
		
		switch (paymentMethod) {
		case "PayPal":
			
			break;
		case "PayByCard":
			Help.waitForElement(15, payByCartRadioButt).click();
			break;
		default:
			
		}
		
		Help.waitForElement(15, buyNow).click();
//		Thread.sleep(3000);
	}

}
