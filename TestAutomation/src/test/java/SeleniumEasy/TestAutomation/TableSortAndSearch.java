package SeleniumEasy.TestAutomation;

import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import pageObject.DemoHomeObject;
import pageObject.TablePaginationObject;
import pageObject.TableSortAndSearchObject;
import resources.base;

public class TableSortAndSearch extends base {

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
	public void tableSortAndSearch() throws Exception {

		handleHomepagePopUp();
		DemoHomeObject demoHome = new DemoHomeObject(driver);
		demoHome.getTable().click();
		log.debug("table dropdown clicked");
		demoHome.getTableSortAndSearch().click();
		log.debug("table sort and search option clicked");

		TableSortAndSearchObject tableSortAndSearchObject = new TableSortAndSearchObject(driver);

		// column which we want to sort
		WebElement nameColumn = tableSortAndSearchObject.getColumnName();
		// column 'name' values web elements
		List<WebElement> columnNameValues = tableSortAndSearchObject.getColumnNameValues();
		// column which we want to sort
		WebElement searchox = tableSortAndSearchObject.getSearchBox();
		// next btn
		WebElement nextBtn = tableSortAndSearchObject.getNextBtn();
		// column 'country' values web elements
		List<WebElement> columnCountryValues = tableSortAndSearchObject.getColumnCountryValues();

		// calling method
		sortingColumn(driver, nameColumn, columnNameValues);

		// calling method
		searchingUsingPagination(driver, searchox, "S. Frost", columnNameValues, nextBtn);

		String country = "London";
		// calling method
		filteringWebtable(driver, searchox, country, columnCountryValues);

	}

	private static void sortingColumn(WebDriver driver, WebElement nameColumn, List<WebElement> columnNameValues)
			throws Exception {
		// Find 'name' column, and fetch 'class' attribute value, if
		// (class=sorting_desc), then it will click column name and do sorting in
		// ascending order, or else remain as it is in ascending order
		String value = nameColumn.getAttribute("class");
		if (value.equalsIgnoreCase("sorting_desc")) {
			nameColumn.click();
		}

		WebElement exam_info = driver.findElement(By.cssSelector("div[id='example_info'"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// This will scroll the page till the element is found
		js.executeScript("arguments[0].scrollIntoView();", exam_info);

		// after sorting, Fetching and storing xpath of all the values of 'name' column
		// in WebElement list 'col1ValuesElement'

		// List<WebElement> col1ValuesElement =
		// driver.findElements(By.xpath("//tr//td[1]"));
		List<WebElement> col1ValuesElement = columnNameValues;

		// after sorting, Fetching and storing actual text values of 'name' column in
		// String list 'originalcol1Values',
		List<String> originalcol1Values = col1ValuesElement.stream().map(s -> s.getText()).collect(Collectors.toList());
		System.out.println(originalcol1Values);

		// Fetching and storing sorted text values of 'originalcol1Values' list in
		// String list 'sortedcol1Values'
		List<String> sortedcol1Values = originalcol1Values.stream().sorted().collect(Collectors.toList());
		System.out.println(sortedcol1Values);

		// compare 'originalcol1Values' and 'originalcol1Values'. if sorting doesn't
		// work, then 'originalcol1Values' will contain non sorted value, and assert
		// will return false on comparison
		Assert.assertTrue(originalcol1Values.equals(originalcol1Values));
	}

	private static void searchingUsingPagination(WebDriver driver, WebElement searchox, String name,
			List<WebElement> columnNameValues, WebElement nextBtn) throws Exception {
		// clears search box
		searchox.clear();
		Thread.sleep(3000);

		// declare List of type string
		List<String> age;
		do {
//			// store xpath of all webelement of 1st column of webtable
//			List<WebElement> rows = columnNameValues;
//			// filtering webelement with text 'S. Frost' and getting his age
//			age = rows.stream().filter(s -> s.getText().contains("G. Little")).map(s -> getAge(s)).collect(Collectors.toList());

			// store xpath of all webelement of 1st column of webtable
			List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));
			// filtering webelement with text 'S. Frost' and getting his age
			age = rows.stream().filter(s -> s.getText().contains("S. Frost")).map(s -> getAge(s))
					.collect(Collectors.toList());
			// print age
			age.forEach(a -> System.out.println(a));
			// age.size() always remain less than 1, if it doesn't get webelement on page 1,
			// then it will enter if loop and click on next button and search text on second
			// page, once it will get text, then age.size() become greater than 1, and loop
			// will break
			if (age.size() < 1) {
				driver.findElement(By.cssSelector("a[class='paginate_button next']")).click();
			}
		} while (age.size() < 1);

	}

	private static void filteringWebtable(WebDriver driver, WebElement searchox, String country,
			List<WebElement> columnCountryValues) throws Exception {

		// search any office value in search box
		searchox.sendKeys(country);

		// after search, Fetch and store webelement of country column in
		// 'allvalueElement'
		List<WebElement> allvalueElement = driver.findElements(By.xpath("//tr//td[3]"));

		// Filter 'allvalueElement', and store filtered webelements in 'filteredList'
		List<WebElement> filteredList = allvalueElement.stream().filter(s -> s.getText().contains(country))
				.collect(Collectors.toList());

		// compare'allvalueElement' and 'filteredList'
		Assert.assertEquals(allvalueElement.size(), filteredList.size());

		WebElement exam_info = driver.findElement(By.cssSelector("div[id='example_info'"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// This will scroll the page till the element is found
		js.executeScript("arguments[0].scrollIntoView();", exam_info);

	}

	private static String getAge(WebElement s) {
		// TODO Auto-generated method stub
		String age = s.findElement(By.xpath("following-sibling::td[3]")).getText();
		return age;
	}

}
