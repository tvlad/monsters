package Tests;


import java.awt.AWTException;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Test;

import Service.Help;
import Service.WebDrInit;


public class _04_case5 extends WebDrInit {
	/*
	 * Verify "login with Login/Password"
	 */

	private String tmpId = "51682";
	private String email = Help.randomEmail();
	
	@Test(groups = "mainPage")
	public void _05_T_openTemplate() throws InterruptedException {
		cartPage.emptyCart(); 
		headerPage.searchField.sendKeys(tmpId);
		headerPage.searchButt.click();
		Assert.assertEquals(templatePage.templateId.getText(), 
				tmpId, "User can't open expected template! ");
	}
	
	@Test(groups = "mainPage")
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
	
	@Test(groups = "mainPage")
	public void _07_T_assertDelConfirm() throws InterruptedException, AWTException {
		Assert.assertTrue(checkoutPage.templateDeliveredText.getText().contains(email));
	}
	
	

}
