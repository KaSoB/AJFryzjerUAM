package pl.aj.uamproject.hairdresser.service.email;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

class Configuration {
    private String host;
    private String port;
    private String userName;
    private String password;
    private String dateKey;
    private String subjectTemplate;
    private String messageTemplate;
    private String debugEmail;
    Configuration(String pathName){
        loadConfigurationFromXmlFile(pathName);
    }

    private void loadConfigurationFromXmlFile(String pathName){
        try {
            File stocks = new File(pathName);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(stocks);
            doc.getDocumentElement().normalize();
            Node node = doc.getElementsByTagName("configuration").item(0);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                host = element.getElementsByTagName("host").item(0).getTextContent();
                port = element.getElementsByTagName("port").item(0).getTextContent();
                userName = element.getElementsByTagName("userName").item(0).getTextContent();
                password = element.getElementsByTagName("password").item(0).getTextContent();
                dateKey = element.getElementsByTagName("dateKey").item(0).getTextContent();
                subjectTemplate = element.getElementsByTagName("subjectTemplate").item(0).getTextContent();
                messageTemplate = element.getElementsByTagName("messageTemplate").item(0).getTextContent();
                debugEmail = element.getElementsByTagName("debugEmail").item(0).getTextContent();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    String getDebugEmail(){return debugEmail;}

    String getDateKey() {return dateKey;}

    String getSubjectTemplate() {return subjectTemplate;}

    String getMessageTemplate() {return messageTemplate;}

    String getHost() {
        return host;
    }

    String getPassword() {
        return password;
    }

    String getPort() {
        return port;
    }

    String getUserName() {
        return userName;
    }
}
