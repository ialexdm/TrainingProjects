package Lesson7;

public class Lesson7 {
    public static void main(String[] args){
  //    1. Расширить задачу про котов и тарелки с едой
  //    2. Сделать так, чтобы в тарелке с едой не могло получиться отрицательного количества еды (например, в миске 10 еды, а кот пытается покушать 15-20)
  //    3. Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны). Если коту удалось покушать (хватило еды), сытость = true
  //    4. Считаем, что если коту мало еды в тарелке, то он ее просто не трогает, то есть не может быть наполовину сыт (это сделано для упрощения логики программы)
  //    5. Создать массив котов и тарелку с едой, попросить всех котов покушать из этой тарелки и потом вывести информацию о сытости котов в консоль
  //    6. Добавить в тарелку метод, с помощью которого можно было бы добавлять еду в тарелку

        double foodQty = 0;
        Cat[] cats = new Cat[5];
        for (int i = 0; i < cats.length; i++) {
            cats[i] = new Cat("Cat" + i,13 +i/2.0);
        }
        Plate plate = new Plate(100,foodQty);
        plate.fill();
        plate.info();

        for (int i = 0; i < cats.length; i++) {
            System.out.println(cats[i].getName() + " appetite: " + cats[i].getAppetite());
            cats[i].eat(plate);
            plate.info();
            System.out.println(cats[i].getName() + " appetite: " + cats[i].getAppetite());

        }




    }
}
