package com.vitiger.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericLibraries.JavaUtility;
import GenericLibraries.WebDriverUtility;

public class OrganisationPage 
{
	@FindBy(xpath="//img[@title='Create Organization...']") private WebElement createneworgicon;
	@FindBy(xpath="//input[@name='search_text']")private WebElement searchtb;
	@FindBy(xpath="//select[@name='search_field']")private WebElement searchdrpdown;
	@FindBy(xpath="//input[@name='search']")private WebElement searchit;
	public WebElement getSearchtb() {
		return searchtb;
	}
	public WebElement getSearchdrpdown() {
		return searchdrpdown;
	}
	public WebElement getSearchit() {
		return searchit;
	}
	public void setCreateneworgicon(WebElement createneworgicon) {
		this.createneworgicon = createneworgicon;
	}
	WebDriverUtility utility = new WebDriverUtility();
	public WebDriver driver;
	public OrganisationPage(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	public WebElement getCreateneworgicon() {
		return createneworgicon;
	}
	
	
	
	
	



}
