package pl.aj.uamproject.hairdresser.service.email;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class EmailService {
    private SMTPServer server = new SMTPServer();
    private EmailConfig config = new EmailConfig();
    public EmailService() {
    }

    public void sendEmail(String toAddress, String subject, String message){
        try{
            String host = config.getHost();
            String port = config.getPort();
            String userName = config.getUserName();
            String password = config.getPassword();
            server.sendEmail(host,port,userName,password,toAddress,subject,message);
        } catch (Exception e){
            e.printStackTrace(); // TODO:
        }
    }

}
