import java.io.File;
import java.io.FileNotFoundException;
import java.lang.Math;
import java.util.Scanner;

/*
This part of the code is defining the boundaries of each circle and then gives the points to the designated
user. This in turn will allow the program to choose who wins.
 */

public class check {
    public static int board(double X, double Y) {
        double x = X;
        double y = Y;
        int points = 0;
        double r = Math.sqrt(Math.pow(x,2)) + (Math.pow(y,2));

        if (r <= 4) {
            points += 100;
        } else if (r <= 8 && r > 4)
            points += 80;
        else if (r <= 12 && r > 8)
            points += 60;
        else if (r <= 16 && r > 12)
            points += 40;
        else if (r <= 20 && r > 16)
            points += 20;
        else if (r > 20)
            points += 0;

        return points;
    }

    /*
    This code determines which player wins by analyzing the scores and adding them. It then compares which score
    is larger and determines which player wins by using for loops and else if loops.
     */

    public static void fileScoring(double[][] Coords) {
        int[] player1 = new int[30];
        int[] player2 = new int[30];

        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 6; j+=2){
                player1[i] = board(Coords[i][j], Coords[i][j]+1);
            }
        }

        for (int i = 0; i < 30; i++) {
            for (int j = 6; j < 12; j+=2){
                player2[i] = board(Coords[i][j], Coords[i][j]+1);
            }
        }

        for(int i = 0; i < player1.length; i++) {
            if(player1[i] > player2[i]) {
                System.out.println("The score is: " + player1 + "to " + player2 + ". Player 1 wins.");
            }
            else if (player2[i] > player1[i]){
                System.out.println("The score is: " + player1 + "to " + player2 + ". Player 2 wins.");
            }
            else if (player1[i] == player2[i]){
                System.out.println("The score is: " + player1 + "to " + player2 + ". It is a tie.");
            }
        }
    }

    /*
    This portion of the code scans the file and gets the coordinates.
     */

    public static double[][] fileScanner() throws FileNotFoundException {
        String filePath = "/Users/chris/Desktop/coordinates.txt";
        Scanner scan = new Scanner(new File(filePath));
        double dart[][] = new double[30][12];

        while (scan.hasNext()) {
            for (int i = 0; i < 30; i++) {
                for (int j = 0; j < 12; j++) {
                    dart[i][j] = scan.nextDouble();
                }
            }
        }
        fileScoring(dart);
        return dart;
    }
}
