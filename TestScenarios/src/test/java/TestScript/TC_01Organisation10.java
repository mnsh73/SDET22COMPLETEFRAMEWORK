package TestScript;

import java.util.Iterator;
import java.util.Set;

import org.testng.annotations.Test;

import GenericLibraries.BaseTestClass;
import GenericLibraries.FileUtility;
import pom.PomCase6;
import pom.VitgerLoginPage;

public class TC_01Organisation10 extends BaseTestClass

{

	@Test
	public void TestCase10() throws Throwable 
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
		pm1.orgname(eutil.getExelData("sheet1", 10, 1));
		pm1.memberplus();
		
		Set<String> child = driver.getWindowHandles();
		Iterator<String> itr = child.iterator();
		String p = itr.next();
		String c = itr.next();
		driver.switchTo().window(c);
		pm1.selectorg();
		//handle the alert popup
		utility.accetAtllert(driver);
		driver.switchTo().window(p);
	
		Thread.sleep(5000);
		pm1.drp();
		utility.SelectOption(pm1.getDrop(), "Banking");
		pm1.emailopt();
		
		if(pm1.getEmailptbox().isEnabled())
		{
			System.out.println("The email optout is enabled");
		}
		else
		{
			System.out.println("The email optout is not enabled");
		}
		pm1.enterdes("SDET ENGINEER");
		pm1.enterweb("www.WesternDigital.com");
		pm1.tkt("50K");
		
		//pm1.memberclear();
		pm1.enterphone("12345655");
		pm1.bill("Banglore");
		
		pm1.saveit();
		Thread.sleep(3000);

}

}
