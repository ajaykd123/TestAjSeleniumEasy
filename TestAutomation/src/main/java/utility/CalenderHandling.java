package utility;

import java.util.List;

import org.openqa.selenium.WebElement;

public class CalenderHandling {

	public void selectDate(String userMonth, WebElement month, WebElement changeMonthArrow, List<WebElement> dates) {
		// Select Month
		while (!month.getText().contains(userMonth)) {
			changeMonthArrow.click();
		}

		// Select date
		for (int i = 0; i < dates.size(); i++) {
			String text = dates.get(i).getText();
			if (text.equalsIgnoreCase("18")) {
				dates.get(i).click();
				break;
			}
		}
	}

}
