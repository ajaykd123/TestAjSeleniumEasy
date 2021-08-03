package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RadioButtonDemoObject {

	public WebDriver driver;

	// Constructor
	public RadioButtonDemoObject(WebDriver driver) {
		this.driver = driver;
	}

	By radioBtnDemo_Female = By.xpath("//input[@value='Female' and @name='optradio']");
	public WebElement getradioBtnDemo_Female() {
		return driver.findElement(radioBtnDemo_Female);
	}
	
	By radioBtnDemo_Male = By.xpath("//input[@value='Male' and @name='optradio']");
	public WebElement getradioBtnDemo_Male() {
		return driver.findElement(radioBtnDemo_Male);
	}
	
	By getCheckedValue_Btn = By.xpath("//button[@id='buttoncheck']");
	public WebElement getGetCheckedValue_Btn() {
		return driver.findElement(getCheckedValue_Btn);
	}

	By getCheckedValue_TextValidation = By.xpath("//p[@class='radiobutton']");
	public WebElement getGetCheckedValue_TextValidation() {
		return driver.findElement(getCheckedValue_TextValidation);
	}
	
	By sexRadioBtn_Female = By.xpath("//input[@value='Female' and @name='gender']");
	public WebElement getSexRadioBtn_Female() {
		return driver.findElement(sexRadioBtn_Female);
	}
	
	By sexRadioBtn_Male = By.xpath("//input[@value='Male' and @name='gender']");
	public WebElement getSexRadioBtn_Male() {
		return driver.findElement(sexRadioBtn_Male);
	}

	By ageGroupRadioBtn_5to15 = By.xpath("//input[@value='5 - 15' and @name='ageGroup']");
	public WebElement getAgeGroupRadioBtn_5to15() {
		return driver.findElement(ageGroupRadioBtn_5to15);
	}
	
	By ageGroupRadioBtn_0to5 = By.xpath("//input[@value='0 - 5' and @name='ageGroup']");
	public WebElement getAgeGroupRadioBtn_0to5() {
		return driver.findElement(ageGroupRadioBtn_0to5);
	}
	
	By ageGroupRadioBtn_15to50 = By.xpath("//input[@value='15 - 50' and @name='ageGroup']");
	public WebElement getAgeGroupRadioBtn_15to50() {
		return driver.findElement(ageGroupRadioBtn_15to50);
	}
	
	By getValues_Btn = By.xpath("//button[contains(text(),'Get values')]");
	public WebElement getGetValues_Btn() {
		return driver.findElement(getValues_Btn);
	}
	
	By getValues_Btn_ValidateText = By.xpath("//p[@class='groupradiobutton']");
	public WebElement getGetValues_Btn_ValidateText() {
		return driver.findElement(getValues_Btn_ValidateText);
	}

}
