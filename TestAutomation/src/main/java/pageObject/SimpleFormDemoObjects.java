package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SimpleFormDemoObjects {

public WebDriver driver;
	
	//Constructor
	public SimpleFormDemoObjects(WebDriver driver) {
		this.driver = driver;
	}
	
	By enterMessage = By.cssSelector("input[id='user-message']");
	public WebElement getEnterMessage() {
		return driver.findElement(enterMessage);
	}
	
	By showMessageBtn = By.xpath("//button[contains(text(),'Show Message')]");
	public WebElement getShowMessageBtn() {
		return driver.findElement(showMessageBtn);
	}
	
	By yourMessageValue = By.xpath("//span[@id='display']");
	public WebElement getYourMessageValue() {
		return driver.findElement(yourMessageValue);
	}
	
	By enterValueA = By.cssSelector("input[id='sum1']");
	public WebElement getEnterValueA() {
		return driver.findElement(enterValueA);
	}
	
	By enterValueB = By.cssSelector("input[id='sum2']");
	public WebElement getEnterValueB() {
		return driver.findElement(enterValueB);
	}
	
	By getTotalBtn = By.xpath("//button[contains(text(),'Get Total')]");
	public WebElement getGetTotalBtn() {
		return driver.findElement(getTotalBtn);
	}
	
	By validateTotalValue = By.xpath("//span[@id='displayvalue']");
	public WebElement getValidateTotalValue() {
		return driver.findElement(validateTotalValue);
	}
}
