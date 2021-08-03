package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckBoxDemoObject {

public WebDriver driver;
	
	//Constructor
	public CheckBoxDemoObject(WebDriver driver) {
		this.driver = driver;
	}
	
	By singleCheckboxDemo = By.xpath("//input[@id='isAgeSelected']");
	public WebElement getSingleCheckboxDemo() {
		return driver.findElement(singleCheckboxDemo);
	}
	
	By multipleCheckboxOption1 = By.xpath("//div[@class='checkbox']//label[text()='Option 1']");
	public WebElement getMultipleCheckboxOption1() {
		return driver.findElement(multipleCheckboxOption1);
	}
	
	By multipleCheckboxOption2 = By.xpath("//div[@class='checkbox']//label[text()='Option 2']");
	public WebElement getMultipleCheckboxOption2() {
		return driver.findElement(multipleCheckboxOption2);
	}
	
	By checkAllBtn = By.xpath("//input[@id='check1']");
	public WebElement getcheckAllBtn() {
		return driver.findElement(checkAllBtn);
	}
}
