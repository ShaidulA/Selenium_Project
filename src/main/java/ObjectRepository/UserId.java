package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserId {
	
	WebDriver driver;
	
	@FindBy(name="username")
	WebElement userid;
	
	@FindBy(name="password")
	WebElement newpass;
	
	@FindBy(name="repeatedPassword")
	WebElement repeatpass;
	
	
	public UserId(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void User_Info(String u, String n, String r)
	{
		userid.sendKeys(u);
		newpass.sendKeys(n);
		repeatpass.sendKeys(r);
	}

}
