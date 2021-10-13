package GenericLibraries;

import java.io.File;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot implements IpathConstant
{
	public String getPhoto(WebDriver driver, String name) throws Throwable
	{
		Date d = new Date();
		String date = d.toString();
		
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(PHOTOPATH+date+name+".png");
		FileUtils.copyFile(src,dest);
		//FileUtils.copyFile(src, dest); this statement need a jar apache common io , add the dependency
		
		return name;
	}

}
