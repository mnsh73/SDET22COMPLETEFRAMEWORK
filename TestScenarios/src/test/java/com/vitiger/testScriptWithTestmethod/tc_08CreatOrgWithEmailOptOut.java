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

public class tc_08CreatOrgWithEmailOptOut extends BaseTestClass
{
	@Test(groups= {"smokeTest"})
public  void CreatOrgWithEmailOptOutTest() throws Throwable
	
	{	
		
		// Store the test datas required
			
			String ORGNAME=eutil.getExelData("org", 3,1)+""+j.getRandonData();
			//String ORGNAMENEW=eutil.getExelData("org", 2, 1)+""+j.getRandonData();
			
			
			
	//Step1 Login to page		
			//done in the base class
			
	//Stept2 navigate to Organisation page
			HomePage home = new HomePage(driver);
			home.clickOrganisation();
	//Step3 organisation page create new organisation
			OrganisationPage orgp= new OrganisationPage(driver);
			orgp.getCreateneworgicon().click();
			
	//Step4 Create new Organisation page with Email OptOut
			createNeworg cnp = new createNeworg(driver);
			cnp.createOrgwithemailoptout(ORGNAME);
	//Step 5 navigate to  on organisation to check 
			//home.getHomebtn().click();		
			//home.clickOrganisation();
			//cnp.findthecreatedOrg(ORGNAME);
			
			
			
	//STEP 5 Verification for creation of the Organisation
			OrganisationInfo orgf = new OrganisationInfo(driver);
			
			utility.waitForElementVisibility(driver,orgf.getEmailoptouttb() );
			
			String actualmsg= orgf.getEmailoptouttb().getText();
			System.out.println(actualmsg);
			if (actualmsg.contains("yes"))
					{
				System.out.println("Organisation with name "+ORGNAME+" is created with email optOut==> TestCase Passed");
				
					}
			else {
				System.out.println("Failed To create a Organisation");
				}
			
		
	}
}
