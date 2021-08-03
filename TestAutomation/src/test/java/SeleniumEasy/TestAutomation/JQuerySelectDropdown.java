package SeleniumEasy.TestAutomation;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import pageObject.CheckBoxDemoObject;
import pageObject.DemoHomeObject;
import pageObject.JQuerySelectDropdownObject;
import resources.base;

public class JQuerySelectDropdown extends base {

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
	public void selectCountry() throws InterruptedException {

		handleHomepagePopUp();
		DemoHomeObject demoHome = new DemoHomeObject(driver);
		demoHome.getInputFormsDropdown().click();
		log.debug("Input form dropdown clicked");

		demoHome.getJQuerySelectDropdown().click();
		log.debug("JQuery Select Dropdown option clicked");

		JQuerySelectDropdownObject jQuerySelectDropdownObject = new JQuerySelectDropdownObject(driver);
		jQuerySelectDropdownObject.getSelectCountry().click();
		driver.findElement(By.xpath("//body/span[1]/span[1]/span[1]/input[1]")).sendKeys("Ne");

		List<WebElement> options = driver.findElements(By.xpath("//ul[@id='select2-country-results']//li"));
		for (WebElement option : options) {
			if (option.getText().equalsIgnoreCase("Netherlands")) {
				option.click();
				break;
			}
		}
		Assert.assertEquals(driver.findElement(By.cssSelector("span[id='select2-country-container']")).getText(),
				"Netherlands");
	}
	
	@Ignore	
	@Test 
	public void selectState() throws InterruptedException {

		DemoHomeObject demoHome = new DemoHomeObject(driver);
		demoHome.getInputFormsDropdown().click();
		log.debug("Input form dropdown clicked");

		demoHome.getJQuerySelectDropdown().click();
		log.debug("JQuery Select Dropdown option clicked");

		JQuerySelectDropdownObject jQuerySelectDropdownObject = new JQuerySelectDropdownObject(driver);		
		
		jQuerySelectDropdownObject.getSelectState().click();
		jQuerySelectDropdownObject.getSelectState().sendKeys("Al");
		List<WebElement> options = driver.findElements(By.cssSelector("ul[id='select2-kn39-results'] li[class='select2-results__option']"));
		for (WebElement option : options) {
			if (option.getText().equalsIgnoreCase("Alaska")) {
				option.click();
				break;
			}
		}
		
		jQuerySelectDropdownObject.getSelectState().sendKeys("Co");
		List<WebElement> options2 = driver.findElements(By.xpath("//ul[@id='select2-kn39-results']//li"));
		for (WebElement option : options2) {
			if (option.getText().equalsIgnoreCase("New Mexico")) {
				option.click();
				break;
			}
		}
		
	}
	
	@Ignore
	@Test 
	public void disabledValues() throws InterruptedException {

		handleHomepagePopUp();
		DemoHomeObject demoHome = new DemoHomeObject(driver);
		demoHome.getInputFormsDropdown().click();
		log.debug("Input form dropdown clicked");

		demoHome.getJQuerySelectDropdown().click();
		log.debug("JQuery Select Dropdown option clicked");

		JQuerySelectDropdownObject jQuerySelectDropdownObject = new JQuerySelectDropdownObject(driver);		
		
		jQuerySelectDropdownObject.getDisabledValues().click();		
		driver.findElement(By.xpath("//body/span[1]/span[1]/span[1]/input[1])")).sendKeys("Am");
		List<WebElement> options = driver.findElements(By.xpath("//ul[@id='select2-6dj5-results']//li"));
		for (WebElement option : options) {
			if (option.getText().equalsIgnoreCase("American Samoa")) {
				option.click();
				break;
			}
		}
				
	}
}
