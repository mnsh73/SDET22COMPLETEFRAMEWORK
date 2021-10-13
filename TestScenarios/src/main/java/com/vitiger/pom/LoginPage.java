package com.vitiger.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage

{
	
	@FindBy(name="user_name") private WebElement usertb;
	@FindBy(name="user_password")private WebElement passtb;
	@FindBy(id="submitButton")private WebElement logbtn;
	@FindBy(xpath = "//a[text()='vtiger']") private WebElement cloudlink;

	public WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);		
	}

	public WebElement getUsertb() {
		return usertb;
	}
	public void coludversion()
	{
		cloudlink.click();
	}

	public WebElement getCloudlink() {
		return cloudlink;
	}

	public WebElement getPasstb() {
		return passtb;
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
