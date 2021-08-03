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
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.CheckBoxDemoObject;
import pageObject.DemoHomeObject;
import pageObject.RadioButtonDemoObject;
import resources.base;

public class RadioButtonDemo extends base {

	public WebDriver driver;
	private static Logger log = LogManager.getLogger(CheckBoxDemo.class.getName());

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
	public void radioBtnDemo() throws InterruptedException {
		       		
		DemoHomeObject demoHome = new DemoHomeObject(driver);
		demoHome.getInputFormsDropdown().click();
		log.debug("Input form dropdown clicked");
		demoHome.getRadioBtnDemo().click();
		log.debug("Radio button Demo option clicked from dropdown");
		
		RadioButtonDemoObject radioButtonDemoObject = new RadioButtonDemoObject(driver);
		radioButtonDemoObject.getradioBtnDemo_Male().click();
		log.debug("Radio btn demo > Male radio btn selected");
		radioButtonDemoObject.getGetCheckedValue_Btn().click();
		log.debug("Get Checked Value button clicked");
		Assert.assertEquals(radioButtonDemoObject.getGetCheckedValue_TextValidation().getText(), "Radio button 'Male' is checked");
		log.debug("Text validated successfully");
	}
	
	@Test
	public void groupRadioBtnDemo() throws InterruptedException {
		       
		handleHomepagePopUp();		
		DemoHomeObject demoHome = new DemoHomeObject(driver);
		demoHome.getInputFormsDropdown().click();
		log.debug("Input form dropdown clicked");
		demoHome.getRadioBtnDemo().click();
		log.debug("Radio button Demo option clicked from dropdown");
		
		RadioButtonDemoObject radioButtonDemoObject = new RadioButtonDemoObject(driver);
		radioButtonDemoObject.getSexRadioBtn_Female().click();
		log.debug("Sex Radio btn  > Female radio btn selected");
		radioButtonDemoObject.getAgeGroupRadioBtn_15to50().click();
		log.debug("Age group 15 to 50 radio button selected");
		radioButtonDemoObject.getGetValues_Btn().click();
		log.debug("Get Values button clicked");
		String text = radioButtonDemoObject.getGetCheckedValue_TextValidation().getText();
		System.out.println(text);
		log.debug("Text validated successfully");
	}
}
