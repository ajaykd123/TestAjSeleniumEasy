package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TablePaginationObject {

public WebDriver driver;
	
	//Constructor
	public TablePaginationObject(WebDriver driver) {
		this.driver = driver;
	}
	
	By defaultPage = By.cssSelector("a[class='page_link active']");
	public WebElement getDefaultPage() {
		return driver.findElement(defaultPage);
	}
	By pagination = By.xpath("//ul[@id='myPager']/li");
	public List<WebElement> getPagination() {
		return driver.findElements(pagination);
	}
	By nextButton = By.cssSelector("a[class='next_link']");
	public WebElement getNextButton() {
		return driver.findElement(nextButton);
	}
	
	By prevButton = By.cssSelector("a[class='prev_link']");
	public WebElement getPrevButton() {
		return driver.findElement(prevButton);
	}
	
}
