package design.pattern.facade.facade2;

import org.springframework.boot.web.servlet.server.Session;

import java.util.Properties;

public class EmailSender {
    EmailSettings emailSettings = new EmailSettings();

    public EmailSender(EmailSettings emailSettings) {
        this.emailSettings = emailSettings;
    }

    public void sendEmail(EmailMessage emailMessage){

//        Properties properties = System.getProperties();
//        properties.setProperty("mai.smtp.host", emailSettings.getHost());
//
//        Session session = Session.getDefaultInstance(properties);
//
//        try{
//            MimeMessage message = new MineMessage(session);
//            message.setFrom(new InternetAddress(emailMessage.getFrom()));
//            message.addRecipient(Message.RecipientType.To, new InternetAddress(emailMessage.getTo()));
//            message.setSubject(emailMessage.getSubject ());
//            message.setText(emailMessage.getText());
//
//            Transport.send(message);
//        }catch(MessagingException e){
//            e.printStackTrace();
//        }

    }
}
