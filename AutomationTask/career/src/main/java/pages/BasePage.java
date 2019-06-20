package pages;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	WebDriverWait wait = null;
	protected WebDriver driver = null;

	public BasePage(WebDriver driver) throws MalformedURLException {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	@FindBy(xpath = "(//*[@class='icon-acr_hamburger'])[1]")
	private WebElement mainMenu;

	@FindBy(xpath = "//*[@class='icon-acr_mail']")
	private WebElement sendMailIcon;

	public WebElement getMainMenu() {
		return this.mainMenu;
	}

	public WebElement getSendEmailIcon() {
		return this.sendMailIcon;
	}

	public void getTab(int i) {
		List<String> browserTabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(browserTabs.get(i));
	}

	public void checkURL(List<WebElement> links) {

		for (int i = 0; i < links.size(); i++) {

			WebElement ele = links.get(i);

			String linkUrl = ele.getAttribute("href");

			try {
				URL url = new URL(linkUrl);

				HttpURLConnection httpURLConnect = (HttpURLConnection) url.openConnection();

				httpURLConnect.setConnectTimeout(3000);

				httpURLConnect.connect();

				if (httpURLConnect.getResponseCode() == 200) {
					System.out.println(linkUrl + " : " + httpURLConnect.getResponseMessage());
				}
				if (httpURLConnect.getResponseCode() == HttpURLConnection.HTTP_NOT_FOUND) {
					System.out.println(linkUrl + " : " + httpURLConnect.getResponseMessage() + " - "
							+ HttpURLConnection.HTTP_NOT_FOUND);
				}
			} catch (Exception e) {

			}

		}
	}
}
