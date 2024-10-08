package rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.abstractcomponents.abstractComponent;

public class CartPage extends abstractComponent {
	WebDriver driver;
	
	@FindBy(css = ".totalRow button")
	WebElement checkOutel;
	
	@FindBy(css = ".cartSection h3")
	private List<WebElement> cartProds;
	
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
}
	public Boolean VerifyProductDisplay(String productName) {
		Boolean match = cartProds.stream().anyMatch(cartProd -> cartProd.getText().equalsIgnoreCase(productName));
		return match;

	}
	
	public CheckoutPage goToCheckout() {
		checkOutel.click();
		return new CheckoutPage(driver);
	}
	
	
	
	

}
