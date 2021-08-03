package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BootstrapDatePickerObject {

public WebDriver driver;
	
	//Constructor
	public BootstrapDatePickerObject(WebDriver driver) {
		this.driver = driver;
	}
	
	By startDate_DateRange = By.xpath("//input[@class='form-control' and @placeholder='Start date']");
	public WebElement getStartDate_DateRange() {
		return driver.findElement(startDate_DateRange);
	}
	
	By endDate_DateRange = By.xpath("//input[@class='form-control' and @placeholder='End date']");
	public WebElement getEndDate_DateRange() {
		return driver.findElement(endDate_DateRange);
	}
	
	By month_StartDate = By.xpath("//div[@class='datepicker-days']//table[@class='table-condensed']//thead/tr[2]/th[2]");
	public WebElement getMonth_StartDate() {
		return driver.findElement(month_StartDate);
	}
	
	By changeMonth_StartDate = By.xpath("//div[@class='datepicker-days']//table[@class='table-condensed']//thead/tr[2]/th[3]");
	public WebElement getchangeMonth_StartDate() {
		return driver.findElement(changeMonth_StartDate);
	}
	
	By dates_StartDate = By.xpath("//div[@class='datepicker-days']//table[@class='table-condensed']//tbody/tr/td");
	public List<WebElement> getDates_StartDate() {
		return driver.findElements(dates_StartDate);
	}
	
	By dates_EndDate = By.xpath("//div[@class='datepicker-days']//table[@class='table-condensed']//tbody/tr/td");
	public List<WebElement> getDates_EndDate() {
		return driver.findElements(dates_EndDate);
	}
}
