package SeleniumEasy.TestAutomation;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObject.DemoHomeObject;
import pageObject.SimpleFormDemoObjects;
import resources.base;

public class SimpleFormDemo extends base {

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
	public void singleInputField() throws InterruptedException {
		       
		handleHomepagePopUp();		
		DemoHomeObject demoHome = new DemoHomeObject(driver);
		demoHome.getInputFormsDropdown().click();
		log.debug("Input form dropdown clicked");
		demoHome.getSimpleFormDemo().click();
		log.debug("Simple form option clicked");
		SimpleFormDemoObjects simpleFormDemoObjects = new SimpleFormDemoObjects(driver);
		simpleFormDemoObjects.getEnterMessage().sendKeys("welcome");
		log.debug("Message entered");
		simpleFormDemoObjects.getShowMessageBtn().click();
		log.debug("Show message button clicked");
		Assert.assertEquals(simpleFormDemoObjects.getYourMessageValue().getText(), "welcome");
		log.info("message successfully validated");
	}
	
	@Test
	public void twoInputField() {
		SimpleFormDemoObjects simpleFormDemoObjects = new SimpleFormDemoObjects(driver);
		simpleFormDemoObjects.getEnterValueA().sendKeys("15");
		log.debug("Entered value A");
		simpleFormDemoObjects.getEnterValueB().sendKeys("10");
		log.debug("Entered value B");
		simpleFormDemoObjects.getGetTotalBtn().click();
		log.debug("Get Total button cicked");
		Assert.assertEquals(simpleFormDemoObjects.getValidateTotalValue().getText(), "25");
		log.info("Total value is validated successfully");
	}
}
