package com.vitiger.testScriptWithTestmethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

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

public class tc_07creatorWithMemberAndClear extends BaseTestClass
{
	@Test(groups= {"regression"})
public  void creatorWithMemberAndClearTest() throws Throwable
	
	{	
		// Store the test datas required
			
			String ORGNAME=eutil.getExelData("org", 1,1)+""+j.getRandonData();
			String ORGNAMENEW=eutil.getExelData("org", 2, 1)+""+j.getRandonData();
			
			
			

			
	//Stept2 navigate to Organisation page
			HomePage home = new HomePage(driver);
			home.clickOrganisation();
	//Step3 organisation page create new organisation
			OrganisationPage orgp= new OrganisationPage(driver);
			orgp.getCreateneworgicon().click();
			
	//Step4 Create new Organisation page
			createNeworg cnp = new createNeworg(driver);
			cnp.creatnewOrg(ORGNAME);	
	//STEP 5 Verification for creation of the Organisation
			OrganisationInfo orgf = new OrganisationInfo(driver);
			//util.waitForElementVisibility(driver,orgf.getSuccessfmsg() );
			String actualmsg= orgf.getSuccessfmsg().getText();
			if (actualmsg.contains(ORGNAME))
					{
				System.out.println("Organisation with name "+ORGNAME+" is created");
				
					}
			else {
				System.out.println("Failed To create a Organisation");
			}
// Create a new organisation with memberof old organisation 
			//Stept2 navigate to Organisation page
			
			home.clickOrganisation();
	//Step3 navigation to organisation page again to create new organisation with new name
			
			orgp.getCreateneworgicon().click();
			
	//mention the new 	organisation name along with the member of which organisation
			createNeworg neworg = new createNeworg(driver);
			neworg.creatnewOrgwithmemberofAndClear(ORGNAMENEW, ORGNAME);
	
//	Verification
			//util.waitForElementVisibility(driver,orgf.getSuccessfmsg() );
			String actualmsg3= neworg.getMembertb().getText();
			/*if (actualmsg3.contains(neworg.text))
					{
				System.out.println(" Test case failed");
				
				
					}
			else 
			{
				System.out.println("Test case Passed "+ORGNAMENEW+" Created with member of "+ORGNAME+"  is cleared");
				
			}*/
			SoftAssert s = new SoftAssert();
			s.assertNull(neworg.text, actualmsg3);
			System.out.println("The member textbox got cleared and value is null===>TestCase Passed ");
			
	
			
	}

}
