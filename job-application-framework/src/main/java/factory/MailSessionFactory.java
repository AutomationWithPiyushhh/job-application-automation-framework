package factory;

import config.ConfigReader;

import javax.mail.*;
import java.util.Properties;

public class MailSessionFactory {

    public static Session createSession() {

        Properties props = new Properties();

        props.put("mail.smtp.auth", "true");

        props.put(
                "mail.smtp.starttls.enable",
                "true");

        props.put(
                "mail.smtp.host",
                "smtp.gmail.com");

        props.put(
                "mail.smtp.port",
                "587");

        return Session.getInstance(
                props,
                new Authenticator() {

                    protected PasswordAuthentication
                    getPasswordAuthentication() {

                        return new PasswordAuthentication(
                                ConfigReader.get(
                                        "sender.email"),

                                ConfigReader.get(
                                        "sender.password")
                        );
                    }
                });
    }
}