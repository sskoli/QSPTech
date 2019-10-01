package com.ProjectName.ModuleName.testBase;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.AutomationWorldByRahul.SeleniumTraining.DataCollection;
import com.AutomationWorldByRahul.SeleniumTraining.ExcelReader;

public class TestBase {
	
	WebDriver driver;
	Properties config;
	Properties OR;
	
	static ExcelReader excel=new ExcelReader("D:\\Sandip\\QSP\\QSPTech\\src\\test\\resources\\testData\\Master_Sheet.xlsx");
	
	@BeforeSuite
	public void loadingFiles() throws IOException{
		
		config=new Properties();
		FileInputStream fis1=new FileInputStream("D:\\Sandip\\QSP\\QSPTech\\src\\test\\resources\\propertiesFiles\\config.properties");
		config.load(fis1);
		
		OR=new Properties();
		FileInputStream fis2=new FileInputStream("D:\\Sandip\\QSP\\QSPTech\\src\\test\\resources\\propertiesFiles\\OR.properties");
		OR.load(fis2);

		if(config.getProperty("Browser").equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//src//test//resources//driver//chromedriver.exe");
			driver = new ChromeDriver();
		}else if(config.getProperty("Browser").equalsIgnoreCase("Firefox")){
			System.setProperty("webdriver.gekco.driver", System.getProperty("user.dir")+"src\\test\\resources\\driver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}else if(config.getProperty("Browser").equalsIgnoreCase("IE")){
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"src\\test\\resources\\driver\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.get(config.getProperty("Application_URL"));
		System.out.println("Gmail URL has been Launched");
		
		
	}
	
	@DataProvider
	public static Object[][] Data_Collections() {
		
		DataCollection dc=new DataCollection(excel, "Test_data", "TC001_Create_an_Account2222");
		return dc.dataArray();
	}
		
	}


