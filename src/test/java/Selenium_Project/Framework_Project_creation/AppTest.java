package Selenium_Project.Framework_Project_creation;



import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import ObjectRepository.Registerpage;
import ObjectRepository.UserId;
import ObjectRepository.Webpage;
import Utilites.CrossBrowser;
import Utilites.ExcelSheet;


/**
 * Unit test for simple App.
 */
public class AppTest 
{
	WebDriver driver;
	String[]data=new String[5];
	ExtentReports report=new ExtentReports();
	ExtentSparkReporter sparkreport=new ExtentSparkReporter("C:\\Users\\owner\\Workspace\\Shaidul\\Nexxvali\\Framework_Project_creation\\target\\report.html");
	ExtentTest test=report.createTest("Register Now");
	
	@BeforeMethod()
	public void browser() throws IOException
	{
		
	CrossBrowser br=new CrossBrowser();
	driver=br.browser_initiate();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	
	}
	
	@Test()
	@Parameters({"Firstname","Lastname","email","phone","add1","add2","city","state","zip","country"})
		public void Programming(String a,String a1,String a2,String a3,String a4,String a5,String a6,String a7,String a8,String a9) throws IOException, InterruptedException
	{
		Webpage w=new Webpage(driver);
		w.signin();
		Registerpage r=new Registerpage(driver);
		r.register();
		test.log(Status.PASS, "Welcome to register page");
		ExcelSheet e=new ExcelSheet();
		data=e.readExcel();
		String user=data[0];
		String newpass=data[1];
		String repass=data[2];
		UserId u=new UserId(driver);
		u.User_Info(user, newpass,repass);
		test.log(Status.PASS, "Excel data passed to complete profile information");
		Thread.sleep(1000);
		
		driver.findElement(By.name("account.firstName")).sendKeys(a);
		 driver.findElement(By.name("account.lastName")).sendKeys(a1);
		 driver.findElement(By.name("account.email")).sendKeys(a2);
		 driver.findElement(By.name("account.phone")).sendKeys(a3);
		 driver.findElement(By.name("account.address1")).sendKeys(a4);
		 driver.findElement(By.name("account.address2")).sendKeys(a5);
		 driver.findElement(By.name("account.city")).sendKeys(a6);
		 driver.findElement(By.name("account.state")).sendKeys(a7);
		 driver.findElement(By.name("account.zip")).sendKeys(a8);
		 driver.findElement(By.name("account.country")).sendKeys(a9);
		 test.log(Status.PASS, "Parameters has been used to pass to complete the account information");
	
	
		WebElement ele=driver.findElement(By.name("account.languagePreference"));
		Select s=new Select(ele);
		s.selectByVisibleText("japanese");
		Thread.sleep(2000);
		WebElement ele2=driver.findElement(By.name("account.favouriteCategoryId"));
		Select s2=new Select(ele2);
		s2.selectByVisibleText("CATS");
		driver.findElement(By.xpath("//*[@id=\"Catalog\"]/form/table[3]/tbody/tr[3]/td[2]/input")).click();
		driver.findElement(By.xpath("//*[@id=\"Catalog\"]/form/table[3]/tbody/tr[4]/td[2]/input")).click();
		test.log(Status.PASS, "Profile information provided");
	
		driver.findElement(By.xpath("//*[@id=\"Catalog\"]/form/input")).click();
		test.log(Status.PASS, "Saved all the information successfully");
		Thread.sleep(2000);
		test.log(Status.FAIL, "registration failed");
		
		String title=driver.getTitle();
		System.out.println(title);
		String url=driver.getCurrentUrl();
		System.out.println(url);
	
		
	
		TakesScreenshot shot=(TakesScreenshot) driver;
		File src=shot.getScreenshotAs(OutputType.FILE);
		File destination=new File("C:\\Java_class_demo_Nexvali\\Screenshot\\shot.jpeg");
		FileUtils.copyFile(src, destination);
		Thread.sleep(1000);
		report.attachReporter(sparkreport);
		report.flush();
		
	}
	@AfterMethod()
	  public void teardown()
	  {
		driver.close();
	  
		  
	}
    
}

