package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Service.WebDrInit;

public class _09_case10 extends WebDrInit {
	/*
	 * 1. Добавить в корзину платный шаблон и перейти на чекаут 
	 * 2. На степе 1 чекаута выбрать “I’m returning customer” 
	 * 3. Ввести невалидный email (мин. 10 вариантов) 
	 * 4. Установить фокус в поле ввода пароля
	 */

	@Test(groups = "main")
	public void _18_T_EmailTest() throws InterruptedException {
		headerPage.signOut();
		templatePage.addTemplateToCart(0);
		templatePage.checkoutNowButt.click();
		checkoutPage.returningCustomerRadioButt.click();
		fillOutEmail(" @ . ");
	}
	
	@Test(groups = "main")
	public void _19_T_EmailTest() throws InterruptedException {
		fillOutEmail("tvladgmail.com");
	}
	
	@Test(groups = "main")
	public void _20_T_EmailTest() throws InterruptedException {
		fillOutEmail("tvlad@gmailcom");
	}
	
	@Test(groups = "main")
	public void _21_T_EmailTest() throws InterruptedException {
		fillOutEmail("tvladgmailcom");
	}
	
	@Test(groups = "main")
	public void _22_T_EmailTest() throws InterruptedException {
		fillOutEmail("tvlad@ce.mintemail.com");
	}
	
	@Test(groups = "main")
	public void _23_T_EmailTest() throws InterruptedException {
		fillOutEmail("tvlad/@ce.mintemail.com");
	}
	
	@Test(groups = "main")
	public void _24_T_EmailTest() throws InterruptedException {
		fillOutEmail("tvlad@mintemail.");
	}
	
	@Test(groups = "main")
	public void _25_T_EmailTest() throws InterruptedException {
		fillOutEmail("tvlad{@mintemail.com");
	}
	
	@Test(groups = "main")
	public void _26_T_EmailTest() throws InterruptedException {
		fillOutEmail("tvlad @mintemail.com");
	}
	
	@Test(groups = "main")
	public void _27_T_EmailTest() throws InterruptedException {
		fillOutEmail("tvlad@ mintemail.com");
	}
	
	private void fillOutEmail(String email){
		checkoutPage.emailFieldForSignIn.clear();
		checkoutPage.emailFieldForSignIn.sendKeys(email);
		checkoutPage.passwordFieldForSignIn.click();
		checkoutPage.signInSubmitButt.click();
		Assert.assertTrue(checkoutPage.emailWarning.isDisplayed());
	}
}
