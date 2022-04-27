package com.demo.desktoppages;

import com.ch.excelutils.ExcelProperty;
import com.ch.reports.FrameworkException;
import com.demo.common.utils.ModuleNames;
import com.demo.common.utils.ObjectConstants;
import com.demo.pages.AbstractGlobalPage;

public class GlobalPage extends AbstractGlobalPage {

	public GlobalPage() throws FrameworkException {
		newcategory = ExcelProperty.getElementValue(ModuleNames.GLOBAL, ObjectConstants.NEW_CATEGORY);
		handbagsCategory = ExcelProperty.getElementValue(ModuleNames.GLOBAL, ObjectConstants.HANDBAGS_CATEGORY);
		clothingCategory = ExcelProperty.getElementValue(ModuleNames.GLOBAL, ObjectConstants.CLOTHING_CATEGORY);
	}
}
