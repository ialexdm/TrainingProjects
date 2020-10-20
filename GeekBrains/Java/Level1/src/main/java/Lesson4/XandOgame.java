package Lesson4;

import java.util.Scanner;


public class XandOgame {

    private static final int SIZE =5;
    private static final char DOT_X='X';
    private static final char DOT_O='O';
    private static final char DOT_EMPTY='•';
    private static final int DOTS_TO_WIN=4;
    public static char[][] map;
    private static char userDot;
    private static char aiDot;
    private static int count =SIZE*SIZE;
    static Scanner scanner = new Scanner(System.in);
    static boolean isUserTurn = true;
    
    
    public static void main(String[] args) {
        initMap();
        printMap();
        changeXorO();
        while (true) {
            if (isUserTurn) {
                userTurn();
                if (isWin(userDot)) {
                    System.out.println("You win!");
                    break;
                }
                if (isMapFull()) {
                    System.out.println("Game over in a a draw");
                    break;
                }
                isUserTurn = false;
            }

            aiTurn();
            if(isWin(aiDot)){
                System.out.println("You lose!");
                break;
            }
            if (isMapFull()){
                System.out.println("Game over in a a draw");
                break;
            }
            isUserTurn = true;

        }



    }

    private static void changeXorO() {

        int playerChoice;

        do {
            System.out.println("Choose your symbol: to \"X\" press 1, to \"O\" press 0" );
            playerChoice = scanner.nextInt();
        }while (playerChoice!=1 && playerChoice!=0);
        if (playerChoice == 1) {
            userDot = DOT_X;
            aiDot = DOT_O;
            isUserTurn = true;
        }
        else if (playerChoice == 0) {
            userDot = DOT_O;
            aiDot = DOT_X;
            isUserTurn = false;
        }else {
            System.out.println("Wrong input.");
        }
    }

    private static void aiTurn() {
        System.out.println("AI turn");
        int x,y;
        do{
            x = (int) (SIZE* Math.random());
            y = (int) (SIZE* Math.random());
            if (isTurnValid(x,y)){
                map[x][y] = aiDot;
                count--;
                printMap();
                break;
            } else{
                System.out.println("The chosen field is not available.");
            }
        } while (true);
    }

    private static boolean isMapFull() {
        if (count==0){
            return true;
        }
        return false;
    }

    private static boolean isWin(char symbol) {
        for (int shift =0; shift<2; shift++) {
            if(map[0+shift][0+shift] == map[1+shift][1+shift] && map[1+shift][1+shift] == map[2+shift][2+shift] && map[2+shift][2+shift] == map[3+shift][3+shift] && map[3+shift][3+shift] == symbol)
                return true;
            for (int i = 0; i < SIZE; i++) {
                if (map[i][0+shift] == map[i][1+shift] && map[i][1+shift] == map[i][2+shift] && map[i][2+shift] == map[i][3+shift] && map[i][3+shift] == symbol)
                    return true;
                if (map[0+shift][i] == map[1+shift][i] && map[1+shift][i] == map[2+shift][i] && map[2+shift][i] == map[3+shift][i] && map[3+shift][i] == symbol)
                    return true;
            }
        }
        if(map[1][0] == map[2][1] && map[2][1] == map[3][2] && map[3][2] == map[4][3] && map[4][3] == symbol)
            return true;
        if(map[0][1] == map[1][2] && map[1][2] == map[2][3] && map[2][3] == map[3][4] && map[3][4] == symbol)
            return true;
        if(map[4][1] == map[3][2] && map[3][2] == map[2][3] && map[2][3] == map[1][4] && map[1][4] == symbol)
            return true;
        if(map[0][3] == map[1][2] && map[1][2] == map[2][1] && map[2][1] == map[3][0] && map[3][0] == symbol)
            return true;
        if(map[0][4] == map[1][3] && map[1][3] == map[2][2] && map[2][2] == map[3][1] && map[3][1] == symbol)
            return true;
        if(map[4][0] == map[1][3] && map[1][3] == map[2][2] && map[2][2] == map[3][1] && map[3][1] == symbol)
            return true;

        return false;
    }

    private static boolean isTurnValid(int x, int y) {
        if (x>= 0 && x<SIZE && y>= 0 && y<SIZE && map[x][y] == DOT_EMPTY){
            return true;
        }
        return false;
    }

    private static void userTurn() {
        System.out.println("Your turn.");
        int x,y;
        do {
            System.out.println("Please enter coordinate X,Y: ");
            x = scanner.nextInt();
            y = scanner.nextInt();
            if (isTurnValid(x - 1, y - 1)) {
                map[x-1][y-1] = userDot;
                count--;
                printMap();
                break;
            }
            else{
                System.out.println("The chosen field is not available.");
            }
        }while (true);


    }

    private static void printMap() {
        System.out.print(" ");
        for (int i = 0; i < SIZE; i++) {
            System.out.print(" " + (i+1));
        }
        System.out.println();
        for (int i = 0; i < map.length; i++) {
            System.out.print(i+1);
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(" " + map[i][j]);
            }
            System.out.println();
        }
    }

    private static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

}
