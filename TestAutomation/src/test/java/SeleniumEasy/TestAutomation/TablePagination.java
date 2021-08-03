package SeleniumEasy.TestAutomation;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObject.DemoHomeObject;
import pageObject.SimpleFormDemoObjects;
import pageObject.TablePaginationObject;
import resources.base;

public class TablePagination extends base {

	public WebDriver driver;
	private static Logger log = LogManager.getLogger(SimpleFormDemo.class.getName());

	@BeforeClass
	public void initialize() throws IOException {
		log.debug("---------------------------------------------------");
		log.debug("---------------------------------------------------");
		driver = initializeDriver();
		log.info("Driver is initialized");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to homepage");
		driver.manage().window().maximize();
		log.info("Window maximized");

	}

	@AfterClass
	public void tearDown() {
		driver.close();
		log.info("Browser closed");
		log.debug("---------------------------------------------------");
		log.debug("---------------------------------------------------");
	}

	@Test
	public void tablePagination() throws InterruptedException {

		handleHomepagePopUp();
		DemoHomeObject demoHome = new DemoHomeObject(driver);
		demoHome.getTable().click();
		log.debug("table dropdown clicked");
		demoHome.getTablePagination().click();
		log.debug("table pagination option clicked");

		TablePaginationObject tablePaginationObject = new TablePaginationObject(driver);	
		WebElement NextButton = tablePaginationObject.getNextButton();
		WebElement prevButton = tablePaginationObject.getPrevButton();
		List<WebElement> pagination = tablePaginationObject.getPagination();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// This will scroll the page till the element is found
		js.executeScript("arguments[0].scrollIntoView();", tablePaginationObject.getDefaultPage());
		log.debug("scrolled the page till the element");

		String value = tablePaginationObject.getDefaultPage().getText();
		if (value.equalsIgnoreCase("1")) {
			System.out.println("Page1 is default");
		}

		if (pagination.size() > 0) {
			System.out.println("pagination exists");

			int flag1 = 0;
			int flag2 = 0;
			// click on pagination link
			for (int i = 1; i < (pagination.size() - 2); i++) {
				if (flag1 == 0) {
					Assert.assertFalse(prevButton.isDisplayed());
					flag1++;
				}
				// Check if nextbutton is enable or not.
				if (NextButton.isDisplayed()) {
					NextButton.click();					
				} else {
					System.out.println("next button not displayed");
				}
			}
			for (int i = 1; i < (pagination.size() - 2); i++) {
				if (flag2 == 0) {
					Assert.assertFalse(NextButton.isDisplayed());
					flag2++;
				}
				// Check if previous is enable or not.
				if (prevButton.isDisplayed()) {
					prevButton.click();
				} else {
					System.out.println("previous button not displayed");
				}
			}

		}
	}
}
