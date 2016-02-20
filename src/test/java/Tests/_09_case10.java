package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Service.WebDrInit;

public class _09_case10 extends WebDrInit {
	/*
	 * Verify "login with Login/Password"
	 */

	@Test(groups = "mainPage")
	public void _18_T_EmailTest() throws InterruptedException {
		headerPage.signOut();
		templatePage.addTemplateToCart(0);
		templatePage.checkoutNowButt.click();
		checkoutPage.returningCustomerRadioButt.click();
		checkoutPage.emailFieldForSignIn.clear();
		checkoutPage.emailFieldForSignIn.sendKeys(" @ . ");
		checkoutPage.passwordFieldForSignIn.click();
		checkoutPage.signInSubmitButt.click();
		Assert.assertTrue(checkoutPage.emailWarning.isDisplayed());
	}
	
	@Test(groups = "mainPage")
	public void _19_T_EmailTest() throws InterruptedException {
		checkoutPage.emailFieldForSignIn.clear();
		checkoutPage.emailFieldForSignIn.sendKeys("tvladgmail.com");
		checkoutPage.passwordFieldForSignIn.click();
		checkoutPage.signInSubmitButt.click();
		Assert.assertTrue(checkoutPage.emailWarning.isDisplayed());
	}
	
	@Test(groups = "mainPage")
	public void _20_T_EmailTest() throws InterruptedException {
		checkoutPage.emailFieldForSignIn.clear();
		checkoutPage.emailFieldForSignIn.sendKeys("tvlad@gmailcom");
		checkoutPage.passwordFieldForSignIn.click();
		checkoutPage.signInSubmitButt.click();
		Assert.assertTrue(checkoutPage.emailWarning.isDisplayed());
	}
	
	@Test(groups = "mainPage")
	public void _21_T_EmailTest() throws InterruptedException {
		checkoutPage.emailFieldForSignIn.clear();
		checkoutPage.emailFieldForSignIn.sendKeys("tvladgmailcom");
		checkoutPage.passwordFieldForSignIn.click();
		checkoutPage.signInSubmitButt.click();
		Assert.assertTrue(checkoutPage.emailWarning.isDisplayed());
	}
	
	@Test(groups = "mainPage")
	public void _22_T_EmailTest() throws InterruptedException {
		checkoutPage.emailFieldForSignIn.clear();
		checkoutPage.emailFieldForSignIn.sendKeys("tvlad@ce.mintemail.com");
		checkoutPage.passwordFieldForSignIn.click();
		checkoutPage.signInSubmitButt.click();
		Assert.assertTrue(checkoutPage.emailWarning.isDisplayed());
	}
	
	@Test(groups = "mainPage")
	public void _23_T_EmailTest() throws InterruptedException {
		checkoutPage.emailFieldForSignIn.clear();
		checkoutPage.emailFieldForSignIn.sendKeys("tvlad/@ce.mintemail.com");
		checkoutPage.passwordFieldForSignIn.click();
		checkoutPage.signInSubmitButt.click();
		Assert.assertTrue(checkoutPage.emailWarning.isDisplayed());
	}
	
	@Test(groups = "mainPage")
	public void _24_T_EmailTest() throws InterruptedException {
		checkoutPage.emailFieldForSignIn.clear();
		checkoutPage.emailFieldForSignIn.sendKeys("tvlad@mintemail.");
		checkoutPage.passwordFieldForSignIn.click();
		checkoutPage.signInSubmitButt.click();
		Assert.assertTrue(checkoutPage.emailWarning.isDisplayed());
	}
	
	@Test(groups = "mainPage")
	public void _25_T_EmailTest() throws InterruptedException {
		checkoutPage.emailFieldForSignIn.clear();
		checkoutPage.emailFieldForSignIn.sendKeys("tvlad{@mintemail.com");
		checkoutPage.passwordFieldForSignIn.click();
		checkoutPage.signInSubmitButt.click();
		Assert.assertTrue(checkoutPage.emailWarning.isDisplayed());
	}
	
	@Test(groups = "mainPage")
	public void _26_T_EmailTest() throws InterruptedException {
		checkoutPage.emailFieldForSignIn.clear();
		checkoutPage.emailFieldForSignIn.sendKeys("tvlad @mintemail.com");
		checkoutPage.passwordFieldForSignIn.click();
		checkoutPage.signInSubmitButt.click();
		Assert.assertTrue(checkoutPage.emailWarning.isDisplayed());
	}
	
	@Test(groups = "mainPage")
	public void _27_T_EmailTest() throws InterruptedException {
		checkoutPage.emailFieldForSignIn.clear();
		checkoutPage.emailFieldForSignIn.sendKeys("tvlad@ mintemail.com");
		checkoutPage.passwordFieldForSignIn.click();
		checkoutPage.signInSubmitButt.click();
		Assert.assertTrue(checkoutPage.emailWarning.isDisplayed());
	}
}
