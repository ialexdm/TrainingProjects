package services;

import interfaces.AuthenticationService;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AuthenticationServiceImpl implements AuthenticationService {

    private List<UserEntity> usersList;


    public AuthenticationServiceImpl() {
        this.usersList = new LinkedList<UserEntity>();
        usersList.add(new UserEntity("Nick1","login1","pass1"));
        usersList.add(new UserEntity("Nick2","login2","pass2"));
        usersList.add(new UserEntity("Nick3","login3","pass3"));
    }

    public void start() {
        System.out.println("AuthenticationService was started...");
    }

    public String getNick(String login, String Password) {
        return null;
    }

    public void stop() {
        System.out.println("AuthenticationService was stopped.");
    }
    private class UserEntity{
        private String nick;
        private String login;
        private String password;

        public UserEntity(String nick, String login, String password) {
            this.nick = nick;
            this.login = login;
            this.password = password;
        }

    }
}
