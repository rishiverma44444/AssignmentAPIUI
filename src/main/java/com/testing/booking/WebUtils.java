package com.testing.booking;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class WebUtils {

	public static void snapshotCapture(String name) {
		
		try {
			TakesScreenshot ss = ((TakesScreenshot) BaseUI.driver);
			File src = ss.getScreenshotAs(OutputType.FILE);
			File DesFile = new File(GlobalConstants.SCREENSHOT_PATH + name + ".PNG");
			FileUtils.copyFile(src, DesFile);
		} catch (IOException e) {
			System.out.println("Screenshot Failure : "+e);
		}
	}

	public static String getValue(String string) {
		File file = new File(GlobalConstants.CONFIG);
		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Properties prop = new Properties();
		try {
			prop.load(fileInput);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop.getProperty(string);
	}

}
