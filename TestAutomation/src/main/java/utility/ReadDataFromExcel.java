package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataFromExcel {

	public ArrayList<String> getDataFromExcel(String testCaseName, String path) throws IOException {

		// Identify 'Test cases' column by scanning the entire 1st row
		// once column is identified then scan entire test case column to identify
		// 'login' test case row
		// after you grab 'login' test case row = pull all the data of that row and feed
		// into test

		ArrayList<String> a = new ArrayList<String>();

		FileInputStream fis = new FileInputStream(path);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		int sheets = workbook.getNumberOfSheets();
		for (int i = 0; i < sheets; i++) {
			if (workbook.getSheetName(i).equalsIgnoreCase("Sheet2")) {
				XSSFSheet sheet = workbook.getSheetAt(i);

				// Identify 'Test cases' column by scanning the entire 1st row
				Iterator<Row> rows = sheet.iterator();// sheet is collection of rows
				Row firstRow = rows.next();
				Iterator<Cell> cells = firstRow.iterator();// row is collection of cells
				int k = 0;
				int column = 0;
				while (cells.hasNext()) {
					Cell value = cells.next();
					if (value.getStringCellValue().equalsIgnoreCase("TestCase")) {
						column = k;
					}
					k++;
				}
				System.out.println(column);

				// once 'Test cases' column is identified then scan entire test case column to
				// identify 'login' test case row
				while (rows.hasNext()) {
					Row r = rows.next();

					if (r.getCell(column).getStringCellValue().equalsIgnoreCase(testCaseName)) {
						// after you grab 'login' test case row = pull all the data of that row and feed
						// into test
						Iterator<Cell> cv = r.cellIterator();
						while (cv.hasNext()) {
							Cell c = cv.next();
							// (c.getCellTypeEnum() == CellType.STRING)
							if (c.getCellType() == CellType.STRING) {

								a.add(c.getStringCellValue());
							} else {
								a.add(NumberToTextConverter.toText(c.getNumericCellValue()));
							}
						}
//							a.add(c.next().getStringCellValue());

						break;
					}

				}
			}
		}

		return a;
	}

}
