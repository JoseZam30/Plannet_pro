package com.mycompany.Controller;

import java.util.Properties;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;


public class EnvioCorreos {

    public static String getEmailFrom() {
        return emailFrom;
    }

    public static void setEmailFrom(String emailFrom) {
        EnvioCorreos.emailFrom = emailFrom;
    }

    public static String getPasswordFrom() {
        return passwordFrom;
    }

    public static void setPasswordFrom(String passwordFrom) {
        EnvioCorreos.passwordFrom = passwordFrom;
    }

    public String getEmailTo() {
        return emailTo;
    }

    public void setEmailTo(String emailTo) {
        this.emailTo = emailTo;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Properties getmProperties() {
        return mProperties;
    }

    public void setmProperties(Properties mProperties) {
        this.mProperties = mProperties;
    }

    public Session getmSession() {
        return mSession;
    }

    public void setmSession(Session mSession) {
        this.mSession = mSession;
    }

    public MimeMessage getmCorreo() {
        return mCorreo;
    }

    public void setmCorreo(MimeMessage mCorreo) {
        this.mCorreo = mCorreo;
    }
    private static String emailFrom = "";
    private static String passwordFrom = "";
    private String emailTo;
    private String subject;
    private String content;
    
    private Properties mProperties;
    private Session mSession;
    private MimeMessage mCorreo;

    public EnvioCorreos() {
        mProperties = new Properties();

    }
   
}
