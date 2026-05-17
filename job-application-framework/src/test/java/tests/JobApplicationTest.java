package tests;

import base.BaseTest;
import com.aventstack.extentreports.ExtentTest;
import dataproviders.EmailDataProvider;
import models.RecruiterData;
import org.testng.annotations.Test;
import reports.ExtentTestManager;
import services.EmailService;

public class JobApplicationTest extends BaseTest {
	EmailService emailService = new EmailService();

	@Test(dataProvider = "recruiterData", dataProviderClass = EmailDataProvider.class)
	public void sendJobApplication(RecruiterData recruiter) {
		ExtentTest test = extent.createTest("Send Email -> " + recruiter.getCompany());
		ExtentTestManager.setTest(test);
		test.info("Starting email sending process");
		emailService.sendEmail(recruiter);
		test.pass("Email process completed");
	}
}