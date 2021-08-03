package utility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Scroll {

	// To scroll down the web page by pixel.
	public void verticalScrollUsingPixel(WebDriver driver) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);
	}
	// To vertical scroll down the web page by the visibility of the element.
	public void verticalScrollByVisibleElement(WebElement Element, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// This will scroll the page till the element is found
		js.executeScript("arguments[0].scrollIntoView();", Element);
	}

	// To scroll down the web page at the bottom of the page.
	public void scrollTillBottom(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}
	//horizontal scroll on the web page by the visibility of the element..
	public void horizontalScrollByVisibleElement(WebElement Element, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;		
        js.executeScript("arguments[0].scrollIntoView();", Element);
	}


}
