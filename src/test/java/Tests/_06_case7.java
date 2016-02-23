package Tests;

import java.awt.AWTException;


import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Service.Help;
import Service.WebDrInit;

public class _06_case7 extends WebDrInit {
	/*
	 * Предусловие: в корзине пользователя хранятся продукты 
	 * 1. Незалогиненным пользователем положить в корзину продукты 
	 * 2. Авторизоваться на степе 1 чекаута 
	 * 3. Перейти на страницу шоппинг карты и удалить некоторые продукты
	 * из корзины (нажать крестик возле выбранного продукта)
	 */


	private int sumAllBefor = 0;
	private int sumAllAfter = 0;
	private int deletedPrice = 0;
	
	@Test(groups = "main")
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

	@Test(groups = "main")
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
	
	@Test(groups = "main")
	public void _14_T_() throws InterruptedException {
		Assert.assertNotEquals(sumAllBefor, sumAllAfter);
	}
	
	@Test(groups = "main")
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
