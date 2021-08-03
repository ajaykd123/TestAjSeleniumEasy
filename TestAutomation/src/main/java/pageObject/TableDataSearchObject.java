package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TableDataSearchObject {

public WebDriver driver;
	
	//Constructor
	public TableDataSearchObject(WebDriver driver) {
		this.driver = driver;
	}
	
	By taskSearchBox = By.cssSelector("//input[@id='task-table-filter']");
	public WebElement getTaskSearchBox() {
		return driver.findElement(taskSearchBox);
	}
	
	By numberOfRows = By.cssSelector("//input[@id='task-table-filter']");
	public WebElement getNumberOfRows() {
		return driver.findElement(numberOfRows);
	}
	
	By numberOfColumns = By.cssSelector("//input[@id='task-table-filter']");
	public WebElement getNumberOfColumns() {
		return driver.findElement(numberOfColumns);
	}
	
}
