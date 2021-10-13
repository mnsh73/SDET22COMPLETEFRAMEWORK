package TestScript;

import java.util.Iterator;
import java.util.Set;

import org.testng.Reporter;
import org.testng.annotations.Test;

import GenericLibraries.BaseTestClass;
import GenericLibraries.FileUtility;
import pom.PomCase6;
import pom.VitgerLoginPage;

public class TC_01Organisation6 extends BaseTestClass
{
	@Test
	public void TestCase1() throws Throwable 
	{
		FileUtility fi= new FileUtility();
		VitgerLoginPage vtlg= new VitgerLoginPage(driver);
		vtlg.usernameenter(fi.getPropertyKeyValue("username"));
		vtlg.passenter(fi.getPropertyKeyValue("password"));
		//vtlg.passenter(fil.getPropertyKeyValue("password");
		Thread.sleep(2000);
		vtlg.logi();
		
		PomCase6 pm1 =new PomCase6(driver);
		pm1.clkorg();
		pm1.clkorgplus();
		// now switch the window
		pm1.orgname(eutil.getExelData("sheet1", 10, 2));
		String parent= driver.getWindowHandle();
		pm1.memberplus();
		
		Set<String> child = driver.getWindowHandles();
		Iterator<String> itr = child.iterator();
		String p = itr.next();
		String c = itr.next();
		driver.switchTo().window(c);
		
	/*
		for(String alwin:child)
		{
			driver.switchTo().window(alwin);
			
		}
		
		*/
		//String expectedtitle ="Organisation";
		System.out.println("Organisation");
		//String actualtitle = driver.getTitle(c);
		System.out.println(driver.getTitle());
		pm1.selectorg();
		//handle the alert popup
		utility.accetAtllert(driver);
		driver.switchTo().window(parent);
		
		
		Thread.sleep(5000);
		pm1.drp();
		utility.SelectOption(pm1.getDrop(), "Banking");
		pm1.saveit();
		//pm1.memberclear();
		Thread.sleep(3000);
		utility.mouseOver(driver, pm1.getAdmbtn());
		pm1.getSignoubtn().click();
		vtlg.usernameenter(fi.getPropertyKeyValue("username"));
		vtlg.passenter(fi.getPropertyKeyValue("password"));
		//vtlg.passenter(fil.getPropertyKeyValue("password");
		Thread.sleep(2000);
		vtlg.logi();
		pm1.clkorg();
		pm1.clkorg();
		Thread.sleep(2000);		
		
		
		
		//utility.switchToWindow(driver,);
		
		
		
		
				
		
		
	}

}
