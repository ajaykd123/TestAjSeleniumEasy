package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SelectDropdownListObject {

public WebDriver driver;
	
	//Constructor
	public SelectDropdownListObject(WebDriver driver) {
		this.driver = driver;
	}
	
	By selectListDemoDropdown = By.xpath("//select[@id='select-demo']");
	public WebElement getSelectListDemoDropdown() {
		return driver.findElement(selectListDemoDropdown);
	}
	
	By selectListDemo_TextValidation = By.xpath("//p[@class='selected-value']");
	public WebElement getSelectListDemo_TextValidation() {
		return driver.findElement(selectListDemo_TextValidation);
	}

	
	By multiSelectListDemoDropdown = By.xpath("//select[@id='multi-select']");
	public WebElement getMultiSelectListDemoDropdown() {
		return driver.findElement(multiSelectListDemoDropdown);
	}
	
	By firstSelectedBtn = By.xpath("//button[@id='printMe']");
	public WebElement getFirstSelectedBtn() {
		return driver.findElement(firstSelectedBtn);
	}
	
	By getAllSelectedBtn = By.xpath("//button[@id='printAll']");
	public WebElement getGetAllSelectedBtn() {
		return driver.findElement(getAllSelectedBtn);
	}
	
	By firstSelectedBtn_TextValidation = By.xpath("//p[@class='getall-selected']");
	public WebElement get_FirstSelectedBtn_TextValidation() {
		return driver.findElement(firstSelectedBtn_TextValidation);
	}
	
	By getAllSelectedBtn_TextValidation = By.xpath("//p[@class='getall-selected']");
	public WebElement get_GetAllSelectedBtn_TextValidation() {
		return driver.findElement(getAllSelectedBtn_TextValidation);
	}
	
	By value1 = By.xpath("//select[@id='multi-select']//option[@value='New York']");
	public WebElement get_value1() {
		return driver.findElement(value1);
	}
	
	By value2= By.xpath("//select[@id='multi-select']//option[@value='Ohio']");
	public WebElement get_value2() {
		return driver.findElement(value2);
	}
	
	By value3 = By.xpath("//select[@id='multi-select']//option[@value='Florida']");
	public WebElement get_value3() {
		return driver.findElement(value3);
	}
	
}
