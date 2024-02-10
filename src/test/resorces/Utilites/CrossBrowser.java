package Utilites;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CrossBrowser {
	WebDriver driver;
	String FilePath="C:\\Users\\owner\\Workspace\\Shaidul\\Nexxvali\\Framework_Project_creation\\Config.Properties//";
	
	
	public WebDriver browser_initiate() throws IOException 
	{

		
		FileInputStream fis=new FileInputStream(FilePath);
		
		Properties p=new Properties();
		p.load(fis);
		String browsername=p.getProperty("browser");
		switch(browsername)
		{
		case "chrome":
		{
			driver=new ChromeDriver();
			driver.get(p.getProperty("url"));
			break;
		}
		
		case "edge":
		{
			driver=new EdgeDriver();
			driver.get(p.getProperty("url"));
			break;
		}
		
		case "firefox":
		{
			driver=new FirefoxDriver();
			driver.get(p.getProperty("url"));
			break;
		}
		
		}
		return driver;
}

}
