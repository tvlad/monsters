package Tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import Service.WebDrInit;


public class _03_case04 extends WebDrInit {
	/*
	 * 1. Добавить в корзину платный шаблони перейти на чекаут 
	 * 2. На степе 1 чекаута авторизоваться существующим пользователем 
	 * 3. На степе 3 чекаута выполнить покупку через TransactPro (Pay by CARD)
	 */

	
	@Test(groups = "main")
	public void _04_T_newCustomerPayment() throws InterruptedException {
		
		headerPage.signOut();
		checkoutPage.buyTemplate("registeredUser", "PayByCard");
		(new WebDriverWait(driver, 15)).until(ExpectedConditions.urlContains("stpayments.net")); // needed for the test stability
		System.out.println(driver.getCurrentUrl());
		Assert.assertTrue(driver.getCurrentUrl().contains("stpayments.net"), 
				"Something gone wrong! ");
	}

}
