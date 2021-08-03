package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TableSortAndSearchObject {

	public WebDriver driver;

	// Constructor
	public TableSortAndSearchObject(WebDriver driver) {
		this.driver = driver;
	}

	By columnName = By.xpath("//tr//th[1]");

	public WebElement getColumnName() {
		return driver.findElement(columnName);
	}

	// xpath of all the values of 'name' column
	By columnNameValues = By.xpath("//tr//td[1]");
	public List<WebElement> getColumnNameValues() {
		return driver.findElements(columnNameValues);
	}
	
	//xpath of all the values of 'country' column
	By columnCountryValues = By.xpath("//tr//td[3]");
	public List<WebElement> getColumnCountryValues() {
		return driver.findElements(columnCountryValues);
	}

	// Search
	By searchBox = By.xpath("//input[@type='search']");
	public WebElement getSearchBox() {
		return driver.findElement(searchBox);
	}
	
	By nextBtn = By.cssSelector("a[class='paginate_button next']");
	public WebElement getNextBtn() {
		return driver.findElement(nextBtn);
	}
}
