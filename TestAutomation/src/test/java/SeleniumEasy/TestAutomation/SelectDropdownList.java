package SeleniumEasy.TestAutomation;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.DemoHomeObject;
import pageObject.SelectDropdownListObject;
import pageObject.SimpleFormDemoObjects;
import resources.base;

public class SelectDropdownList extends base {

	public WebDriver driver;
	private static Logger log = LogManager.getLogger(SimpleFormDemo.class.getName());

	@BeforeTest
	public void initialize() throws IOException {

		log.debug("---------------------------------------------------");
		driver = initializeDriver();
		log.info("Driver is initialized");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to homepage");
		driver.manage().window().maximize();
		log.info("Window maximized");
	}

	@AfterTest
	public void tearDown() {
		driver.close();
		log.info("Browser closed");
		log.debug("---------------------------------------------------");
	}

	@Test
	public void selectListDemo() throws InterruptedException {

		handleHomepagePopUp();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		DemoHomeObject demoHome = new DemoHomeObject(driver);
		demoHome.getInputFormsDropdown().click();
		log.debug("Input form dropdown clicked");
		demoHome.getSelectDropdownList().click();
		log.debug("Select Dropdown List option clicked");
		SelectDropdownListObject selectDropdownListObject = new SelectDropdownListObject(driver);
		selectSingleValueFromDropdown(selectDropdownListObject.getSelectListDemoDropdown(), 3);
		log.debug("Tuesday option clicked");
		Assert.assertEquals(selectDropdownListObject.getSelectListDemo_TextValidation().getText(),
				"Day selected :- Tuesday");
		log.info("Day Selected text validated");
	}

	@Test(dependsOnMethods= {"selectListDemo"})
	public void multiSelectListDemo() throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		
		DemoHomeObject demoHome = new DemoHomeObject(driver);
		demoHome.getInputFormsDropdown().click();
		log.debug("Input form dropdown clicked");
		demoHome.getSelectDropdownList().click();
		log.debug("Select Dropdown List option clicked");
		SelectDropdownListObject selectDropdownListObject = new SelectDropdownListObject(driver);
		Select multiSelect = new Select(selectDropdownListObject.getMultiSelectListDemoDropdown());
		if (multiSelect.isMultiple()) {
			selectMultipleValueFromDropdown(selectDropdownListObject.get_value1(),
					selectDropdownListObject.get_value2(), selectDropdownListObject.get_value3());
		}
		log.debug("Multiple values selected");
		selectDropdownListObject.getGetAllSelectedBtn().click();
		log.debug("Get All Selected Btn clicked");
		System.out.println(selectDropdownListObject.get_GetAllSelectedBtn_TextValidation());
		Thread.sleep(3000);
		Assert.assertEquals(selectDropdownListObject.get_GetAllSelectedBtn_TextValidation().getText(),
				"Options selected are : Ohio,Florida,NewYork");
		log.info("Get All Selected Btn > Multi select value text validated");
	}

	private void selectSingleValueFromDropdown(WebElement element, int index) {
		// TODO Auto-generated method stub
		Select s = new Select(element);
		s.selectByIndex(index);
	}

	private void selectMultipleValueFromDropdown(WebElement element1, WebElement element2, WebElement element3) {
		// TODO Auto-generated method stub
		Actions ac = new Actions(driver);
		ac.moveToElement(element2).keyDown(Keys.CONTROL).click().build().perform();
		ac.moveToElement(element3).keyDown(Keys.CONTROL).click().build().perform();
		ac.moveToElement(element1).keyDown(Keys.CONTROL).click().build().perform();
	}
}
