package utility;

import java.util.logging.LogManager;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Optional;

public class BaseClass 
{
	static {
		LogManager.getLogManager().reset();
	}
	protected WebDriver driver;
	
	@BeforeSuite
	public void beforeSuite()
	{
		System.out.println("Before suite");
	}
	@BeforeTest
	public void beforeTest()
	{
		System.out.println("Before test");
	}
	@BeforeClass
	public void beforeClass()
	{
		System.out.println("Before class");
	}
//	@BeforeMethod
//	public void beforeMethod()
//	{
//		   System.out.println("Before method");
//		   driver=new ChromeDriver();
//		   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
////	       open HRM
//		   
//		   driver.get(DataUtility.getEnvironmentDetails("URL"));
//	       
////	   	   maximize window
//		   
//	       driver.manage().window().maximize();
//	}
//	
	@AfterSuite
	public void afterSuite()
	{
		System.out.println("@After suite");
	}
	@AfterTest
	public void afterTest()
	{
		System.out.println("@After test");
	}
	@AfterClass
	public void afterClass()
	{
		System.out.println("@After class");
	}
	
	@Parameters("browser")
	@BeforeMethod(alwaysRun = true)
	public void beforeMethod(@Optional("chrome") String browser)
	{
		   WebDriver driver=null;
		   
		   System.out.println("Before method");
		   // create local variable driver
//		   ChromeOptions options=new ChromeOptions();
//		   options.addArguments("--headless");
		   switch(browser.toLowerCase())
		   {
		   case "chrome": driver = new ChromeDriver();break;
		   case "msedge": driver = new EdgeDriver();break;
		   case "firefox": driver = new FirefoxDriver();break;
		   default : System.out.println("Something went worng....");
		   }
		   
	       driver.manage().window().maximize();
	       
	       //give that driver to ThreadLocal
	       DriverManager.setDriver(driver);
	       
	       //get the current thread driver from thread local
	       this.driver = DriverManager.getDriver();
	       
	       
	}
	@AfterMethod(alwaysRun = true)
	public void afterMethod()
	{
		System.out.println("@After method");
		DriverManager.closeDriver();
	}

	

}
