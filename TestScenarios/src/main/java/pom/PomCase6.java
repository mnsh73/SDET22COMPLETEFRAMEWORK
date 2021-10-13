package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PomCase6 
{
	@FindBy(xpath="//a[text()='Organizations']") private WebElement orgbtn;
	@FindBy(xpath="//img[@title='Create Organization...']") private WebElement plusbtn;
	@FindBy(name="accountname")private WebElement orgnametb;
	@FindBy(name="website") private WebElement webtb;
	@FindBy(name= "tickersymbol")private WebElement tkttb;
	@FindBy(xpath="//select[@name='industry']")private WebElement drop;
	@FindBy(xpath="//img[@style='cursor:hand;cursor:pointer']") private WebElement memberofbtn;
	//switch the window
	@FindBy(id="1")private WebElement selectorgbtn;
	//allow the allert popup
	//Switch to control back to previous page
	@FindBy(xpath="//textarea[@name='description']")private WebElement destb;
	@FindBy(xpath="//input[@id='phone']") private WebElement phontb;
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[2]")private WebElement savebtn;
	@FindBy(id="email1")private WebElement emailtb;
	@FindBy(xpath="//img[@style='padding: 0px;padding-left:5px']")private WebElement admbtn;
	@FindBy(xpath="//a[text()='Sign Out']") private WebElement signoubtn;
	@FindBy(id="bill_city")private WebElement billtb;

	@FindBy(xpath="//input[@title='Clear']") private WebElement clearbtn;
	
	//3rd  test case
	
	@FindBy(name="emailoptout")private WebElement emailptbox;
	//testcase 11
	@FindBy(xpath="//input[@value='T']")private WebElement usertb;
	@FindBy(xpath ="//select[@name='assigned_group_id']") private WebElement userselectdrpdn;
	//testcase 12
	@FindBy(xpath="//select[@name='rating']")private WebElement ratedrpdn;
	
	
	

	public PomCase6(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clkorg()
	{
		orgbtn.click();
	}
	public WebElement getDrop() {
		return drop;
	}

	public void clkorgplus()
	{
		plusbtn.click();
	}
	public void orgname(String orgname)
	{
		orgnametb.sendKeys(orgname);
	}
	public void webst(String web)
	{
		webtb.sendKeys(web);
	}
	public void tkt(String tk)
	{
		tkttb.sendKeys(tk);
		
	}
	public void memberplus()
	{
		memberofbtn.click();
	}
	public void selectorg()
	{
		selectorgbtn.click();
	}
	public void drp()
	{
		drop.click();
	}
	public void enterweb(String Website)
	{
		webtb.sendKeys(Website);
	}
	
	public void bill(String city)
	{
		billtb.sendKeys(city);
	}
	public void enterphone(String phone)
	{
		phontb.sendKeys(phone);
	}
	public void enterdes(String des)
	{
		destb.sendKeys(des);
	}
	public void memberclear()
	{
		clearbtn.click();
	}
	public WebElement getClearbtn() {
		return clearbtn;
	}
	public void emailopt()
	{
		emailptbox.click();
	}
	public void saveit()
	{
		savebtn.click();
	}

	

	public WebElement getSignoubtn() {
		return signoubtn;
	}

	public WebElement getAdmbtn() {
		return admbtn;
	}

	public WebElement getEmailptbox() {
		
		return emailptbox;
	}
	public WebElement getUsertb() {
		return usertb;
	}

	public WebElement getUserselectdrpdn() {
		return userselectdrpdn;
	}

	public WebElement getRatedrpdn() {
		return ratedrpdn;
	}
	
	

}
