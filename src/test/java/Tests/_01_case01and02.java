package Tests;

import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.annotations.Test;

import Service.WebDrInit;


public class _01_case01and02 extends WebDrInit {
	/*
	 * 1. Открыть форму Sign in в хедере 
	 * 2. Заполнить поля формы данными существующего пользователя 
	 * 3. Нажать Enter/кнопку Sign in
	 */
	@Test(groups = "main")
	public void _00_T_Login() throws InterruptedException {
		headerPage.signIn(Email, Password);
		Cookie wac = driver.manage().getCookieNamed("wac");
		// Set<Cookie> allCookie = driver.manage().getCookies();
		Assert.assertTrue(wac.toString().contains("wac=1"), 
				"There is no proper sign about login in the cookies.");

	}
	
	/*
	 * 1. Зайти на проект (индексная страница) 
	 * 2. В поле поиска ввести номер шаблона и нажать Enter/кнопку поиска
	 */
	@Test(groups = "main")
	public void _01_T_Search() throws InterruptedException {
		String templateNumber = homePage.getTemplateNumber();
		headerPage.searchField.sendKeys(templateNumber);
		headerPage.searchButt.click();
		System.out.println(templateNumber);
		Assert.assertTrue(driver.getCurrentUrl().toString().contains(templateNumber.substring(1)), 
				"There is no template with such number");
	}
	
	@Test(groups = "main")
	public void _02_T_Search() throws InterruptedException {
		
		Assert.assertEquals(headerPage.searchField.getText(), "", 
				"The serch field doesn't eraised.");
	}
	
	
}
