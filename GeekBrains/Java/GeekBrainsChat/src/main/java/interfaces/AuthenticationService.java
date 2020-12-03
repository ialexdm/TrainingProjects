package interfaces;

public interface AuthenticationService {
    void start();
    String getNick(String login, String Password);
    void stop();
}
