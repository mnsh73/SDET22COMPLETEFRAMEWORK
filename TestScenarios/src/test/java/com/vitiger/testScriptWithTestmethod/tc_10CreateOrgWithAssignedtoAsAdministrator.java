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

public class tc_10CreateOrgWithAssignedtoAsAdministrator extends BaseTestClass
{
	@Test
public  void CreateOrgWithAssignedtoAsAdministratorTest() throws Throwable
	
	{	
		
	// Store the test datas required
		
		String ORGNAME=eutil.getExelData("org", 1,1)+""+j.getRandonData();
		
		
		
//Step1 Login to page		
		
		
//Stept2 navigate to Organisation page
		HomePage home = new HomePage(driver);
		home.clickOrganisation();
//Step3 organisation page create new organisation
		OrganisationPage orgp= new OrganisationPage(driver);
		orgp.getCreateneworgicon().click();
		
//Step4 Create new Organisation page
		createNeworg cnp = new createNeworg(driver);
		cnp.creatnewOrg(ORGNAME);	
//STEP 5 Verification
		OrganisationInfo orgf = new OrganisationInfo(driver);
		utility.waitForElementVisibility(driver,orgf.getAssignedTo() );
		String actualmsg= orgf.getAssignedTo().getText();
		if (actualmsg.contains("Administrator"))
				{
			System.out.println("Test case Passed "+ORGNAME+" created with  "+actualmsg+" ==> TestCAse passed");
			
				}
		else {
			System.out.println("Test case failed");
		}
		

	}

}
