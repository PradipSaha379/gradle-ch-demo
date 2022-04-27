package com.demo.pages;

import java.time.Duration;

import com.ch.excelutils.ExcelBean;
import com.ch.reports.FrameworkException;
import com.ch.utils.SeleniumUtils;

public class AbstractGlobalPage {

	
	protected ExcelBean newcategory = null;
	protected ExcelBean handbagsCategory = null;
	protected ExcelBean clothingCategory = null;
	/**
	 * Checks if is top navigation displayed in Home page
	 *
	 * @return true, if is top navigation displayed
	 * @throws FrameworkException
	 */
	public boolean isTopNavigationDisplayed() throws FrameworkException {
		SeleniumUtils.waitUntilVisibilityOfElement(newcategory, 3);
		SeleniumUtils.waitUntilElementToBeSelectedWithFluentWait(handbagsCategory, Duration.ofSeconds(3), Duration.ofSeconds(1));

		boolean flag = false;

		flag = SeleniumUtils.iSDisplayed(newcategory, 3);
		flag = SeleniumUtils.iSDisplayed(handbagsCategory, 4) && flag;
		flag = SeleniumUtils.iSDisplayed(clothingCategory, 4) && flag;
		return flag;
	}

}
