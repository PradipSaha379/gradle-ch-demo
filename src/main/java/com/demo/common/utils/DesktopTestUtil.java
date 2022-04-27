package com.demo.common.utils;

public class DesktopTestUtil  {
	
	public void testSetup() throws Exception {
		CommonUtils.desktopView();
		CommonUtils.loadAUTUrl();
		CommonUtils.closePopup();

	}
}
