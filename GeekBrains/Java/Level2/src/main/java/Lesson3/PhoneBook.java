package Lesson3;

import java.util.*;

public class PhoneBook {

  /*  2. Написать простой класс ТелефонныйСправочник, который хранит в себе список фамилий и телефонных номеров.
    В этот телефонный справочник с помощью метода add() можно добавлять записи.
    С помощью метода get() искать номер телефона по фамилии.
    Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
    тогда при запросе такой фамилии должны выводиться все телефоны.
  */
    Map<String, ArrayList<String>> book;

    public PhoneBook(){
        book = new HashMap<String, ArrayList<String>>();
    }
    public void add(String name, String phone){
        if (book.containsKey(name)){
            book.get(name).add(phone);
        } else{
        ArrayList<String> phoneList = new ArrayList<String>();
        phoneList.add(phone);
        book.put(name,phoneList);
        }
    }
    public void print(String name){
        System.out.println(book.get(name));
    }

}
