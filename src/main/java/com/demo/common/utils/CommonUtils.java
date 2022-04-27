package com.demo.common.utils;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.ch.constants.FileConstants;
import com.ch.report.utils.AbstractTestCaseReport;
import com.ch.utils.DriverFactory;
import com.ch.utils.PropertyUtil;
import com.ch.utils.SeleniumUtils;
import com.ch.utils.Type;

public class CommonUtils {

	public static void loadAUTUrl() throws IOException {
		String url = "";
		if (AbstractTestCaseReport.runConfig.getEnvironment() == null) {
			String environment = PropertyUtil.getInstance().getConfigValue("ENVIRONMENT");
			AbstractTestCaseReport.runConfig.setEnvironment(environment);
		}
		if (AbstractTestCaseReport.runConfig.getEnvironment().equalsIgnoreCase("Dev")) {

			url = getAutUrl(AbstractTestCaseReport.runConfig.getEnvironment(), "AUT_URL_DEV");
			AbstractTestCaseReport.runConfig.setAutURL(url);
		} else if (AbstractTestCaseReport.runConfig.getEnvironment().equalsIgnoreCase("stage")) {
			url = getAutUrl(AbstractTestCaseReport.runConfig.getEnvironment(), "AUT_URL_STAGE");
			AbstractTestCaseReport.runConfig.setAutURL(url);

		}
		AbstractTestCaseReport.runConfig.setAutURL(url);
		SeleniumUtils.getURL(url);
		System.out.println("----------" + url + "----------------------");

//................Below is old implementation..............//
//
//		String url = "";
//
//		if (TestBase.runConfig.getBrowser().equalsIgnoreCase("IE")
//				|| TestBase.runConfig.getBrowser().equalsIgnoreCase("Edge")) {
//			Runtime.getRuntime().exec(FileConstants.AUTH_IE);
//		}
//		if (TestBase.runConfig.getBrowser().equalsIgnoreCase("IE")
//				|| TestBase.runConfig.getBrowser().equalsIgnoreCase("Edge")) {
//			SeleniumUtils.getURL(PropertyUtil.getPropertyValue(ObjectConstants.KSNA_STAGE_URL_WITHOUT_CREDENTIALS,
//					FileConstants.SERVER_PROPERTY_FILE));
//			url = PropertyUtil.getPropertyValue(ObjectConstants.KSNA_STAGE_URL_WITHOUT_CREDENTIALS,
//					FileConstants.SERVER_PROPERTY_FILE);
//			SeleniumUtils.wait(3);
//			try {
//				((JavascriptExecutor) DriverFactory.getDriver())
//						.executeScript("javascript:document.getElementById('invalidcert_continue').click()");
//			} catch (Exception e) {
//			}
//		} else {
//			System.out.println("----------"+PropertyUtil.getPropertyValue(ObjectConstants.KSNA_STAGE_URL_WITH_CREDENTIALS,
//					FileConstants.SERVER_PROPERTY_FILE));
//			SeleniumUtils.getURL(PropertyUtil.getPropertyValue(ObjectConstants.KSNA_STAGE_URL_WITH_CREDENTIALS,
//					FileConstants.SERVER_PROPERTY_FILE));
//			url = PropertyUtil.getPropertyValue(ObjectConstants.KSNA_STAGE_URL_WITH_CREDENTIALS,
//					FileConstants.SERVER_PROPERTY_FILE);
//           closeToolTip();
//		}
//
//		
	}
	
	private static String getAutUrl(String environment, String envValue) {

		String url = null;
		if (environment != null) {
			// if (environment.equalsIgnoreCase("dev")) {
			url = PropertyUtil.getInstance().getPropertyValue(envValue, FileConstants.SERVER_PROPERTY_FILE);
			// }
			// else if (environment.equalsIgnoreCase("stage")) {
			// url = PropertyUtil.getPropertyValue("AUT_URL_STAGE",
			// FileConstants.SERVER_PROPERTY_FILE);

			// }
		}
		return url;
	}

	
	public static void desktopView() {
		DriverFactory.getDriver().manage().window().maximize();
	}

	public static void mobileView() {
	
	}


	public static void closePopup() {

		try {
			SeleniumUtils.wait(4);

			if ((DriverFactory.getDriver().findElement(By.xpath("//*[@title='Sign Up via Text for Offers']")))
					.isDisplayed()) {
				SeleniumUtils.wait(3);
				WebElement iframe = DriverFactory.getDriver()
						.findElement(By.xpath("//*[@title='Sign Up via Text for Offers']"));
				DriverFactory.getDriver().switchTo().frame(iframe);
				SeleniumUtils.wait(2);
				SeleniumUtils.click(Type.XPATH, "//*[@id='closeIconContainer']");
				SeleniumUtils.wait(2);
				SeleniumUtils.switchingDefaultContent();
				SeleniumUtils.wait(5);
			} else {
				SeleniumUtils.wait(2);
				SeleniumUtils.keys(Keys.ESCAPE);
			}

		} catch (Exception e) {

		}

	}

}
