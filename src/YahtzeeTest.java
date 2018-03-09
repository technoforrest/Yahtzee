/**
 * This program simulates a single player yahtzee game
 * CPSC 224-02, Spring 2018
 * Programming Assignment #5
 *
 * @author Danielle Forrest
 * @version v1.0 3/09/18
 */

import java.util.Arrays;
import java.util.Scanner;

public class YahtzeeTest {


    public static void main(String[] args) {
        final int DICE_IN_PLAY = 5;
        int[] hand = new int[DICE_IN_PLAY];
        char playAgain = 'y';
        Hand game = new Hand(hand);
        Scanner scanner = new Scanner(System.in);


        while (playAgain == 'y') {
            String keep = "nnnnn"; //setup to roll all dice in the first roll
            int turn = 1;
            while (turn < 4 && !keep.equals("yyyyy")) {
                //roll dice not kept
                for (int dieNumber = 0; dieNumber < DICE_IN_PLAY; dieNumber++) {
                    if (keep.charAt(dieNumber) != 'y') {
                        hand[dieNumber] = game.rollDie();
                    }
                }
                //output roll
                System.out.println("Your roll was: ");
                for (int dieNumber = 0; dieNumber < DICE_IN_PLAY; dieNumber++) {
                    System.out.println(hand[dieNumber] + " ");
                }
                System.out.println();
                //if not the last roll of the hand prompt the user for dice to keep
                if (turn < 3) {
                    System.out.println("enter dice to keep (y or n) ");
                    keep = scanner.next();
                }
                turn++;
            }
            //start scoring
            //hand need to be sorted to check for straights
            ScoreCard scoreCard = new ScoreCard(hand);
            game.sortArray(hand, DICE_IN_PLAY);
            System.out.println("Here is your sorted hand : ");
            System.out.println(Arrays.toString(game.getSortArray()) + " ");

            System.out.println();
            scoreCard.upperCard();
            scoreCard.lowerCard();

            System.out.println("Enter 'y' to play again ");
            playAgain = scanner.next().charAt(0);
        }
    }
}