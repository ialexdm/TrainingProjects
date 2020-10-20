package Lesson5;

public class Employee {
    private FullName fullName;
    private String position;
    private Contacts contacts;
    private int age;
    private double salary;

    public Employee(FullName fullName, String position, Contacts contacts, int age, double salary) {
        this.fullName = fullName;
        this.position = position;
        this.contacts = contacts;
        this.age = age;
        this.salary = salary;
    }

    public void info(){
        System.out.println("*************");
        System.out.println();
        System.out.println("Info: ");
        System.out.println("Full Name: " + this.fullName.getName() + " " + this.fullName.getPatronymic() + " " + this.fullName.getSurname() );
        System.out.println("Position: " + this.position);
        System.out.println("Contacts: " + "phone: " + this.contacts.getPhoneNumber() + " e-mail: " + this.contacts.geteMail());
        System.out.println("Age: " + this.age);
        System.out.println("Salary: " + this.salary);
        System.out.println();
        System.out.println("*************");
    }

    public FullName getFullName() {
        return fullName;
    }

    public String getPosition() {
        return position;
    }

    public Contacts getContacts() {
        return contacts;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }
}
