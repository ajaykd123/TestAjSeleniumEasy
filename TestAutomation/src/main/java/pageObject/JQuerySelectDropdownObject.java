package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JQuerySelectDropdownObject {

public WebDriver driver;
	
	//Constructor
	public JQuerySelectDropdownObject(WebDriver driver) {
		this.driver = driver;
	}
	
	By selectCountry = By.xpath("//select[@id='country']/following-sibling::span");
	public WebElement getSelectCountry() {
		return driver.findElement(selectCountry);
	}

	By selectState = By.cssSelector("span[class='select2-selection select2-selection--multiple']");
	public WebElement getSelectState() {
		return driver.findElement(selectState);
	}
	
	By disabledValues = By.xpath("/html[1]/body[1]/div[2]/div[1]/div[2]/div[3]/div[1]/div[2]/span[1]/span[1]/span[1]/span[1]");
	public WebElement getDisabledValues() {
		return driver.findElement(disabledValues);
	}
}
