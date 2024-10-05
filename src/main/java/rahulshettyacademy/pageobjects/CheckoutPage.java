package rahulshettyacademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import rahulshettyacademy.abstractcomponents.abstractComponent;

public class CheckoutPage extends abstractComponent {
	WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='btnn action__submit ng-star-inserted']")
	WebElement submit;

	@FindBy(css = "[placeholder ='Select Country']")
	WebElement Country;
	
	@FindBy(xpath = "(//button[contains(@class,'ta-item')])[2]")
	WebElement selCountry;
	
	By results = By.cssSelector(".ta-results");
	
	

	public void selectCountry(String countryName) {
		Actions a = new Actions(driver);
		a.sendKeys(Country, countryName).build().perform();
		waitForElementToAppear(By.cssSelector(".ta-results"));
		selCountry.click();


	}
	
	public ConfirmationPage submitOrder() {
		waitForElementToAppear(By.xpath("//a[@class='btnn action__submit ng-star-inserted']"));
		submit.click();
		return new ConfirmationPage(driver);
	}

}
