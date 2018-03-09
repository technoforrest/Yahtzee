/**
 * This program simulates a single player yahtzee game
 * CPSC 224-02, Spring 2018
 * Programming Assignment #5
 *
 * @author Danielle Forrest
 * @version v1.0 3/09/18
 */
public class Hand {
    private int hand[];

    Hand(int h[]) {
        hand = h;
    }

    /**
     * this function simulates the rolling of a single die
     * @return random number between 1 and 6
     */
    public int rollDie() {
        return (int) (Math.random() * 6) + 1;
    }

    /**
     * bubble sort from  Gaddis chapter 8
     *
     * @param array the dice values after being rolled
     * @param size the size of the array
     */
    public void sortArray(int array[], int size) {
        boolean swap;
        int temp;

        do {
            swap = false;
            for (int count = 0; count < (size - 1); count++) {
                if (array[count] > array[count + 1]) {
                    temp = array[count];
                    array[count] = array[count + 1];
                    array[count + 1] = temp;
                    swap = true;
                }
            }
        } while (swap);
        hand = array;
    }

    /**
     * @return sorted array of dice values
     */
    public int[] getSortArray() {
        return hand;
    }


}
