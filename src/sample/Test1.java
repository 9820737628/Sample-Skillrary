package sample;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Test1 {
	ExtentReports extent;
	ExtentTest logger;

	@BeforeTest
	public void openApp() {

		extent = new ExtentReports("./reports/automatiomreports.html");
		extent.addSystemInfo("Hostname", "LocalHost");
		extent.addSystemInfo("Environment", "QA");
		extent.addSystemInfo("User Name", "Sample");
		extent.loadConfig(new File("./reports/automatiomreports.html"));
	}

	@Test
	public void passtest() {
		logger = extent.startTest("Passtest");
		Assert.assertTrue(true);
		logger.log(LogStatus.PASS, "Test Case is Passed");
	}

	@Test
	public void Faitest() {
		logger = extent.startTest("Failtest");
		Assert.assertTrue(false);
		logger.log(LogStatus.FAIL, "Test Case is FAILEDd");
	}

	@Test
	public void Skiptest() {
		logger = extent.startTest("SkipTest");
		Assert.assertTrue(false);
		logger.log(LogStatus.SKIP, "Test Case is SKIPPED");
	}

	@AfterMethod
	public void Closedapp() {
		extent.flush();
		extent.close();

	}

}
