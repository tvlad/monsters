package Service;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class Help extends WebDrInit {
	// private static WebDriver driver;

	// Reading from a text file.
	public static List<String> textFromFile(String fileName) {
		List<String> list = new ArrayList<String>();
		File file = new File(fileName); // textMessLorem.txt
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String s = br.readLine();
			while (s != null) {
				list.add(s);
				s = br.readLine();
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}

	// Parsing strings by specified separators.
	public static String[] splitStr(String s, String _chr) {
		String[] splits = s.split("[" + _chr + "]+"); // "[-,. ]+"
		return splits;
	}

	public static String noBr(String str) {
		str = str.replace('\n', ' ');
		return str;
		//
	}

//	public static String randomEmail() {
//
//		String allowedChars = "abcdefghiklmnopqrstuvwxyz";
//		String randommail = "";
//		int num = (int) (Math.floor(Math.random() * (8 - 3)) + 3);
//
//		for (int i = 0; i < num; i++) {
//			int rnum = (int) Math.floor(Math.random() * allowedChars.length());
//			randommail = randommail + allowedChars.subSequence(rnum, rnum + 1);
//		}
//
//		randommail += "@ce.mintemail.com";
//		// System.out.println(randomstring);
//		return randommail;
//
//	}
	
	
	public static String randomEmail() {

		Random rnd = new Random();
		int val = rnd.nextInt(99999);
		String randommail = "rnd" + val + "@mintemail.com";
		return randommail;

	}

	public static String randomLogin() {

		String randomstring = "";
		String allowedChars1 = "bcdfghklmnpqrstvwxz";
		String allowedChars2 = "aeiouy";
		int num = (int) (Math.floor(Math.random() * (8 - 3)) + 3);

		for (int i = 0; i < num; i++) {
			if (i % 2 == 0) {
				int rnum2 = (int) Math
						.floor(Math.random() * allowedChars1.length());
				randomstring += allowedChars1.substring(rnum2, rnum2 + 1);
			}

			else {
				int rnum = (int) Math
						.floor(Math.random() * allowedChars2.length());
				randomstring += allowedChars2.substring(rnum, rnum + 1);
			}
		}
		randomstring = randomstring.toUpperCase().substring(0, 1)
				+ randomstring.substring(1);

		return randomstring;
	}

	public static String randomString() {
		String randomstring = "";
		int num = (int) (Math.floor(Math.random() * (30 - 10)) + 10);
		for (int i = 0; i < num; i++) {
			randomstring = randomstring + randomLogin() + " ";
		}
		randomstring = randomstring.toUpperCase().substring(0, 1)
				+ randomstring.substring(1).toLowerCase();
		randomstring = randomstring + ".";
		randomstring = randomstring.replace(" .", ".");
		return randomstring;
	}

	public static String randomParagraph() {
		String randomParagraph = "";
		int num = (int) (Math.floor(Math.random() * (6 - 2)) + 2);
		for (int i = 0; i < num; i++) {
			randomParagraph = randomParagraph + randomString() + " ";
		}
		return randomParagraph;
	}

	public static String randomText() {
		String randomText = "";
		int num = (int) (Math.floor(Math.random() * (5 - 1)) + 1);
		for (int i = 0; i < num; i++) {
			randomText = randomText + randomParagraph() + "\n";
		}
		return randomText;
	}

	public static boolean isElementPresent(WebElement el) {
		  return el.getSize().height > 0;
		}
	
	public static   WebElement waitForElement(int wait, WebElement el) {
		WebElement element = (new WebDriverWait(driver, wait)).
				until(ExpectedConditions.elementToBeClickable(el));
		return element;
	}
	

	public static void mouseClick(Point dfg)
			throws AWTException, InterruptedException {

		Robot robot = new Robot();
		robot.mouseMove(dfg.x, dfg.y + 10);
		robot.mousePress(InputEvent.BUTTON1_MASK);
		try {
			Thread.sleep(500);
		} catch (Exception e) {
		} // Click one second
		robot.mouseRelease(InputEvent.BUTTON1_MASK);

	}

	public static void refreshPage() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_F5);

	}

	public static void sendTab() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);

	}
	
	public static void closeTab() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL + KeyEvent.VK_W);

	}

	public static Date date() {
		Date date = new Date();
		return date;
	}

	public static void mouseOver(WebElement e) throws InterruptedException {

		Actions builder = new Actions(driver);
		Action move = builder.moveToElement(e).build();
		move.perform();
		Thread.sleep(500);
	}
	// ----------------------------------------------------------------

	
}
