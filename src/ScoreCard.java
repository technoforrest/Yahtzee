/**
 * This program simulates a single player yahtzee game
 * CPSC 224-02, Spring 2018
 * Programming Assignment #5
 *
 * @author Danielle Forrest
 * @version v1.0 3/09/18
 */

public class ScoreCard {
    private int hand[];

    ScoreCard(int[] h) {

        hand = h;
    }

    /**
     * this function returns the count of the die value occurring most in the hand
     * but not the value itself
     *
     * @param h contains array of dice values
     * @return returns the sum of the highest value dice
     */
    private int maxOfAKindFound(int h[]) {
        int maxCount = 0;
        int currentCount;
        for (int dieValue = 1; dieValue <= 6; dieValue++) {
            currentCount = 0;
            for (int diePosition = 0; diePosition < 5; diePosition++) {
                if (h[diePosition] == dieValue)
                    currentCount++;
            }
            if (currentCount > maxCount)
                maxCount = currentCount;
        }
        return maxCount;
    }

    /**
     * this function returns the total value of all dice in a hand
     *
     * @param h contains array of dice values
     * @return sum of dice values
     */
    private int totalAllDice(int h[]) {
        int total = 0;
        for (int diePosition = 0; diePosition < 5; diePosition++) {
            total += h[diePosition];
        }
        return total;
    }

    /**
     * this function returns the length of the longest
     * straight found in a hand
     *
     * @param h  contains array of dice values
     * @return number of dice following straight pattern
     */
    private int maxStraightFound(int h[]) {
        int maxLength = 1;
        int curLength = 1;
        for (int counter = 0; counter < 4; counter++) {
            if (h[counter] + 1 == h[counter + 1]) //jump of 1
                curLength++;
            else if (h[counter] + 1 < h[counter + 1]) //jump of >= 2
                curLength = 1;
            if (curLength > maxLength)
                maxLength = curLength;
        }
        return maxLength;
    }

    /**
     * this function returns true if the hand is a full house
     * or false if it does not
     *
     * @param h contains array of dice values
     * @return true if full house is found, false if not
     */
    private boolean fullHouseFound(int h[]) {
        boolean foundFH = false;
        boolean found3K = false;
        boolean found2K = false;
        int currentCount;
        for (int dieValue = 1; dieValue <= 6; dieValue++) {
            currentCount = 0;
            for (int diePosition = 0; diePosition < 5; diePosition++) {
                if (h[diePosition] == dieValue)
                    currentCount++;
            }
            if (currentCount == 2)
                found2K = true;
            if (currentCount == 3)
                found3K = true;
        }
        if (found2K && found3K)
            foundFH = true;
        return foundFH;
    }

    /**
     * Prints the upper section of score card
     */
    public void upperCard() {
        for (int dieValue = 1; dieValue <= 6; dieValue++) {
            int currentCount = 0;
            for (int diePosition = 0; diePosition < 5; diePosition++) {
                if (hand[diePosition] == dieValue)
                    currentCount++;
            }
            System.out.print("Score " + dieValue * currentCount + " on the ");
            System.out.println(dieValue + " line");
        }
    }

    /**
     * Prints the lower portion of scorecard
     */
    public void lowerCard() {
        if (maxOfAKindFound(hand) >= 3) {
            System.out.print("Score " + totalAllDice(hand) + " on the ");
            System.out.println("3 of a Kind line");
        } else System.out.println("Score 0 on the 3 of a Kind line");

        if (maxOfAKindFound(hand) >= 4) {
            System.out.print("Score " + totalAllDice(hand) + " on the ");
            System.out.println("4 of a Kind line");
        } else System.out.println("Score 0 on the 4 of a Kind line");

        if (fullHouseFound(hand))
            System.out.println("Score 25 on the Full House line");
        else
            System.out.println("Score 0 on the Full House line");

        if (maxStraightFound(hand) >= 4)
            System.out.println("Score 30 on the Small Straight line");
        else
            System.out.println("Score 0 on the Small Straight line");

        if (maxStraightFound(hand) >= 5)
            System.out.println("Score 40 on the Large Straight line");
        else
            System.out.println("Score 0 on the Large Straight line");

        if (maxOfAKindFound(hand) >= 5)
            System.out.println("Score 50 on the Yahtzee line");
        else
            System.out.println("Score 0 on the Yahtzee line");

        System.out.println("Score " + totalAllDice(hand) + " on the ");
        System.out.println("Chance line");

    }

}

