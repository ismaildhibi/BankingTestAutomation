package com.inetBanking.utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.common.io.Files;
import com.intBanking.pages.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public WebDriver driver;
	protected LoginPage loginPage;
	private static ExtentHtmlReporter htmlReport;
	private static ExtentReports extent;
	public static Logger logger;
	ReadConfig readconfig = new ReadConfig();

	public static ExtentReports getInstance() {

		String reportName = getReporttName();
		String directory = System.getProperty("user.dir") + "/reports/";
		new File(directory).mkdirs();
		String path = directory + reportName;
		htmlReport = new ExtentHtmlReporter(path);
		htmlReport.config().setEncoding("utf-8");
		htmlReport.config().setDocumentTitle("Automation Test"); // title of the report
		htmlReport.config().setReportName("Functional Test Automation Report"); // name of the report
		htmlReport.config().setTestViewChartLocation(ChartLocation.TOP); // location of the chart
		htmlReport.config().setTheme(Theme.DARK);

		extent = new ExtentReports();
		extent.setSystemInfo("organization", "abdou guesmi");
		extent.setSystemInfo("browserowser", "Chrome");
		extent.setSystemInfo("organization", "abdou guesmi");
		extent.attachReporter(htmlReport);

		// WebDriverManager.chromedriver().setup();
		return extent;
	}

	public static String getReporttName() {
		Date d = new Date();
		String fileName = "Report_" + d.toString().replace(":", "-") + ".html";
		return fileName;

	}

	@BeforeClass
	public void setUp() {

	}

	@Parameters("browser")
	@BeforeMethod
	public void goLogin(String browser) {
		logger = Logger.getLogger("e-banking");
		PropertyConfigurator.configure("Log4j.properties");

		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equals("ie")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(readconfig.getApplicationURL());
		// loginPage = new LoginPage(driver);
	}

	@AfterMethod
	public void recordFailure(ITestResult result) {
		if (ITestResult.FAILURE == result.getStatus()) {
			TakesScreenshot camera = (TakesScreenshot) driver;
			File screenshot = camera.getScreenshotAs(OutputType.FILE);
			try {
				Files.move(screenshot, new File("target/screenshots/" + result.getName() + ".png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		driver.close();
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
