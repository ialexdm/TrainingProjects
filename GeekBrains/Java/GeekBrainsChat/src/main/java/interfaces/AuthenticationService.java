package interfaces;

public interface AuthenticationService {
    void start();
    String getNick(String login, String password);
    void stop();
}
