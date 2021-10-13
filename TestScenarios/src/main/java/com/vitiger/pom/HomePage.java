package com.vitiger.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericLibraries.WebDriverUtility;

public class HomePage
{
	public WebDriver driver;
	
	@FindBy (xpath="//img[@style='width:16px;height:16px;']") private WebElement homebtn;
	@FindBy(xpath="//a[text()='Calendar']") private WebElement calendarbtn;
	@FindBy(xpath="//a[text()='Leads']") private WebElement leadsbtn;
	@FindBy(xpath="//a[text()='Organizations']") private WebElement organisationrbtn;
	@FindBy(xpath="//a[text()='Contacts']")private WebElement contactsbtn;
	@FindBy(xpath="//a[text()='Products']")private WebElement productsbtn;
	@FindBy(xpath="//a[text()='Opportunities']")private WebElement opportunitybtn;
	@FindBy(xpath="//a[text()='Documents']")private WebElement documentbtn;
	@FindBy(xpath="//a[text()='Email']")private WebElement emailbtn;
	@FindBy(xpath="//a[text()='Trouble Tickets']")private WebElement troubletktbtn;
	@FindBy(xpath="//a[text()='Dashboard']")private WebElement dashbtn;
	@FindBy(xpath="//a[text()='More']")private WebElement more;
	@FindBy(id="qccombo")private WebElement quickCreatedrpdown;
	@FindBy(xpath="//img[@style='padding: 0px;padding-left:5px']")private WebElement adminmover;
	//@FindBy(xpath="//img[@style='padding: 0px;padding-left:5px']")private WebElement admbtn;
	@FindBy(id="_my_preferences_")private WebElement mypreferences;
	@FindBy(xpath="//a[text()='Sign Out']")private WebElement signoutbtn;
	@FindBy(xpath = "//img[@style='padding: 0px;padding-left:5px ")private WebElement crmsettingmover;
	@FindBy(xpath="//a[text()='CRM Settings']") private WebElement crmsettingbtn;
	@FindBy(name="query_string")private WebElement searchtb;
	@FindBy(xpath="//input[@class='searchBtn']")private WebElement searchbtn;
	
	
	public WebDriverUtility utility= new WebDriverUtility();
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOrganisation()
	{
		organisationrbtn.click();
	}
	public void signout()
	{
		Actions a = new Actions(driver);
		a.moveToElement(adminmover).perform();
		signoutbtn.click();	
		/*utility.mouseOver(driver, adminmover);
		signoutbtn.click();*/
	}
	
	public WebElement getAdminmover() {
		return adminmover;
	}
	public WebElement getSignoutbtn() {
		return signoutbtn;
	}
	public WebElement getHomebtn() {
		// TODO Auto-generated method stub
		return homebtn;
	}

}
