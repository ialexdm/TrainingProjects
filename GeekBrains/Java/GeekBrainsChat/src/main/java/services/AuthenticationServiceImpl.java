package services;

import interfaces.AuthenticationService;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AuthenticationServiceImpl implements AuthenticationService {

    private List<UserEntity> usersList;


    public AuthenticationServiceImpl() {
        this.usersList = new LinkedList<UserEntity>();
        usersList.add(new UserEntity("login1","pass1","Nick1"));
        usersList.add(new UserEntity("login2","pass2","Nick2"));
        usersList.add(new UserEntity("login3","pass3","Nick3"));
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
        private String login;
        private String password;
        private String nick;

        public UserEntity(String login, String password, String nick) {
            this.login = login;
            this.password = password;
            this.nick = nick;
        }

    }
}
