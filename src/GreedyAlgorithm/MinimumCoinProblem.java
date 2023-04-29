package GreedyAlgorithm;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;

import static java.lang.Math.floor;

public class MinimumCoinProblem {
    public static void main(String[] args) {

    }

    public static int MinimumCoin(Integer coins[], int n, int amount) {

        int result = 0;
        Arrays.sort(coins, Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            if (coins[i] < amount) {
                int c = (int) Math.floor(amount / coins[i]);
                result = result + c;
                amount = amount - c * coins[i];
            }

            if (amount == 0) {
                break;
            }


        }
        return result;
    }
}
