package com.vitiger.testScriptWithTestmethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

import com.vitiger.pom.HomePage;
import com.vitiger.pom.LoginPage;
import com.vitiger.pom.OrganisationInfo;
import com.vitiger.pom.OrganisationPage;
import com.vitiger.pom.createNeworg;

import GenericLibraries.BaseTestClass;
import GenericLibraries.ExelUtility;
import GenericLibraries.FileUtility;
import GenericLibraries.JavaUtility;
import GenericLibraries.WebDriverUtility;

public class tc_09CreateOrgWithEmailoptOutCheck extends BaseTestClass
{
	@Test(groups= {"regression"})
public void CreateOrgWithEmailoptOutCheckTest() throws Throwable
	
	{	
			
		
		// Store the test datas required
			
			String ORGNAME=eutil.getExelData("org", 3,1)+""+j.getRandonData();
			//String ORGNAMENEW=eutil.getExelData("org", 2, 1)+""+j.getRandonData();
			
			
			
	
			
	//Stept2 navigate to Organisation page
			HomePage home = new HomePage(driver);
			home.clickOrganisation();
	//Step3 organisation page create new organisation
			OrganisationPage orgp= new OrganisationPage(driver);
			orgp.getCreateneworgicon().click();
			
	//Step4 Create new Organisation page with Email OptOut
			createNeworg cnp = new createNeworg(driver);
			cnp.checkAndcreateOrgwithemailoptout(ORGNAME);
	
			
			
			
	//STEP 5 Verification for creation of the Organisation
			OrganisationInfo orgf = new OrganisationInfo(driver);
			
			utility.waitForElementVisibility(driver,orgf.getEmailoptouttb() );
			
			String actualmsg= orgf.getEmailoptouttb().getText();
			//System.out.println(actualmsg);
			if (actualmsg.contains("yes"))
					{
				System.out.println("Organisation with name "+ORGNAME+" is created with email optOut==> TestCase failed");
				
					}
			else {
				System.out.println("email optout deselected again  To create a Organisation ==>Test case passed");
				}
		
	}
}
