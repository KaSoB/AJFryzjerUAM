package pl.aj.uamproject.hairdresser.service.email;

import pl.aj.uamproject.hairdresser.model.Appointment;

import java.text.SimpleDateFormat;
import java.util.Date;

public class EmailService {
    private static String fileNameConfig = "C:\\config.xml";

    private SMTPServer server = new SMTPServer();
    private Configuration config = new Configuration(fileNameConfig);

    public void sendEmail(String toAddress, Date appointmentDate){
        try{
            String host = config.getHost();
            String port = config.getPort();
            String userName = config.getUserName();
            String password = config.getPassword();

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
            String appointmentDateStr = dateFormat.format(appointmentDate);

            String subject = config.getSubjectTemplate().replace(config.getDateKey(),appointmentDateStr);
            String message = config.getMessageTemplate().replace(config.getDateKey(),appointmentDateStr);
            // On production, replace config.getDebugEmail() with toAddress attribute
            server.sendEmail(host,port,userName,password, config.getDebugEmail(), subject,message);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
