package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import GenericLibraries.WebDriverUtility;

public class HiddenTooltip 
{
	//@FindBy(xpath="//div[text()='You hovered over the Button']") private WebElement tooltip;
	@Test
	public void Tooltipmesssage() throws Throwable
	{
		
		WebDriver driver = new ChromeDriver();
		WebDriverUtility utility = new WebDriverUtility();

		driver.manage().window().maximize();
		driver.get("https://demoqa.com/tool-tips");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement ele1 = driver.findElement(By.id("toolTipButton"));
		utility.mouseOver(driver, ele1);
		WebElement ele2 = driver.findElement(By.xpath("//div[text()='You hovered over the Button']"));
		String tooltiptext= ele2.getText();
		System.out.println(tooltiptext);
		WebElement ele3 = driver.findElement(By.id("toolTipTextField"));
		ele3.sendKeys(tooltiptext);
		Thread.sleep(5000);
		driver.close();
	
		
		
		
		
	}

}
