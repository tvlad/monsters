package Tests;

import java.io.IOException;
import java.net.MalformedURLException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
//import org.testng.Assert;
import org.testng.annotations.Test;

import Service.Help;
import Service.WebDrInit;

public class _08_case9 extends WebDrInit {
	/*
	 * Verify "login with Login/Password"
	 */

	@Test(groups = "mainPage")
	public void _17_T_LazyLoad() throws InterruptedException, MalformedURLException, IOException {
		driver.get("http://www.templatemonster.com/wordpress-themes/52112.html");
		for (WebElement el : templatePage.pictures) {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", el);
			Thread.sleep(1000);
			int statusCode = Help.getResponseCode(el.getAttribute("src").trim());
			Assert.assertEquals(statusCode, 200);
			System.out.println("HTTP code # " + statusCode + " " + el.getAttribute("src"));
		}

	}
}
