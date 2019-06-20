package pages;

import java.net.MalformedURLException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CookiePage extends BasePage {

	public CookiePage(WebDriver driver) throws MalformedURLException {
		super(driver);

	}

	@FindBy(xpath = "//*[@class='col-xs-12 cookie-notice animated']")
	private WebElement cookieForm;

	@FindBy(xpath = "(//*[@class='col-xs-10 col-xs-offset-1'])[1]")
	private WebElement cookieText;

	@FindBy(xpath = "//*[contains(text(),'Mehr Info')]")
	private WebElement infoButton;

	@FindBy(xpath = "//*[@class='icon-acr_plus_light_aligned']")
	private WebElement plusIcon;

	@FindBy(xpath = "//*[@class='accept-cookie']")
	private WebElement okButton;

	@FindBy(xpath = "//*[@class='icon-acr_close_aligned']")
	private WebElement closeButton;

	public WebElement getCookieText() {
		return this.cookieText;
	}

	public WebElement getCookieForm() {
		return this.cookieForm;
	}

	public WebElement getInfoButton() {
		return this.cookieForm;
	}

	public WebElement getPlusIcon() {
		return this.plusIcon;
	}

	public WebElement getOKButton() {
		return this.okButton;
	}

	public WebElement getCloseButton() {
		return this.closeButton;
	}

}
