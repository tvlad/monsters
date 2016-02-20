package Tests;

import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.annotations.Test;

import Service.WebDrInit;


public class _01_case01and02 extends WebDrInit {
	/*
	 * Verify "login with Login/Password"
	 */
	@Test(groups = "mainPage")
	public void _00_T_Login() throws InterruptedException {
		headerPage.signIn(Email, Password);
		Cookie wac = driver.manage().getCookieNamed("wac");
		// Set<Cookie> allCookie = driver.manage().getCookies();
		Assert.assertTrue(wac.toString().contains("wac=1"), 
				"There is no proper sign about login in the cookies.");

	}
	
	@Test(groups = "mainPage")
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
	
	
}
