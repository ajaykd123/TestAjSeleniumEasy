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

import pageObject.BootstrapDatePickerObject;
import pageObject.CheckBoxDemoObject;
import pageObject.DemoHomeObject;
import resources.base;

public class BootstrapDatePicker extends base {

	public WebDriver driver;
	private static Logger log = LogManager.getLogger(CheckBoxDemo.class.getName());

	@BeforeClass
	public void initialize() throws IOException {

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
	}

	@Test
	public void dateRange_StartAndEndDate() throws InterruptedException {

		handleHomepagePopUp();
		DemoHomeObject demoHome = new DemoHomeObject(driver);
		demoHome.getDatePickers().click();
		log.debug("Date Picker dropdown clicked");
		demoHome.getBootstrapDatePickers().click();
		log.debug("Bootstrap Date Pickers option clicked");

		BootstrapDatePickerObject bootstrapDatePickerObject = new BootstrapDatePickerObject(driver);
		
		//List<WebElement> dates = bootstrapDatePickerObject.getDates_StartDate();
		//selectDate("March",bootstrapDatePickerObject.getMonth_StartDate(),bootstrapDatePickerObject.getchangeMonth_StartDate(),dates);

		//select start date box
		bootstrapDatePickerObject.getStartDate_DateRange().click();
		// Select Month
		while (!bootstrapDatePickerObject.getMonth_StartDate().getText().contains("March")) {
			bootstrapDatePickerObject.getchangeMonth_StartDate().click();
		}
		// Select date
		List<WebElement> dates = bootstrapDatePickerObject.getDates_StartDate();
		for (int i = 0; i < dates.size(); i++) {
			String text = dates.get(i).getText();
			if (text.equalsIgnoreCase("18")) {
				dates.get(i).click();
				break;
			}
		}
		
		//Select end date box		
		bootstrapDatePickerObject.getEndDate_DateRange().click();
		// Select end Month
		while (!bootstrapDatePickerObject.getMonth_StartDate().getText().contains("April")) {
			bootstrapDatePickerObject.getchangeMonth_StartDate().click();
		}
		// Select end date
		List<WebElement> dates2 = bootstrapDatePickerObject.getDates_EndDate();
		for (int i = 0; i < dates2.size(); i++) {
			String text = dates2.get(i).getText();
			if (text.equalsIgnoreCase("12")) {
				dates2.get(i).click();
				break;
			}
		}
	}
	
}
