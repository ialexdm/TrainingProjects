package Lesson5;

public class ObjectOrientedProgramming {
    public static void main(String[] args) {
/**

    * Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст;
    * Конструктор класса должен заполнять эти поля при создании объекта;
    * Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль;
    * Создать массив из 5 сотрудников

    * С помощью цикла вывести информацию только о сотрудниках старше 40 лет;
 **/

        Employee[] employees = new Employee[5];
        employees[0] = new Employee(
                (new FullName("Igor", "Ivanov", "Vasil'evich")),
                "Janitor",
                new Contacts("+79991112233","Ivanov341@employee.com"),
                57,
                13000.00);
        employees[1] = new Employee(
                new FullName("Svetlana", "Ivanova", "Pavlovna"),
                "Cleaner",
                new Contacts("+79332221100","Ivanova1@employee.com"),
                55,
                12995.24);
        employees[2] = new Employee(
                new FullName("Petr", "Ivanov", "Igorevich"),
                "Mechanic",
                new Contacts("+79202202020","StarKiller9000@employee.com"),
                33,
                24000);
        employees[3] = new Employee(
                new FullName("Elena", "Derzhimorda", "Vladimirovna"),
                "Accountant",
                new Contacts("+79995212121","DerzhimordaVE@employee.com"),
                34,
                45000.99);
        employees[4] = new Employee(
                new FullName("Vyacheslav", "Derzhimorda", "Vasil'evich"),
                "General Manager",
                new Contacts("+79876543210","DerzhimordaVV@employee.com"),
                43,
                13000.00);

        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getAge() > 40){
                employees[i].info();
            }

        }

    }
}
