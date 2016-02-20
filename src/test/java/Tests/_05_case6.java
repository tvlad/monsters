package Tests;

import java.awt.AWTException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Service.Help;
import Service.WebDrInit;


public class _05_case6 extends WebDrInit {
	/*
	 * Verify "login with Login/Password"
	 */

	private int totalPrice = 0;
	private List<String> cartListById = new ArrayList<String>();
	private List<String> actualIds = new ArrayList<String>();

	@Test(groups = "mainPage")
	public void _08_T_addToCartForLoginUser() throws InterruptedException, AWTException {

		headerPage.signIn(Email, Password);
		cartPage.emptyCart();
		totalPrice = Integer.parseInt(homePage.templatePrice.get(0).getAttribute("data-purchase_price"));
		String a = templatePage.addTemplateToCart(0);
		System.out.println("a - " + a);
		cartListById.add(a);
		driver.get(baseUrl);

		headerPage.signOut();
		driver.manage().deleteAllCookies();
		Help.refreshPage();

	}

	@Test(groups = "mainPage")
	public void _09_T_addToCartForNotLoginUser() throws InterruptedException {
		Thread.sleep(1000);
		headerPage.closeBanner();
		totalPrice = totalPrice + 
				Integer.parseInt(homePage.templatePrice.get(1).getAttribute("data-purchase_price"));
		String a = templatePage.addTemplateToCart(1);
		cartListById.add(a);
		driver.get(baseUrl);
		headerPage.signIn(Email, Password);
		System.out.println("total - " + totalPrice);
		Assert.assertEquals("2", headerPage.cartQuantity.getText());
	}

	@Test(groups = "mainPage")
	public void _10_T_assertTotalPrice() throws InterruptedException {

		Help.waitForElement(10, headerPage.cartIcon).click();
		Assert.assertEquals(totalPrice, cartPage.getTotalPrice(),
				"The order total price doesn't equal to the expected! ");
	}
	

	@Test(groups = "mainPage")
	public void _11_T_assertIds() throws InterruptedException {

		for (WebElement el : cartPage.templateId) {
			actualIds.add(el.getText().substring(1));
		}
		Collections.sort(cartListById);
		Collections.sort(actualIds);
		Assert.assertEquals(cartListById, actualIds,
				"The cart contains wrong ids of templates! ");
	}

}
