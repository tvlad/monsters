package Tests;

import java.awt.AWTException;


import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Service.Help;
import Service.WebDrInit;

public class _06_case7 extends WebDrInit {
	/*
	 * Verify "login with Login/Password"
	 */


	private int sumAllBefor = 0;
	private int sumAllAfter = 0;
	private int deletedPrice = 0;
	
	@Test(groups = "mainPage")
	public void _12_T_addToCartForLoginUser() throws InterruptedException, AWTException {

		headerPage.signIn(Email, Password);
		cartPage.emptyCart();
		templatePage.addTemplateToCart(0);
		driver.get(baseUrl);
		templatePage.addTemplateToCart(1);
		driver.get(baseUrl);
		headerPage.signOut();
		driver.manage().deleteAllCookies();
		Help.refreshPage();

	}

	@Test(groups = "mainPage")
	public void _13_T_addToCartAndThenAuthorized() throws InterruptedException, AWTException {
		Thread.sleep(1000);
		headerPage.closeBanner();
		
		templatePage.addTemplateToCart(2);
		Help.waitForElement(15, templatePage.checkoutNowButt).click();
		checkoutPage.authorizeAsRegistered();
		headerPage.cartIcon.click();
				
		sumAllBefor = sumAllItemsInCart();
		
		deletedPrice = cartPage.getTemplatePrice(cartPage.templatePrices.get(0));
		System.out.println("deletedPrice - " + deletedPrice);
		
		cartPage.removeFirstItemFromCart();
		Help.refreshPage();
		Assert.assertEquals(cartPage.templatePrices.size(), 2);
		
		sumAllAfter = sumAllItemsInCart();
		
		System.out.println("sumAllBefor - " + sumAllBefor);
		System.out.println("sumAllAfter - " + sumAllAfter);
		
		
	}
	
	@Test(groups = "mainPage")
	public void _14_T_() throws InterruptedException {
		Assert.assertNotEquals(sumAllBefor, sumAllAfter);
	}
	
	@Test(groups = "mainPage")
	public void _15_T_() throws InterruptedException {
		Assert.assertEquals(deletedPrice, sumAllBefor - sumAllAfter);
	}


	
	private int sumAllItemsInCart(){
		int sumAll = 0;
		for (WebElement el : cartPage.templatePrices) {
			sumAll += cartPage.getTemplatePrice(el);
		}
		return sumAll;
	}
}
