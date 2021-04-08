package com.inetBanking.utilities;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class MyListener implements ITestListener {
	private static ExtentReports extent = BaseTest.getInstance();
	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	public ExtentTest logger;

	public void onTestStart(ITestResult result) {
		ExtentTest test = extent
				.createTest(result.getTestClass().getName() + "::" + result.getMethod().getMethodName());
		extentTest.set(test);

	}

	public void onTestSuccess(ITestResult result) {
		String logText = "<b> Test Method " + result.getMethod().getMethodName() + " Pass </b>";
		Markup markup = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
		extentTest.get().log(Status.PASS, markup);
		logger = extent.createTest(result.getName()); // create new entry in the report
		logger.log(Status.PASS, MarkupHelper.createLabel(result.getName(), ExtentColor.GREEN)); // send the passed
																								// information to the
																								// report with GREEN
																								// color highlighted

	}

	public void onTestFailure(ITestResult result) {
		String methodName = result.getMethod().getMethodName();

		String exceptionMessage = Arrays.toString(result.getThrowable().getStackTrace());
		extentTest.get().fail("<details><summary><b><font color=red>Exception Occured, click to see details:"
				+ "</font></b></summary>" + exceptionMessage.replaceAll(",", "<br>") + "</details> \n");
		WebDriver driver = ((BaseTest) result.getInstance()).driver;
		String logText = "<b> Test Method " + result.getMethod().getMethodName() + " Failed </b>";
		String path = takeScreenshot(driver, methodName);
		Markup markup = MarkupHelper.createLabel(logText, ExtentColor.RED);
		extentTest.get().log(Status.FAIL, markup);
		logger = extent.createTest(result.getName()); // create new entry in th report
		logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName(), ExtentColor.RED)); // send the passed
																								// information to the
																								// report with GREEN
																								// color highlighted
		try {
			extentTest.get().fail("<b><font color=red>" + "Screenshot of failure" + "</font></b>",
					MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		} catch (IOException e) {
			extentTest.get().fail("Test Fail, cannot attach screenshot");
		}
	}

	public void onTestSkipped(ITestResult result) {
		String logText = "<b> Test Method " + result.getMethod().getMethodName() + " Skip </b>";
		Markup markup = MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
		extentTest.get().log(Status.SKIP, markup);

		logger = extent.createTest(result.getName()); // create new entry in th report
		logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName(), ExtentColor.ORANGE));

	}

	public void onFinish(ITestContext context) {
		if (extent != null) {
			extent.flush();
		}
	}

	public static String takeScreenshot(WebDriver driver, String methodName) {
		String filename = getScreenshotName(methodName);
		String directory = System.getProperty("user.dir") + "/screenshot/";
		new File(directory).mkdirs();
		String path = directory + filename;
		try {
			File screenshoot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshoot, new File(path));
		} catch (IOException e) {

		}
		return path;
	}

	public static String getScreenshotName(String methodName) {
		Date d = new Date();
		String fileName = methodName + "_" + d.toString().replace(":", "-") + ".png";
		return fileName;

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}
}
