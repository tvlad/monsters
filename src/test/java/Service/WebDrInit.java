package Service;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import pages.CartPage;
import pages.CheckoutPage;
import pages.HeaderPage;
import pages.HomePage;
import pages.PayPalPage;
import pages.TemplatePage;


public class WebDrInit {
	
	/*
	 * Class of webdriver initialization.
	 * 
	 */
	
	protected static WebDriver driver; 
	public static String baseUrl;
	public WebDriverWait wait;
	private static String browser = null; // firefox // Variable to determine the browser.
	
	protected static String Email;
	protected static String Password;
	protected static String fileName = "";
	
	public HeaderPage headerPage;
	public HomePage homePage;
	public TemplatePage templatePage;
	public CartPage cartPage;
	public CheckoutPage checkoutPage;
	public PayPalPage payPalPage;
	
		
	@BeforeClass
	public void setUp() throws IOException {
		
		
		browser = setBrowser();
				
		switch (browser) {
		case "ie":
			driver = new InternetExplorerDriver();
			break;
		case "chrome":
			driver = new ChromeDriver();
			break;
		default:
			driver = new FirefoxDriver();
		}
		
		Email =  DataProv.prop("Email");
		Password = DataProv.prop("Password");
		baseUrl = DataProv.prop("baseUrl");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 10);
		
		driver.get(baseUrl);
		driver.manage().window().maximize();
		
		headerPage = new HeaderPage(driver);
		homePage = new HomePage(driver);
		templatePage = new TemplatePage(driver);
		cartPage = new CartPage(driver);
		checkoutPage = new CheckoutPage(driver);
		payPalPage = new PayPalPage(driver);
		
		driver.manage().deleteAllCookies();
		
		headerPage.geoPositionDisButt.click();
//		headerPage.closeBanner();
		
//		driver.manage().deleteAllCookies();
	
	}
		
	
	@AfterClass
	public void tearDown() throws Exception {
//		driver.close();
//		driver.quit();
		
	}
	
	public static String getBrowser() {
		return browser;
	}
	

	public static String setBrowser() {
		browser = DataProv.prop("browser");
		return browser;
	}
	
	
	public static WebDriver getDriver() {
		WebDriver driver_ = driver;
		return driver_;
	}
	
	public static String getEmail() {
		String email_ = Email;
		return email_;
	}
	
	public static String getPassword() {
		String password_ = Password;
		return password_;
	}
	
	public static String getBaseUrl() {
		String baseUrl_ = baseUrl;
		return baseUrl_;
	}
	
//	----------------------------------------------------


}
