package com.vitiger.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganisationInfo 
{
	@FindBy(xpath="//span[@class='dvHeaderText']")private WebElement Successfmsg;
	@FindBy(id="dtlview_Email Opt Out") private WebElement emailoptouttb;
	@FindBy(id="mouseArea_Assigned To")private WebElement assignedTo;



	

	public WebDriver driver;
	public OrganisationInfo(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	public WebElement getSuccessfmsg() {
		return Successfmsg;
	}

	public WebElement getEmailoptouttb() {
		return emailoptouttb;
	}
	public WebElement getAssignedTo() {
		return assignedTo;
	}
	
	
}
