/* Name: Chris Rodriguez
# Date: 12/2/2019
# Class: CSC 1120
# Pledge: I have neither given nor received unauthorized aid on this program.
# Description: Dart game that determines which player wins by using coordinates.
# Input: The user provides a text file that has coordinates for the darts."
# Output: The program will display the winner after several rounds of play.
*/

import java.io.FileNotFoundException;

public class main {
    public static void main(String args[]) throws FileNotFoundException {
        check dartCheck = new check();
        dartCheck.fileScanner();
    }
}
