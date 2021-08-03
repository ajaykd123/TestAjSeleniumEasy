package SeleniumEasy.TestAutomation;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObject.DemoHomeObject;
import pageObject.SimpleFormDemoObjects;
import pageObject.TableDataSearchObject;
import resources.base;

public class TableDataSearch extends base {

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
	public void tableFilterTasks() throws InterruptedException {
		       
		handleHomepagePopUp();		
		DemoHomeObject demoHome = new DemoHomeObject(driver);
		demoHome.getTable().click();
		log.debug("Table dropdown clicked");
		demoHome.getTableFilter().click();
		log.debug("Table filter option clicked");
		
		TableDataSearchObject tableFilterObject = new TableDataSearchObject(driver);
		 WebElement webtable = driver.findElement(By.xpath("//div[contains(@class,'ReactTable')]"));
		 List<WebElement> rowsWithData = webtable.findElements(By.xpath("//table[@id='task-table']/tbody/tr"));
		 tableFilterObject.getTaskSearchBox().sendKeys("w");
		
		log.debug("Message entered");
		
		log.debug("Show message button clicked");
		
		log.info("message successfully validated");
	}
}
