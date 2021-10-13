package com.vitiger.testScriptWithTestmethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GenericLibraries.BaseTestClass;

@Listeners(GenericLibraries.ListenerImpl.class)
public class tc_06 extends BaseTestClass
{
	@Test
	public void loginFailedTest()
	{
		Assert.assertEquals("a", "b");	
	}

}
