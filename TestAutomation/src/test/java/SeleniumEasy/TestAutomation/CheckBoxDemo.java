package SeleniumEasy.TestAutomation;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObject.CheckBoxDemoObject;
import pageObject.DemoHomeObject;
import resources.base;
import utility.Scroll;

public class CheckBoxDemo extends base{

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
	public void clickSingleCheckBoxDemo() throws InterruptedException {
		       
		handleHomepagePopUp();		
		DemoHomeObject demoHome = new DemoHomeObject(driver);
		demoHome.getInputFormsDropdown().click();
		log.debug("Input form dropdown clicked");
		demoHome.getCheckBoxDemo().click();
		log.debug("CheckBox Demo option clicked");
		CheckBoxDemoObject checkBoxDemoObject =new CheckBoxDemoObject(driver);
		checkBoxDemoObject.getSingleCheckboxDemo().click();
		log.debug("single CheckBox option selected");
		Assert.assertTrue(checkBoxDemoObject.getSingleCheckboxDemo().isSelected());		
	}
	
	@Test(dependsOnMethods= {"clickSingleCheckBoxDemo"})
	public void clickMultipleCheckBoxDemo() throws InterruptedException {
	
		CheckBoxDemoObject checkBoxDemoObject =new CheckBoxDemoObject(driver);
		
		Scroll Scroll = new Scroll();
		Scroll.verticalScrollByVisibleElement(checkBoxDemoObject.getcheckAllBtn(), driver);         
		
		checkBoxDemoObject.getcheckAllBtn().click();
		checkBoxDemoObject.getcheckAllBtn().getAttribute("value").compareTo("Uncheck All");
		log.debug("Uncheck All text displayed on button");
		checkBoxDemoObject.getMultipleCheckboxOption1().click();		
		Assert.assertFalse(checkBoxDemoObject.getMultipleCheckboxOption1().isSelected());
		log.debug("option 1 CheckBox option unchecked");
		checkBoxDemoObject.getMultipleCheckboxOption2().click();	
		Assert.assertFalse(checkBoxDemoObject.getMultipleCheckboxOption2().isSelected());
		log.debug("option 2 CheckBox option unchecked");	
		checkBoxDemoObject.getcheckAllBtn().getAttribute("value").compareTo("Check All");
		log.debug("Check All text displayed on button");
	}
}
