package ass3ExampleUsingOR_ANDTypeofXPath;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ChromWebDriver {
	public WebDriver driver;

	/**
	 * Set up browser settings and open the application
	 */

	@BeforeTest
	public void setUp() {
		// the path for open WebSite
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\lo0ol\\" + "Downloads\\Compressed\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();

		// Navigate to a WebSite
		driver.navigate().to("https://learnenglish.britishcouncil.org/user/register");

		// Maximize current window
		driver.manage().window().maximize();
	}

	/**
	 * Test to check Contact Us fields
	 * 
	 * @throws InterruptedException
	 */
	@Test
	public void LearnEnglishWebSite() throws InterruptedException {

		// wait until the pop-up modal window appears.
		// references :
		// https://stackoverflow.com/questions/17465136/selenium-webdriver-how-to-close-the-first-pop-up-window-and-go-to-the-actual-p
		// https://stackoverflow.com/questions/45183797/element-not-interactable-exception-in-selenium-web-automation
		// https://stackoverflow.com/questions/71761074/the-constructor-webdriverwaitchromedriver-int-is-undefined
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//span[@class='custom-page-popup-modal-close spb_close']")));

		// Delay execution for 3 seconds after find specific web element
		// I used it to I can see the result carefully and for a screenshot.
		Thread.sleep(3000);

		// close the pop-up modal window
		driver.findElement(By.xpath("//span[@class='custom-page-popup-modal-close spb_close']")).click();

		// --------------------------------------- First name or Surname Fields
		// to scroll down on a web page
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Define the web element to find it,
		// First examples for the OR type of XPath
		WebElement orXPathMethod1 = driver.findElement(By.xpath(
				"//input[@name='field_profile_givennames[0][value]' or @class='js-text-full text-full form-text required form-control']"));

		// scroll horizontally on a web page to a specific web element using Selenium
		js.executeScript("arguments[0].scrollIntoView();", orXPathMethod1);

		// Delay execution for 2 seconds after find specific web element
		// I used it to I can see the result carefully and for a screenshot.
		Thread.sleep(2000);

		// Enter Word
		orXPathMethod1.sendKeys("Mawaddah");

		// Delay execution for 2 seconds after find specific web element
		// I used it to I can see the result carefully and for a screenshot.
		Thread.sleep(2000);

		// --------------------------------------- Surname Field
		// Define the web element to find it,
		// Second examples for the AND type of XPath
		WebElement andXPathMethod1 = driver.findElement(By.xpath(
				"//input[@id='edit-field-profile-surname-0-value' and @class='js-text-full text-full form-text required form-control']"));

		// Enter Word
		andXPathMethod1.sendKeys("Hanbali");

		// Delay execution for 2 seconds after find specific web element
		// I used it to I can see the result carefully and for a screenshot.
		Thread.sleep(2000);

		// --------------------------------------- Place of residence Field
		// Define the web element to find it,
		// Third examples for the AND type of XPath
		WebElement andXPathMethod2 = driver
				.findElement(By.xpath("//select[@name='field_profile_country' and @id='edit-field-profile-country']"));

		// Enter Word
		andXPathMethod2.sendKeys("Saudi Arabia");

		// Delay execution for 2 seconds after find specific web element
		// I used it to I can see the result carefully and for a screenshot.
		Thread.sleep(2000);

		// --------------------------------------- Password or Confirm password Field
		// Define the web element to find it,
		// Fourth examples for the OR type of XPath
		WebElement orXPathMethod2 = driver
				.findElement(By.xpath("//input[@data-drupal-selector='edit-pass-pass1' or @name='pass[pass2]']"));

		// Enter Word
		orXPathMethod2.sendKeys("PasswordIsSecret");

		// Delay execution for 3 seconds after find specific web element
		// I used it to I can see the result carefully and for a screenshot.
		Thread.sleep(3000);

	}

	/**
	 * Tear down the setup after test completes
	 */
	@AfterTest
	public void terminateBrowser() {
		// Close the browser
		driver.quit();
	}
}
