package Tests;

import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.annotations.Test;

import Service.Help;
import Service.WebDrInit;


public class _00_Pro extends WebDrInit {
	/*
	 * Verify "login with Login/Password"
	 */
//	@Test(groups = "mainPage")
	public void _00_T_Login() throws InterruptedException {
		headerPage.signIn(Email, Password);
		Cookie wac = driver.manage().getCookieNamed("wac");
		// Set<Cookie> allCookie = driver.manage().getCookies();
		Assert.assertTrue(wac.toString().contains("wac=1"), 
				"There is no proper sign about login in the cookies.");

	}
	
//	@Test(groups = "mainPage")
	public void _01_T_Search() throws InterruptedException {
		String templateNumber = homePage.getTemplateNumber();
		headerPage.searchField.sendKeys(templateNumber);
		headerPage.searchButt.click();
		System.out.println(templateNumber);
		Assert.assertTrue(driver.getCurrentUrl().toString().contains(templateNumber.substring(1)), 
				"There is no template with such number");
	}
	
//	@Test(groups = "mainPage")
	public void _02_T_Search() throws InterruptedException {
		
		Assert.assertEquals(headerPage.searchField.getText(), "", 
				"The serch field doesn't eraised.");
	}
	
	@Test(groups = "mainPage")
	public void _03_T_newCustomerPayment() throws InterruptedException {
		
		headerPage.signOut();
		homePage.templateNumbers.get(0).click();
		templatePage.addToCartButt.click();
		Help.waitForElement(15, templatePage.checkoutNowButt).click();
		
		checkoutPage.newCustomerRadioButt.click();
		checkoutPage.asAGuestButt.click();
		checkoutPage.fullNameField.sendKeys("Test Test");
		checkoutPage.emailField.sendKeys(Help.randomEmail());
		checkoutPage.addressField.sendKeys("25, Street st.");
		checkoutPage.citynameField.sendKeys("Lviv");
		checkoutPage.postalcodeField.sendKeys("79000");
		checkoutPage.phoneField.sendKeys("0674567890");

		Help.waitForElement(15, checkoutPage.continuePaymentButt).click();
		
//		Help.waitForElement(10, checkoutPage.buyNow).click();

		Help.waitForElement(10, payPalPage.backFromPayment);
		System.out.println(driver.getCurrentUrl());
		Assert.assertTrue(driver.getCurrentUrl().contains("paypal.com"), "Something gone wrong");
		driver.get(baseUrl);
		
	}

}
