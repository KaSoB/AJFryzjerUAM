package pl.aj.uamproject.hairdresser.service.email;

class EmailConfig {
    private String host;
    private String port;
    private String userName;
    private String password;

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
