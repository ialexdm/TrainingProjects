package notebook.database;

public class User {
    private String email,password,username,country;
    private boolean gender;
    public User(String email, String password, String username, String country, boolean gender){
        this.email = email;
        this.password = password;
        this.username = username;
        this.country = country;
        this.gender = gender;

    }
    public User(String email, String password){
        this.email = email;
        this.password = password;
    }
    public User(){}

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public String getCountry() {
        return country;
    }

    public boolean isGender() {
        return gender;
    }
}
