package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import Service.Help;
import Service.WebDrInit;

public class _02_case03 extends WebDrInit {
	/*
	 * 1. Добавить в корзину платный шаблон и перейти на чекаут 
	 * 2. На степе 1 чекаута оставить выбранным пункт I am a new customer и нажать Continue as
	 * a Guest 
	 * 3. Заполнить корректными данными форму Billing Details 
	 * (емейл  новый - регистрация нового пользователя) и нажать Enter/кнопку Continue
	 * to Payment 
	 * 4. На степе 3 чекаута выполнить покупку с помощью PayPal
	 */

	@Test(groups = "main")
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
