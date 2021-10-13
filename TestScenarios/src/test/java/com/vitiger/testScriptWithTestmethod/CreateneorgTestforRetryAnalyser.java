package com.vitiger.testScriptWithTestmethod;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


public class CreateneorgTestforRetryAnalyser
{
	@Test(retryAnalyzer=GenericLibraries.RetryAnalyser.class)
	public void CreateNeworgretryTestretry()
	{
		System.out.println("Creat Organisation test case failed");
		Assert.fail();
	}

}
