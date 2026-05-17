package base;

import com.aventstack.extentreports.ExtentReports;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import reports.ExtentManager;

public class BaseTest {
	protected static ExtentReports extent;

	@BeforeSuite
	public void setup() {
		extent = ExtentManager.getInstance();
	}

	@AfterSuite
	public void tearDown() {
		if (extent != null) {
			extent.flush();
		}
	}
}