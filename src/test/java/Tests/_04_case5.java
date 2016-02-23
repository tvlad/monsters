package Tests;


import java.awt.AWTException;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Test;
import Service.Help;
import Service.WebDrInit;


public class _04_case5 extends WebDrInit {
	
	/*
	 * Предусловие: корзина пустая 
	 * 1. Незалогиненным пользователем перейти на страницу большого превью фри темплейт шаблона (51682) 
	 * 2. В блоке Download the Free Template нажать кнопку Download Template 
	 * 3. Оставить выбранным пункт I am a new customer и нажать Continue as a Guest 
	 * 4. Заполнить поля формы User Details корректными данными и нажать кнопку Download Sample
	 */

	private String tmpId = "51682";
	private String email = Help.randomEmail();
	
	@Test(groups = "main")
	public void _05_T_openTemplate() throws InterruptedException {
		cartPage.emptyCart(); 
		headerPage.searchField.sendKeys(tmpId);
		headerPage.searchButt.click();
		Assert.assertEquals(templatePage.templateId.getText(), 
				tmpId, "User can't open expected template! ");
	}
	
	@Test(groups = "main")
	public void _06_T_downloadTemplateClick() throws InterruptedException, AWTException {
		Help.mouseOver(templatePage.shareAndDownloadButt);
		String parentWindow = driver.getWindowHandle();
		templatePage.shareOnTwitterButt.click();
		Thread.sleep(1000);
		Set<String> allWindows = driver.getWindowHandles();
		for (String string : allWindows) {
			if (!string.equals(parentWindow)) {
				driver.switchTo().window(string);
				Help.closeTab();
				driver.close();
				driver.switchTo().window(parentWindow);
				Thread.sleep(1000);
			}
		}
		
		Help.waitForElement(15, templatePage.downloadTemplateButt).click();
		checkoutPage.newCustomerForDelivery(email);
		System.out.println("font-weight - " + checkoutPage.breadcrumbItems.get(3).getCssValue("font-weight"));
		Assert.assertEquals(checkoutPage.breadcrumbItems.get(3).getCssValue("font-weight"), 
				"700", "The last item in breadcrumb isn't BOLD. ");
		
	}
	
	@Test(groups = "main")
	public void _07_T_assertDelConfirm() throws InterruptedException, AWTException {
		Assert.assertTrue(checkoutPage.templateDeliveredText.getText().contains(email));
	}
	
	

}
