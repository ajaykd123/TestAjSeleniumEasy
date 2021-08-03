package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InputFormSubmitObject {
	
public WebDriver driver;
	
	//Constructor
	public InputFormSubmitObject(WebDriver driver) {
		this.driver = driver;
	}
	
	By firstName = By.cssSelector("input[name='first_name']");
	public WebElement getFirstName() {
		return driver.findElement(firstName);
	}
	
	By lastName = By.cssSelector("input[name='last_name']");
	public WebElement getLastName() {
		return driver.findElement(lastName);
	}
	
	By email = By.cssSelector("input[name='email']");
	public WebElement getEmail() {
		return driver.findElement(email);
	}
	
	By phone = By.cssSelector("input[name='phone']");
	public WebElement getPhone() {
		return driver.findElement(phone);
	}
	
	By address = By.cssSelector("input[name='address']");
	public WebElement getAddress() {
		return driver.findElement(address);
	}
	
	By city = By.cssSelector("input[name='city']");
	public WebElement getCity() {
		return driver.findElement(city);
	}

	By state = By.cssSelector("select[name='state']");
	public WebElement getState() {
		return driver.findElement(state);
	}
	
	By zipCode = By.cssSelector("input[name='zip']");
	public WebElement getZipCode() {
		return driver.findElement(zipCode);
	}
	
	By website = By.cssSelector("input[name='website']");
	public WebElement getWebsite() {
		return driver.findElement(website);
	}
	
	By hosting_Yes = By.xpath("//input[@type='radio' and @value='yes' ]");
	public WebElement getHosting_Yes() {
		return driver.findElement(hosting_Yes);
	}
	
	By hosting_No = By.xpath("//input[@type='radio' and @value='no' ]");
	public WebElement getHosting_No() {
		return driver.findElement(hosting_No);
	}
	
	By description = By.cssSelector("textarea[name='comment']");
	public WebElement getDescription() {
		return driver.findElement(description);
	}
	
	By submit = By.cssSelector("button[type='submit']");
	public WebElement getSubmitBtn() {
		return driver.findElement(submit);
	}

}
