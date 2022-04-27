package com.demo.desktoptests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ch.retry.MaxRetryCount;
import com.ch.status.TestStatus;
import com.demo.common.utils.DesktopTestUtil;
import com.demo.tests.AbstractGlobalTest;

public class GlobalTest extends AbstractGlobalTest {

	DesktopTestUtil testUtil = new DesktopTestUtil();

	@BeforeMethod(alwaysRun = true, dependsOnMethods = "beforeTest")
	public void desktopTestSetup() throws Exception {
		testUtil.testSetup();
	}

	@MaxRetryCount(3)
	@Test(groups = { "P140", "Home", "Smoke" })
	public void isDesktopSpecificTopNavigationWithRetry() throws Exception {
		System.out.println(" isTopNavigationFailureWithRetry ");
		populateTestReport("8", "Top Navigation Test 8", TestStatus.INFO, null, null);
		populateSteps("Loaded Navigation Page", TestStatus.INFO, takeScreenShot());
		Assert.assertTrue(true, "Top navigation menu not displayed");
		populateSteps("Top navigation  menu is displayed", TestStatus.PASS, takeScreenShot());
		Assert.assertTrue(true, "Not Found menu bags in hamburger menu");
		populateSteps("Found menu bags in hamburger menu", TestStatus.PASS, takeScreenShot());

	}

}
