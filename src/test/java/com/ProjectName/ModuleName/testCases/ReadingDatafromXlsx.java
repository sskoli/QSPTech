package com.ProjectName.ModuleName.testCases;

import java.util.Hashtable;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.AutomationWorldByRahul.SeleniumTraining.DataCollection;
import com.AutomationWorldByRahul.SeleniumTraining.ExcelReader;

@Test(dataProvider = "Data_Collections")
public class ReadingDatafromXlsx {
	
	
	static ExcelReader excel = new ExcelReader("D:\\Sandip\\QSP\\QSPTech\\src\\test\\resources\\testData\\Master_Sheet.xlsx");
	
	public void readingDatafromxlsxfile(Hashtable<String,String> htdata) {
		
		System.out.println("Getting data from xlsx using DataProvider");
		
}
	@DataProvider
	public static Object[][] Data_Collections () {
		
		DataCollection dc = new DataCollection(excel,"Test_Data","TC001_Create_an_Account");
		
		return dc.dataArray();
		
}
	//@Test
	//public void readingDatafromxlsxfile() {
		
		//ExcelReader excel = new ExcelReader("D:\\Sandip\\QSP\\QSPTech\\src\\test\\resources\\testData\\Master_Sheet.xlsx");
		
		//excel.addSheet("Test1234");
		
		//excel.removeSheet("Test1234");
		
		//excel.addColumn("Test_Cases", "Comments");

		//System.out.println(excel.isSheetExist("Test_Data"));

		// excel.getCellData("Test_Cases", 1, 4);

		// excel.setCellData("Test_Cases", "Comments", 4, "Good Work");

		// excel.setCellData("Test_Cases", "Comments", 3, "Good Job"
		
	
	
	
	//@Test
	public void hashtable() {
		
		Hashtable<String,String> htdata = new Hashtable<String,String>();
		
		htdata.put("FirstName", "Rahul");
		htdata.put("FirstName1", "Sandip");
		htdata.put("FirstName2", "Prashant");
		htdata.put("FirstName3", "Praveen");
		htdata.put("FirstName4", "ManSingh");
		htdata.put("FirstName5", "Nehesh");
		htdata.put("FirstName6", "Ritu");
		
		
		System.out.println(htdata.get("FirstName"));
		System.out.println(htdata.get("FirstName1"));
		System.out.println(htdata.get("FirstName4"));
		System.out.println(htdata.get("FirstName2"));
		System.out.println(htdata.get("FirstName5"));
		System.out.println(htdata.get("FirstName3"));
		System.out.println(htdata.get("FirstName6"));
		
	}
	
	

}
