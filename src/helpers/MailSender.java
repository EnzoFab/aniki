package helpers;

import logs.ConnectionLog;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;

public final class MailSender {

    private MailSender(){}

    /**
     * Send an Html mail
     * @param to
     * @param from
     * @param subject
     * @param content
     */
    public static boolean sendHtmlMail(String to, String from, String subject, String content){
        // modify to send img as well
        try {
            Message message = new MimeMessage(buildSession());
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to));
            message.setSubject(subject);
            message.setContent(content, "text/html; charset=utf-8");
            System.out.println("Try to send mail to: "+to);
            Transport.send(message);

            System.out.println("Mail sent to "+to);
            return true;

        } catch (MessagingException e) {
            e.printStackTrace();
            return false ;
        }

    }



    /**
     * Send a mail with a file attached
     * @param to
     * @param from
     * @param subject
     * @param content
     * @param fileName
     * @return
     */
    public static boolean sendAttachedMail(String to, String from, String subject, String content, String fileName){
            try {
                Message message = new MimeMessage(buildSession());
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to));
            message.setSubject(subject);
            BodyPart messageBodyPart = new MimeBodyPart();

            // Fill the message
            messageBodyPart.setText("This is message body");

            // Create a multipar message
            Multipart multipart = new MimeMultipart();

            // Set text message part
            multipart.addBodyPart(messageBodyPart);

            // Part two is attachment
            messageBodyPart = new MimeBodyPart();
            DataSource source = new FileDataSource(fileName);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(fileName);
            messageBodyPart.setText(content);
            multipart.addBodyPart(messageBodyPart);

            // Send the complete message parts
            message.setContent(multipart );

            System.out.println("Try to send mail to: "+to);
            Transport.send(message);

            System.out.println("Mail sent to "+to);
            return true;

        } catch (MessagingException e) {
            e.printStackTrace();
            return false ;
        }

    }

    private static Session buildSession() {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        return Session.getDefaultInstance(props,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(ConnectionLog.getUserNameGoogle()
                                , ConnectionLog.getPasswordGoogle());
                    }
                });

    }


}
