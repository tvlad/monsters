package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import Service.Help;
import Service.WebDrInit;

public class _02_case03 extends WebDrInit {
	/*
	 * Verify "login with Login/Password"
	 */

	@Test(groups = "mainPage")
	public void _03_T_newCustomerPayment() throws InterruptedException {

		headerPage.signOut();
		checkoutPage.buyTemplate("newUser", "PayPal");
		Thread.sleep(2000);
		Help.waitForElement(10, payPalPage.backFromPayment);
		System.out.println(driver.getCurrentUrl());
		Assert.assertTrue(driver.getCurrentUrl().contains("paypal.com"), 
				"Something gone wrong! ");
		driver.get(baseUrl);
		
	}

}
