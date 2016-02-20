package Tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import Service.WebDrInit;


public class _03_case04 extends WebDrInit {
	/*
	 * Verify "login with Login/Password"
	 */

	
	@Test(groups = "mainPage")
	public void _04_T_newCustomerPayment() throws InterruptedException {
		
		headerPage.signOut();
		checkoutPage.buyTemplate("registeredUser", "PayByCard");
		(new WebDriverWait(driver, 15)).until(ExpectedConditions.urlContains("stpayments.net")); // needed for the test stability
		System.out.println(driver.getCurrentUrl());
		Assert.assertTrue(driver.getCurrentUrl().contains("stpayments.net"), 
				"Something gone wrong! ");
	}

}
