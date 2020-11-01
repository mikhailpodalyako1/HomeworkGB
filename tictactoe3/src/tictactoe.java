import javax.xml.bind.SchemaOutputResolver;
import java.util.Random;
import java.util.RandomAccess;
import java.util.Scanner;


public class tictactoe {

    private static final char HUMAN_DOT = 'X';
    private static final char PC_DOT = 'O';
    private static final char EMPTY_DOT = '_';

    public static final Scanner SCANNER = new Scanner(System.in);
    public static final Random RANDOM = new Random();

    public static int fieldSizeX;
    public static int fieldSizeY;
    public static char[][] field;

    public static void initMap() {
        fieldSizeX = 3;
        fieldSizeY = 3;
        field = new char[fieldSizeY][fieldSizeX];

        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                field[y][x] = EMPTY_DOT;
            }
        }
    }

    public static void printMap() {
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                System.out.print(field[y][x] + "|");
            }
            System.out.println();
        }
    }

    public static void humanTurn() {
        int x;
        int y;

        do {
            System.out.println("Ведите коардинаты через пробел: ");
            x = SCANNER.nextInt() - 1;
            y = SCANNER.nextInt() - 1;
        } while (!isValidCell(y,x)|| !isEmptyCell(y,x));
        field[y][x] = HUMAN_DOT;
    }

    public static void pcTurn() {
        int x;
        int y;
        do {
            x = RANDOM.nextInt(fieldSizeX);
            y = RANDOM.nextInt(fieldSizeY);
        } while (!isEmptyCell(y,x));


        field[y][x] = PC_DOT;

    }

    public static boolean isValidCell(int y, int x) {
            return  x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY;
    }
    public static boolean isEmptyCell(int y, int x) {
        boolean tmp;
       if (field[y][x] == EMPTY_DOT) {
         tmp = true;
       } else {
           tmp = false;
       }
       return tmp;
    }

    public static boolean checkWin(char c) {
        for (int i = 0; i < 3; i++)
            if ((field[i][0] == c && field[i][1] == c && field[i][2] == c) || (field[0][i] == c && field[1][i] == c && field[2][i] == c))
                return true;

            if ((field[0][0] == c && field[1][1] == c && field[2][2] == c) || (field[2][0] == c && field[1][1] == c && field[0][2] == c))
                return true;
            return false;
        }

    
    public static boolean isFullMap(){
        for (int y = 0; y < fieldSizeY; y++) {
         for (int x = 0; x < fieldSizeX; x++){
             if (field[y][x] == EMPTY_DOT) return false;
         }
        }
        return true;
    }

    public static void main(String[] args) {
        initMap();
        printMap();
        while (true){
            humanTurn();
            printMap();
            if (checkWin(HUMAN_DOT)){
                System.out.println("Human win");
                break;
            }
            if(isFullMap()){
                System.out.println("Ничья");
                break;
            }
            System.out.println();
            pcTurn();
            printMap();
            if (checkWin(PC_DOT)){
                System.out.print("PC Win!");
                break;
            }
            if(isFullMap()) {
                System.out.println("Ничья");
                break; }
        }

    }
}
