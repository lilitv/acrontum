package pages;

import java.net.MalformedURLException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactPage extends BasePage {

	public ContactPage(WebDriver driver) throws MalformedURLException {
		super(driver);
	}

	@FindBy(xpath = "//*[@name='contact[name]']")
	private WebElement name;

	@FindBy(xpath = "//*[@name='contact[email]']")
	private WebElement email;

	@FindBy(xpath = "//*[@name='contact[dataPrivacy]']")
	private WebElement privacyCheckbox;

	@FindBy(xpath = "//*[@type='submit']")
	private WebElement submitButton;

	@FindBy(id = "message")
	private WebElement messageInput;

	@FindBy(xpath = "//div[contains(text(),'Email successfully sent')]")
	private WebElement successMessage;

	public WebElement getName() {
		return this.name;
	}

	public WebElement getEmail() {
		return this.email;
	}

	public WebElement getPrivacyCheckbox() {
		return this.privacyCheckbox;
	}

	public WebElement getSubmitButton() {
		return this.submitButton;
	}

	public WebElement getMessageInput() {
		return this.messageInput;
	}

	public WebElement getSuccessMassage() {
		return this.successMessage;
	}
}
