package com.vitiger.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericLibraries.WebDriverUtility;
/**
 * 
 * @author MANISH
 *
 */

public class createNeworg
{
	public String text=null;
	
	public WebDriver driver;
	

	public createNeworg(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}
	WebDriverUtility util= new WebDriverUtility();
	
	
	@FindBy(name="accountname")private WebElement orgnametb;
	@FindBy(name="website") private WebElement webtb;
	@FindBy(name= "tickersymbol")private WebElement tkttb;
	@FindBy(xpath="//select[@name='industry']")private WebElement drop;
	@FindBy(xpath="//input[@name='account_name']")private WebElement membertb;
	public WebElement getMembertb() {
		return membertb;
	}
	@FindBy(xpath="//img[@style='cursor:hand;cursor:pointer']") private WebElement memberoficon;
	//switch the window
	@FindBy(id="1")private WebElement selectorgbtn;
	//allow the allert popup
	//Switch to control back to previous page
	@FindBy(xpath="//textarea[@name='description']")private WebElement destb;
	@FindBy(xpath="//input[@id='phone']") private WebElement phontb;
	@FindBy(xpath="//input[@title='Save [Alt+S]']")private WebElement savebtn;
	@FindBy(id="email1")private WebElement emailtb;
	@FindBy(xpath="//img[@style='padding: 0px;padding-left:5px']")private WebElement admbtn;
	@FindBy(xpath="//a[text()='Sign Out']") private WebElement signoubtn;
	@FindBy(id="bill_city")private WebElement billtb;

	@FindBy(xpath="//input[@title='Clear']") private WebElement clearbtn;
	@FindBy(name="emailoptout")private WebElement emailoptOutCheckbox;
	
	public WebElement getEmailoptOutCheckbox() {
		return emailoptOutCheckbox;
	}
	public WebElement getOrgnametb() {
		return orgnametb;
	
	}
	public void creatnewOrg(String orgname)
	{
		orgnametb.sendKeys(orgname);
		savebtn.click();
	}
	public void creatnewOrgwithmemberof(String orgname, String memberoforg) throws Throwable
	{
		orgnametb.sendKeys(orgname);
		memberoficon.click();
		util.switchToWindow(driver, "module=Accounts&action");
		OrganisationPage op= new OrganisationPage(driver);
		op.getSearchtb().sendKeys(memberoforg);
		op.getSearchit().click();
		Thread.sleep(5000);
		WebElement res = driver.findElement(By.xpath("//a[text()='"+memberoforg+"']"));
		util.waitForElementVisibility(driver, res);
		res.click();
		util.accetAtllert(driver);
		//window automatically gets closed
		util.switchToWindow(driver, "Organizations");
		//driver.switchTo().defaultContent();
		//Thread.sleep(3000);		
		savebtn.click();
	}
	public void creatnewOrgwithmemberofAndClear(String orgname, String memberoforg) throws Throwable
	{
		orgnametb.sendKeys(orgname);
		memberoficon.click();
		util.switchToWindow(driver, "module=Accounts&action");
		Thread.sleep(3000);
		OrganisationPage op= new OrganisationPage(driver);
		op.getSearchtb().sendKeys(memberoforg);
		op.getSearchit().click();
		Thread.sleep(5000);
		WebElement res = driver.findElement(By.xpath("//a[text()='"+memberoforg+"']"));
		util.waitForElementVisibility(driver, res);
		res.click();
		util.accetAtllert(driver);
		//window automatically gets closed
		util.switchToWindow(driver, "Organizations");
		//driver.switchTo().defaultContent();
		//Thread.sleep(3000);		
		 text =membertb.getText();
		 System.out.println(membertb.getText()); 
		System.out.println(text);
		clearbtn.click();
	}

	public void createOrgwithemailoptout(String orgname) {
		orgnametb.sendKeys(orgname);
		emailoptOutCheckbox.click();
		savebtn.click();		
	}
	public void findthecreatedOrg(String findorgname)
	{
		OrganisationPage op= new OrganisationPage(driver);
		op.getSearchtb().sendKeys(findorgname);
		op.getSearchit().click();
		WebElement res = driver.findElement(By.xpath("//a[text()='"+findorgname+"']"));
		util.waitForElementVisibility(driver, res);
		res.click();
		//util.accetAtllert(driver);

	}
	public void checkAndcreateOrgwithemailoptout(String orgname) throws Throwable {
		orgnametb.sendKeys(orgname);
		util.scrollToWebElement(driver, emailoptOutCheckbox);
		if(emailoptOutCheckbox.isSelected())
		{
			System.out.println("email opt out checked is  Selected");
		}
		else {
			System.out.println("email opt out is checked and found not Selected");
			
			emailoptOutCheckbox.click();	
			System.out.println("email opt out is clicked and  Selected");
			}
		Thread.sleep(2000);
		emailoptOutCheckbox.click();
		
		savebtn.click();		
	}
	
}

