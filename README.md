# Job Application Automation Framework

A robust, automated framework designed to streamline the mass job application process. This tool allows candidates to seamlessly send customized emails with their resumes to multiple recruiters at once, saving time and significantly increasing outreach efficiency.

## 🚀 Features
* **Mass Email Automation:** Send job application emails to a specific list of recruiter addresses simultaneously.
* **Email Customization:** Full support for HTML and CSS formatted email bodies to ensure a highly professional presentation.
* **Attachment Handling:** Automatically attach resumes, cover letters, or portfolios to the outgoing emails.
* **Reliable Delivery:** Built using Java and the JavaMail API for secure and dependable SMTP communication.

## 💻 Tech Stack
* **Core Logic:** Java
* **Email Handling:** JavaMail API
* **Templating:** HTML, CSS, JavaScript (for designing and rendering dynamic email structures)

## 📋 Prerequisites
Before using this framework, ensure you have the following setup:
* Java Development Kit (JDK) 8 or higher.
* An IDE of your choice (Eclipse, IntelliJ IDEA, or VS Code).
* An active email account with SMTP access enabled (e.g., a Gmail account with an "App Password" generated for secure third-party access).

## 🛠️ Installation & Setup

1. **Clone the repository:**
   ```bash
   git clone [https://github.com/AutomationWithPiyushhh/job-application-automation-framework.git](https://github.com/AutomationWithPiyushhh/job-application-automation-framework.git)

2. **Navigate to the project directory:**
```bash
cd job-application-automation-framework

```


3. **Configure your credentials:**
* Locate the configuration section or properties file within the Java code.
* Update the sender email address and provide your secure SMTP App Password.
* *Security Note: Never push your actual email password or App Password to GitHub. Always use environment variables or ensure your configuration file is added to `.gitignore`.*


4. **Update the Recruiter List:**
* Add your target recruiter email addresses to the list, array, or external data file processed by the script.


5. **Customize the Email Template:**
* Modify the provided HTML/CSS files to personalize your message and cover letter.
* Place your resume document (e.g., `Your_Resume.pdf`) in the designated project folder and ensure the file path is correctly referenced in the code's attachment logic.



## 🚀 Usage

1. Compile the project and run the main executable Java class.
2. The framework will automatically iterate through your compiled list of recruiters.
3. It will securely connect to the SMTP server and dispatch your customized HTML email along with the attached resume to each recipient individually.
4. Monitor the console output for real-time delivery status and error logging.

## 🤝 Contributing

Contributions, issues, and feature requests are highly encouraged! Feel free to check the issues page and submit pull requests to help improve the framework for everyone.

## 📝 License

This project is open-source and available under the [MIT License](https://www.google.com/search?q=LICENSE).

```
