package SeleniumEasy.TestAutomation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObject.CheckBoxDemoObject;
import pageObject.DemoHomeObject;
import pageObject.InputFormSubmitObject;
import resources.base;
import utility.ReadDataFromExcel;

public class InputFormSubmit extends base{

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
	public void inputFormSubmit() throws InterruptedException, IOException {
		  
		handleHomepagePopUp();
		DemoHomeObject demoHome = new DemoHomeObject(driver);
		demoHome.getInputFormsDropdown().click();
		log.debug("Input form dropdown clicked");
		demoHome.getInputFormSubmit().click();
		log.debug("Input Form Submit option clicked from dropdown");
			
		ReadDataFromExcel obj1 = new ReadDataFromExcel();
		ArrayList<String> data1 = obj1.getDataFromExcel("InputForm","C:\\Users\\Ajay Dhote\\Downloads\\book1.xlsx");
		
		String firstName = data1.get(1);
		String lastName = data1.get(2);
		String email = data1.get(3);
		String phone = data1.get(4);
		String address = data1.get(5);
		String city = data1.get(6);
		String state = data1.get(7);
		String zipCode = data1.get(8);
		String website = data1.get(9);
		String hosting = data1.get(10);
		String description = data1.get(11);
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		InputFormSubmitObject inputFormSubmitObject = new InputFormSubmitObject(driver);
		
		inputFormSubmitObject.getFirstName().sendKeys(firstName);
		log.debug("First name entered");
		inputFormSubmitObject.getLastName().sendKeys(lastName);
		log.debug("last name entered");
		inputFormSubmitObject.getEmail().sendKeys(email);
		log.debug("email entered");
		inputFormSubmitObject.getPhone().sendKeys(phone);
		log.debug("phone entered");
		inputFormSubmitObject.getAddress().sendKeys(address);
		log.debug("address entered");
		inputFormSubmitObject.getCity().sendKeys(city);
		log.debug("city entered");

		selectSingleValueFromDropdown(inputFormSubmitObject.getState(),state);
		
		inputFormSubmitObject.getZipCode().sendKeys(zipCode);
		log.debug("zip code entered");
		inputFormSubmitObject.getWebsite().sendKeys(website);
		log.debug("website entered");
		
		if(hosting.contains("yes")) {
			inputFormSubmitObject.getHosting_Yes().click();
			log.debug("hosting yes selected");
		}else {
			inputFormSubmitObject.getHosting_No().click();
			log.debug("hosting no selected");
		}
		
		inputFormSubmitObject.getDescription().sendKeys(description);
		log.debug("Description entered");
		//inputFormSubmitObject.getSubmitBtn().click();		
	}
	
	private void selectSingleValueFromDropdown(WebElement element, String state) {
		// TODO Auto-generated method stub
		Select s = new Select(element);
		s.selectByVisibleText(state);
	}
}
