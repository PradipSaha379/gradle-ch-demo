package com.demo.listeners;

import java.text.MessageFormat;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

import org.openqa.selenium.grid.config.ConfigException;
import org.testng.IAlterSuiteListener;
import org.testng.xml.XmlPackage;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

public class SuiteAlterListener implements IAlterSuiteListener {

	private final static Logger LOGGER = Logger.getLogger(SuiteAlterListener.class.getName());
	
	@Override
	public void alter(List<XmlSuite> suites) {
		XmlSuite suite = suites.get(0);
		String formFactor = suite.getParameter("formfactor");
		String site = suite.getParameter("siteName");
		String testPackage = null;
		if (site != null && site.equalsIgnoreCase("demo")) {
			testPackage = getPackagesForTestKSNA(formFactor);
		}
		if (testPackage == null ) {
			Object params[] = { site, formFactor };
			String message = MessageFormat.format("No valid package found for test run with  site {0} and  formfactor {1}", params);
			throw new ConfigException(message, params);
		}
		
		XmlTest xmlTest = suite.getTests().get(0);
		XmlPackage xmlPackage = new XmlPackage(testPackage);
		List<XmlPackage> packages =  suite.getXmlPackages();
		packages.add(xmlPackage);
		xmlTest.setXmlPackages(Collections.singletonList(xmlPackage));
		LOGGER.info("TestNG TestRunner Configured for run "+suite.toString() +" with package "+testPackage);
	}

	private String getPackagesForTestKSNA(String formFactor) {
		String desktopPkg = "com.demo.desktoptests";
		String mobilePkg = "com.demo.mobiletests";
		String tabletPkg = "com.demo.tablettests";
		if (formFactor != null) {
			if (formFactor.equalsIgnoreCase("mobile")) {
				return mobilePkg;
			} else if (formFactor.equalsIgnoreCase("tablet")) {
				return tabletPkg;
			} else {
				return desktopPkg;
			}
		} else {
			return desktopPkg;
		}
	}
}
