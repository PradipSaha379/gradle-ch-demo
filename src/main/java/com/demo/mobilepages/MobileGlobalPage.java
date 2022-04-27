package com.demo.mobilepages;

import com.ch.excelutils.ExcelProperty;
import com.ch.reports.FrameworkException;
import com.demo.common.utils.ModuleNames;
import com.demo.common.utils.ObjectConstants;
import com.demo.pages.AbstractGlobalPage;

public class MobileGlobalPage extends AbstractGlobalPage {

	public MobileGlobalPage() throws FrameworkException {
		newcategory = ExcelProperty.getElementValue(ModuleNames.M_GLOBAL, ObjectConstants.NEW_CATEGORY);
		handbagsCategory = ExcelProperty.getElementValue(ModuleNames.M_GLOBAL, ObjectConstants.HANDBAGS_CATEGORY);
		clothingCategory = ExcelProperty.getElementValue(ModuleNames.M_GLOBAL, ObjectConstants.CLOTHING_CATEGORY);
	}
}
