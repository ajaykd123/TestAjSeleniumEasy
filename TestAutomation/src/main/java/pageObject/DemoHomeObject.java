package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DemoHomeObject {

	public WebDriver driver;
	
	//Constructor
	public DemoHomeObject(WebDriver driver) {
		this.driver = driver;
	}
	///////////////////////////////////////////////////////////////////////////////////////////////////
	By inputFormsDropdown = By.xpath("//li[@class='dropdown']//a[contains(text(),'Input Forms')]");
	public WebElement getInputFormsDropdown() {
		return driver.findElement(inputFormsDropdown);
	}
	
	By datePickers = By.xpath("//li[@class='dropdown']//a[contains(text(),'Date pickers')]");
	public WebElement getDatePickers() {
		return driver.findElement(datePickers);
	}
	
	By table = By.xpath("//li[@class='dropdown']//a[contains(text(),'Table')]");
	public WebElement getTable() {
		return driver.findElement(table);
	}
	//////////////////////////////////////////////////////////////////////////////////////////////////
	
	By tablePagination = By.xpath("//ul[@class='dropdown-menu']//li//a[contains(text(),'Table Pagination')]");
	public WebElement getTablePagination() {
		return driver.findElement(tablePagination);
	}
	
	By tableFilter = By.xpath("//ul[@class='dropdown-menu']//li//a[contains(text(),'Table Filter ')]");
	public WebElement getTableFilter() {
		return driver.findElement(tableFilter);
	}
	
	By tableSortAndSearch = By.xpath("//ul[@class='dropdown-menu']//li//a[contains(text(),'Table Sort & Search')]");
	public WebElement getTableSortAndSearch() {
		return driver.findElement(tableSortAndSearch);
	}
		
	By bootstrapDatePickers = By.xpath("//ul[@class='dropdown-menu']//li//a[contains(text(),'Bootstrap Date Picker')]");
	public WebElement getBootstrapDatePickers() {
		return driver.findElement(bootstrapDatePickers);
	}
	
	By simpleFormDemo = By.xpath("//ul[@class='dropdown-menu']//li//a[contains(text(),'Simple Form Demo')]");
	public WebElement getSimpleFormDemo() {
		return driver.findElement(simpleFormDemo);
	}
	
	By checkBoxDemo = By.xpath("//ul[@class='dropdown-menu']//li//a[contains(text(),'Checkbox Demo')]");
	public WebElement getCheckBoxDemo() {
		return driver.findElement(checkBoxDemo);
	}
	
	By radioBtnDemo = By.xpath("//ul[@class='dropdown-menu']//li//a[contains(text(),'Radio Buttons Demo')]");
	public WebElement getRadioBtnDemo() {
		return driver.findElement(radioBtnDemo);
	}
	
	By selectDropdownList = By.xpath("//ul[@class='dropdown-menu']//li//a[contains(text(),'Select Dropdown List')]");
	public WebElement getSelectDropdownList() {
		return driver.findElement(selectDropdownList);
	}
	
	By inputFormSubmit = By.xpath("//ul[@class='dropdown-menu']//li//a[contains(text(),'Input Form Submit')]");
	public WebElement getInputFormSubmit() {
		return driver.findElement(inputFormSubmit);
	}
	By jQuerySelectDropdown = By.xpath("//ul[@class='dropdown-menu']//li//a[contains(text(),'JQuery Select dropdown')]");
	public WebElement getJQuerySelectDropdown() {
		return driver.findElement(jQuerySelectDropdown);
	}
}
