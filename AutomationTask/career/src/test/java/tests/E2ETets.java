package tests;

import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import constants.Constants;
import driver.DriverInitiator;
import pages.CookiePage;
import pages.FooterPage;
import pages.BasePage;
import pages.ContactPage;

public class E2ETets {

	WebDriver driver = null;
	ContactPage contactPage = null;
	CookiePage cookiePage = null;
	BasePage basePage = null;
	DesiredCapabilities cap = null;
	FooterPage footerPage = null;

	@BeforeClass
	public void setUP() throws MalformedURLException {
		driver = DriverInitiator.getWebDriverInstance();
		basePage = new BasePage(driver);
		cookiePage = new CookiePage(driver);
		contactPage = new ContactPage(driver);
		driver.get(Constants.BASE_URL);
		driver.manage().timeouts().implicitlyWait(Constants.DEFAULT_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test(priority = 1, description = "Check cookie is displayed")
	public void checkCookieForm() {
		Assert.assertTrue(cookiePage.getCookieForm().isDisplayed());
	}

	@Test(priority = 2, description = "Check cookie message text")
	public void checkCookieFormText() {
		Assert.assertTrue(cookiePage.getCookieText().getText().contains(Constants.EXPECTED_COOKIE_TEXT));
	}

	@Test(priority = 3, description = "Check form buttons are displayed")
	public void checkCookieFormButtons() {
		Assert.assertTrue(cookiePage.getInfoButton().isDisplayed());
		Assert.assertTrue(cookiePage.getPlusIcon().isDisplayed());
		Assert.assertTrue(cookiePage.getOKButton().isDisplayed());
		Assert.assertTrue(cookiePage.getCloseButton().isDisplayed());
	}

	@Test(priority = 4, description = "Check user can accept cookies")
	public void acceptCookie() throws InterruptedException {
		cookiePage.getOKButton().click();
		Thread.sleep(5000);
	}

	@Test(priority = 5, description = "Check footer links are not broken")
	public void verifyFooterLinks() throws MalformedURLException {

		List<WebElement> links = driver.findElements(By.xpath("//*[@class='col-xs-12']//a"));
		basePage.checkURL(links);

	}

	@Test(priority = 6, description = "Check user can send an email")
	public void sendEmail() throws InterruptedException {
		basePage.getMainMenu().click();
		basePage.getSendEmailIcon().click();
		contactPage.getEmail().sendKeys(Constants.EMAIL);
		contactPage.getName().sendKeys(Constants.NAME);
		contactPage.getMessageInput().sendKeys(Constants.EMAIL_TEXT);
		contactPage.getPrivacyCheckbox().click();
		contactPage.getSubmitButton().click();
		Assert.assertTrue(contactPage.getSuccessMassage().isDisplayed());
	}

	@AfterClass
	public void quit() {
		driver.quit();
	}
}
