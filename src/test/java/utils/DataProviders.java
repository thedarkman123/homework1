package utils;

import java.lang.reflect.Method;
import java.util.HashMap;

import org.testng.annotations.DataProvider;

public class DataProviders {
	//just for this exercise purposes, the excel initiated here
	private ExcelReader excel  = new ExcelReader(System.getProperty("user.dir") + "\\src\\test\\resources\\excel\\testdata.xlsx");
	
	@DataProvider(name="dp")
	public Object[][] getData(Method m){
		String sheetName = m.getName();
		int rows = excel.getRowCount(sheetName);//2
		int cols = excel.getColumnCount(sheetName);//1
		
		Object[][] data = new Object[rows-1][1];
		HashMap<String,String> table = null; 

		for (int rowNum = 2; rowNum<= rows; rowNum++) {
			table = new HashMap<String,String>();
			for (int colNum = 0; colNum < cols;colNum++) {
				table.put(excel.getCellData(sheetName, colNum, 1), excel.getCellData(sheetName, colNum, rowNum));	
				data[rowNum-2][0] = table;
			}
		}
		
		return data;
	}
}
