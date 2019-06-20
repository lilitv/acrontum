package pages;

import java.net.MalformedURLException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FooterPage extends BasePage {

	public FooterPage(WebDriver driver) throws MalformedURLException {
		super(driver);
	}

	@FindBy(xpath = "(//*[@href='/Loesungen'])[2]")
	private WebElement imprintLink;

	@FindBy(xpath = "(//*[contains(text(),'Digital Business Services')])[2]")
	private WebElement businessServicesLink;

	@FindBy(xpath = "(//*[contains(text(),'IT & ENTWICKLUNGSDIENSTLEISTUNGEN')])[2]")
	private WebElement entwicklungsdienstleistungenLink;

	@FindBy(xpath = "//*[contains(text(),'Impressum')]")
	private WebElement impressumLink;

	@FindBy(xpath = "(//*[contains(text(),'Wer wir sind')])[1]")
	private WebElement werWirSindLink;

	@FindBy(xpath = "(//*[contains(text(),'Datenschutzerklärung')])[2]")
	private WebElement datenschutzerklaerungLink;

	@FindBy(xpath = "(//*[@class=\"icon-acr_facebook_aligned\"])[1]")
	private WebElement facebookLink;

	@FindBy(xpath = "(//*[@class=\"icon-acr_twitter_aligned\"])[1]")
	private WebElement twitter;

	@FindBy(xpath = "(//*[@class=\"icon-acr_googleplus_aligned\"])[1]")
	private WebElement googlePlus;

	@FindBy(xpath = "(//*[@class=\"icon-acr_xing_aligned\"])[1]")
	private WebElement xing;

	@FindBy(xpath = "(//*[@class=\"icon-acr_linkedin_aligned\"])[1]")
	private WebElement linkedin;

	@FindBy(xpath = "(//*[@class=\"icon-acr_phone_aligned\"])[3]")
	private WebElement phoneIcon;

	public WebElement getImprintLink() {
		return this.imprintLink;
	}

	public WebElement getBusinessServicesLink() {
		return this.businessServicesLink;
	}

	public WebElement getentwicklungsdienstleistungenLink() {
		return this.entwicklungsdienstleistungenLink;
	}

	public WebElement getImpressumLink() {
		return this.impressumLink;
	}

	public WebElement getWerWirSindLink() {
		return this.werWirSindLink;
	}

	public WebElement getDatenschutzerklaerungLink() {
		return this.datenschutzerklaerungLink;
	}

	public WebElement getFacebookLink() {
		return this.facebookLink;
	}

	public WebElement getTwitterLink() {
		return this.twitter;
	}

	public WebElement getGooglePlusLink() {
		return this.googlePlus;
	}

	public WebElement getXingLink() {
		return this.xing;
	}

	public WebElement getLinkedinLink() {
		return this.linkedin;
	}

	public WebElement getPhoneIcon() {
		return this.phoneIcon;
	}

}
