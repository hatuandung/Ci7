import java.util.Scanner;
import java.util.Random;

public class Homework {

    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        //map
        String[][] map = new String[10][10];
        //Player
        int playerX = 0;
        int playerY = 0;
        String player = "P ";
        //Enemy
        int enemy1X = random.nextInt(10) ;
        int enemy1Y = random.nextInt(10) ;
        String enemy1 = "E ";
        int enemy2X = random.nextInt(10) ;
        int enemy2Y = random.nextInt(10) ;
        String enemy2 = "E ";
        //Gift
        int giftX = random.nextInt(10) ;
        int giftY = random.nextInt(10) ;
        String gift = "G ";

        while (true) {
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    map[i][j] = "* ";
                    map[playerX][playerY] = player;
                    map[enemy1X][enemy1Y] = enemy1;
                    map[enemy2X][enemy2Y] = enemy2;
                    map[giftX][giftY] = gift;
                    System.out.print(map[i][j]);
                }
                System.out.println();
            }

            System.out.print("Your choice: ");
            String choice = scanner.next();

            if (choice == "a" || choice == "A") {
                if (playerY == 0) {
                    playerY = 9;
                    //System.out.println("Can't move");
                } else {playerY -=1;}
            }
            if (choice == "d" || choice == "D") {
                if (playerY == 9) {
                    playerY = 0;
                    //System.out.println("Can't move");
                } else {playerY +=1;}
            }
            if (choice == "w" || choice == "W") {
                if (playerX == 0) {
                    playerX = 9;
                    //System.out.println("Can't move");
                } else playerX--;
            }
            if (choice == "s" || choice == "S") {
                if (playerX == 9) {
                    playerX = 0;
                    //System.out.println("Can't move");
                } else playerX++;
            }

            if (enemy1X == 9) enemy1X = 0;
            else enemy1X++;

            if (enemy2Y == 9) enemy2Y = 0;
            else enemy2Y++;

            if (playerX == giftX && playerY == giftY) {
                System.out.println("you win");
            } else if (playerX == enemy1X && playerY == enemy1Y) {
                System.out.println("you lose");
            } else if (playerX == enemy2X && playerY == enemy2Y) {
                System.out.println("you lose");
            }

        }


    }
}