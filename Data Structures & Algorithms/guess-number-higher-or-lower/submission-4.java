/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int min = 1;
        int max = n;

        while (min <= max) {
            int middle = min + (max - min) / 2;
            switch (guess(middle)) {
                case -1:
                    max = middle - 1;
                    break;
                case 1:
                    min = middle + 1;
                    break;
                case 0:
                    return middle;
            }
        }
        return 1;
    }
}