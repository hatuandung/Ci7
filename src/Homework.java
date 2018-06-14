import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Homework {

    public static void main(String[] args) {

        Random random = new Random();
        String[][] map = {
                {"* ", "* ", "* ", "* "},
                {"* ", "* ", "* ", "* "},
                {"* ", "* ", "* ", "* "},
                {"* ", "* ", "* ", "* "},
        };


        int playerX = 0;
        int playerY = 0;
        int enemy1X = 0;
        int enemy1Y = 0;
        int enemy2X = 0;
        int enemy2Y = 0;

        int giftX = 0;
        int giftY = 0;

        ArrayList<Point> list = new ArrayList<>();
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                list.add(new Point(i, j));
            }
        }
        Point point = list.remove(random.nextInt(list.size()));
        playerX = point.x;
        playerY = point.y;
        map[playerX][playerY] = "P ";

        point = list.remove(random.nextInt(list.size()));
        enemy1X = point.x;
        enemy1Y = point.y;
        map[enemy1X][enemy1Y] = "E1 ";

        point = list.remove(random.nextInt(list.size()));
        enemy2X = point.x;
        enemy2Y = point.y;
        map[enemy2X][enemy2Y] = "E2 ";

        point = list.remove(random.nextInt(list.size()));
        giftX = point.x;
        giftY = point.y;
        map[giftX][giftY] = "G ";

        while (true) {

           printMap(map);
            System.out.println("your choice: ");
            Scanner scanner = new Scanner(System.in);
            String key = scanner.next();
            map[playerX][playerY] = "*";
            switch (key) {
                case "a":
                    if (playerY == 0) playerY = map.length - 1;
                    else playerY -= 1;
                    break;
                case "s":
                    if (playerX == map.length - 1) playerX = 0;
                    else playerX += 1;
                    break;
                case "d":
                    if (playerY == map.length - 1) playerY = 0;
                    else playerY += 1;
                    break;
                case "w":
                    if (playerX == 0) playerX = map.length - 1;
                    else playerX -= 1;
                    break;
            }

            map[playerX][playerY] = "P ";
            if (playerX == giftX && playerY == giftY) {
                System.out.println("you win");
                break;
            }
            if ((playerX == enemy1X && playerY == enemy1Y) || (playerX == enemy2X && playerY == enemy2Y)) {
                System.out.println("You Lost");
                break;
            }


            map[enemy1X][enemy1Y] = "* ";
            enemy1Y = (enemy1Y + 1) % 4;
            map[enemy1X][enemy1Y] = "E1 ";


            map[enemy2X][enemy2Y] = "* ";
            enemy2X = (enemy2X + 1) % 4;
            map[enemy2X][enemy2Y] = "E2 ";

            if ((playerX == enemy1X && playerY == enemy1Y) || (playerX == enemy2X && playerY == enemy2Y)) {
                System.out.println("You Lost");
                break;
            }
            map[playerX][playerY] = "P ";
        }


    }
    static void printMap(String map[][]){
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

}