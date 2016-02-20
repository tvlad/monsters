package Tests;


import java.awt.AWTException;
import java.util.Set;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Service.Help;
import Service.WebDrInit;

public class _07_case8 extends WebDrInit {
	/*
	 * Verify "login with Login/Password"
	 */

	
	@Test(groups = "mainPage")
	public void _16_T_LiveChat() throws InterruptedException, AWTException {
//		Help.mouseOver(headerPage.signInLink);
		Help.refreshPage();
		Help.waitForElement(20, homePage.liveChatButton).click();
		homePage.nameChat.sendKeys("tvlad");
		homePage.emailChat.sendKeys(WebDrInit.getEmail());
		
		String parentWindow = driver.getWindowHandle();
		
		homePage.submitChat.click();
				
		Set<String> allWindows = driver.getWindowHandles();
		for (String string : allWindows) {
			if (!string.equals(parentWindow)) {
				driver.switchTo().window(string);
				new WebDriverWait(driver, 15)
				.until(ExpectedConditions.urlMatches("http://chat.template-help.com/chat.jsp"));
				Assert.assertEquals(driver.getCurrentUrl(), 
						"http://chat.template-help.com/chat.jsp");
				Help.closeTab();
				driver.close();
				driver.switchTo().window(parentWindow);
				Thread.sleep(1000);
			}
		}
	}

}
