package services;

import java.io.File;

import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.aventstack.extentreports.Status;

import config.ConfigReader;
import factory.MailSessionFactory;
import models.RecruiterData;
import reports.ExtentTestManager;
import utils.ValidationUtils;

public class EmailService {

	public void sendEmail(RecruiterData recruiter) {

		if (!ValidationUtils.isValidEmail(recruiter.getEmail())) {

			ExtentTestManager.getTest()
					.log(Status.FAIL,
							"Invalid Email : " + recruiter.getEmail());

			return;
		}

		try {

			ExtentTestManager.getTest()
					.log(Status.INFO,
							"Preparing email for : " + recruiter.getCompany());

			Session session = MailSessionFactory.createSession();

			Message message = new MimeMessage(session);

			message.setFrom(
					new InternetAddress(ConfigReader.get("sender.email")));

			message.setRecipients(
					Message.RecipientType.TO,
					InternetAddress.parse(recruiter.getEmail()));

			message.setSubject(ConfigReader.get("email.subject"));

			MimeBodyPart bodyPart = new MimeBodyPart();

			bodyPart.setContent(generateBody(recruiter), "text/html");

			MimeBodyPart attachmentPart = new MimeBodyPart();

			attachmentPart.attachFile(
					new File(ConfigReader.get("resume.path")));

			Multipart multipart = new MimeMultipart();

			multipart.addBodyPart(bodyPart);

			multipart.addBodyPart(attachmentPart);

			message.setContent(multipart);

			ExtentTestManager.getTest()
					.log(Status.INFO,
							"Sending email to : " + recruiter.getEmail());

			Transport.send(message);

			ExtentTestManager.getTest()
					.log(Status.PASS,
							"Email sent successfully to : "
									+ recruiter.getEmail());

		} catch (Exception e) {

			ExtentTestManager.getTest()
					.log(Status.FAIL,
							"Failed sending email to : "
									+ recruiter.getEmail());

			ExtentTestManager.getTest()
					.log(Status.FAIL,
							"Exception : " + e.getMessage());
		}
	}

	private String generateBody(RecruiterData recruiter) {

		return "<html>" +
				"<body>" +

				"<p>Hi " + recruiter.getRecruiterName() + ",</p>" +

				"<p>" +
				"I am writing to express my interest in the "
				+ recruiter.getRole() +
				" opening at " + recruiter.getCompany() + "." +
				"</p>" +

				"<p>" +
				"I am an Automation Engineer with 2+ years of comprehensive experience " +
				"specialized in building end-to-end automation solutions. " +
				"I have a strong background in developing hybrid test frameworks " +
				"(POM, Data-Driven, TestNG) using both Java/Selenium and " +
				"TypeScript/Playwright ecosystems, alongside robust API testing " +
				"via REST Assured." +
				"</p>" +

				"<p><b>Profile Overview:</b></p>" +

				"<ul>" +
				"<li><b>Core Skills:</b> Web & API Automation, Framework Architecture, CI/CD Pipelines</li>" +
				"<li><b>Key Tech Stack:</b> Java, TypeScript, Selenium, Playwright, REST Assured, Jenkins, GitHub Actions</li>" +
				"<li><b>Location:</b> Noida</li>" +
				"<li><b>Notice Period:</b> 15 Days</li>" +
				"<li><b>Current / Expected CTC:</b> 7.25 LPA / 12 LPA</li>" +
				"</ul>" +

				"<p>" +
				"I have attached my resume for your consideration. " +
				"I am highly available for technical discussions over the next few days." +
				"</p>" +

				"<p>" +
				"Best regards,<br><br>" +
				"Piyush Baldaniya<br>" +
				"+91 728384 0504<br>" +
				"automation.with.piyush@gmail.com" +
				"</p>" +

				"</body>" +
				"</html>";
	}
}