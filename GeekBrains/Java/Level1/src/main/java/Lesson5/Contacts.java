package Lesson5;

public class Contacts {
    private String phoneNumber;
    private String eMail;

    public Contacts(String phoneNumber, String eMail){
        this.phoneNumber = phoneNumber;
        this.eMail = eMail;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String geteMail() {
        return eMail;
    }
}
