package com.vitiger.testScript2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.vitiger.pom.HomePage;
import com.vitiger.pom.LoginPage;
import com.vitiger.pom.OrganisationInfo;
import com.vitiger.pom.OrganisationPage;
import com.vitiger.pom.createNeworg;

import GenericLibraries.ExelUtility;
import GenericLibraries.FileUtility;
import GenericLibraries.JavaUtility;
import GenericLibraries.WebDriverUtility;

public class tc_10CreateOrgWithAssignedtoAsAdministrator 
{
public static void main(String[] args) throws Throwable
	
	{	
		WebDriver driver =null;
		WebDriverUtility util= new WebDriverUtility();
		JavaUtility j= new JavaUtility();
		ExelUtility eutil= new ExelUtility();
		FileUtility file = new FileUtility();
		String URL= file.getPropertyKeyValue("url");
		String USERNAME= file.getPropertyKeyValue("username");
		String PASS= file.getPropertyKeyValue("password");
		String BROWSER = file.getPropertyKeyValue("browser");
		
		if(BROWSER.equals("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(BROWSER.equals("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else if(BROWSER.equals("internetexplorer"))
		{
			driver = new InternetExplorerDriver();
		}
		else {
			driver= new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	// Store the test datas required
		
		String ORGNAME=eutil.getExelData("org", 1,1)+""+j.getRandonData();
		
		
		
//Step1 Login to page		
		LoginPage login = new LoginPage(driver);		
		login.loginApp(USERNAME ,PASS);
		
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
		util.waitForElementVisibility(driver,orgf.getAssignedTo() );
		String actualmsg= orgf.getAssignedTo().getText();
		if (actualmsg.contains("Administrator"))
				{
			System.out.println("Test case Passed "+ORGNAME+" created with  "+actualmsg+" ==> TestCAse passed");
			
				}
		else {
			System.out.println("Test case failed");
		}
		
//signOut
		
		home.signout();
		
//close the browser
		driver.close();
	}

}
