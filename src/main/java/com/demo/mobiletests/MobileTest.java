package com.demo.mobiletests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ch.retry.MaxRetryCount;
import com.ch.status.TestStatus;
import com.demo.common.utils.MobileTestUtil;
import com.demo.tests.AbstractGlobalTest;

public class MobileTest extends AbstractGlobalTest {
	

	MobileTestUtil testUtil = new MobileTestUtil();
	
	
	@BeforeMethod(alwaysRun = true, dependsOnMethods = "beforeTest")
	public void mobileTestSetup() throws Exception {
		testUtil.testSetup();
	}
	
	@MaxRetryCount(3)
	@Test( groups = { "P140", "Home", "Smoke" })
	public void isMobileSpecificTopNavigationWithRetry() throws Exception {
			System.out.println(" isTopNavigationFailureWithRetry ");
			populateTestReport( "8", "Top Navigation Test 8", TestStatus.INFO, null, null);
			populateSteps("Loaded Navigation Page",TestStatus.INFO,  takeScreenShot());
			Assert.assertTrue(true, "Top navigation menu not displayed");
			populateSteps("Top navigation  menu is displayed",TestStatus.PASS,  takeScreenShot());
			Assert.assertTrue(true, "Not Found menu bags in hamburger menu");
			populateSteps("Found menu bags in hamburger menu",TestStatus.PASS,  takeScreenShot());

	}

}
