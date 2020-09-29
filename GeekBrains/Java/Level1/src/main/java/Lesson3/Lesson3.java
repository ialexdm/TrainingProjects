package Lesson3;

import java.util.Scanner;

public class Lesson3 {

    public static void main(String[] args) {
        tusk1();
        tusk2();

    }
  // 1. Написать программу, которая загадывает случайное число от 0 до 9, и пользователю дается 3 попытки угадать
    // это число. При каждой попытке компьютер должен сообщить больше ли указанное пользователем число чем загаданное,
    // или меньше. После победы или проигрыша выводится запрос –
    // «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).


    public static void tusk1() {
        boolean isGameStart = true;
        int attempts =3;
        int[] range = new int[2];
        range[1] = 10;
        Scanner scanner = new Scanner(System.in);
        int answer,random = 0;

        while (isGameStart) {
            if (attempts == 0){
                System.out.println("Guessing number is: "+ random);
                System.out.println("You lose. Try again? 1-yes, 2-no");
                answer = scanner.nextInt();
                if (answer == 2) {
                    System.out.println("Game over");
                    return;
                }
            }
            System.out.println("Random number is generating");
            random = (int) (range[1] - Math.random() * range[1] + range[0]);
            System.out.println("Generating complete. Guess the number!");
            for (attempts = 3; attempts > 0; attempts--) {
                System.out.printf("Please, enter a number from %s to %s: \n", range[0], range[1]-1);
                System.out.printf("You have %s attempts\n", attempts);
                answer = scanner.nextInt();
                if (answer > random) {
                    System.out.println("Your answer better than the guessing number.");
                } else if (answer < random) {
                    System.out.println("Your answer less than the guessing number.");
                } else {
                    System.out.println("Guessing number is: "+ random);
                    System.out.println("Congratulate! You Win!Try again? 1-yes, 2-no");
                    answer = scanner.nextInt();
                    if (answer == 2) {
                        isGameStart = false;
                    }else break;
                }
            }
        }

        System.out.println("Game over");
    }
    //         2 * Создать массив из слов String[] words = {"apple", "orange", "lemon", "banana",
    //         "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak",
    //         "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple",
    //         "pumpkin", "potato"};
  // При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя,
  // сравнивает его с загаданным словом и сообщает правильно ли ответил пользователь. Если слово не угадано,
    // компьютер показывает буквы которые стоят на своих местах.
  //         apple – загаданное
  // apricot - ответ игрока
  // ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
  // Для сравнения двух слов посимвольно, можно пользоваться:
  // String str = "apple";str.charAt(0); - метод, вернет char, который стоит в слове str на первой позиции
  // Играем до тех пор, пока игрок не отгадает слово
  // Используем только маленькие буквы
    public static void tusk2(){
        Scanner scanner = new Scanner(System.in);
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry",
                "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut",
                "pear", "pepper", "pineapple", "pumpkin", "potato"};
        String random, userAnswer;
        char[] answer = new char[15];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = '#';
        }
        boolean isGameRunning = true;
        while (isGameRunning){
            int count;
            System.out.println("Guessing word...");
            random = words[(int)(words.length - Math.random()*words.length)];
            System.out.print("Word was guessing. ");
            while(isGameRunning) {
                System.out.println("Enter your answer: ");
                userAnswer = scanner.nextLine();
                if (userAnswer.length()>random.length()){
                    count = random.length();
                }else{
                    count = userAnswer.length();
                }
                int answeredChars =0;
                for (int i = 0; i < count; i++) {
                    if (userAnswer.charAt(i) == random.charAt(i)) {
                        answer[i] = userAnswer.charAt(i);
                        answeredChars++;
                    }
                }
                System.out.println("Open guessing chars: ");
                for (char c : answer
                ) {
                    System.out.print(c);
                }
                System.out.println();
                if (answeredChars == count){
                    System.out.println("You win!");
                    return;
                }
            }
        }
    }

}
