package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VitgerLoginPage 
{
	@FindBy(name="user_name") private WebElement usertb;
	@FindBy(name="user_password")private WebElement passtb;
	@FindBy(id="submitButton")private WebElement logbtn;
	public WebElement getUsertb() 
	{
		return usertb;
	}
	public WebElement getPasstb() {
		return passtb;
	}
	
	public VitgerLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void usernameenter(String username)
	{
		usertb.sendKeys(username);
	}
	public void passenter(String password)
	{
		passtb.sendKeys(password);
		
	}
	public void logi()
	{
		logbtn.click();
	}
	public WebElement getLogbtn() {
		return logbtn;
	}
	public void loginApp(String username, String pass)
	{
		usertb.sendKeys(username);
		passtb.sendKeys(pass);
		logbtn.click();
		
		
	}
	

}
