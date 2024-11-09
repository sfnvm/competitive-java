package edu.sfnvm.competitive.dynamic_programming;

import java.util.Arrays;

public class CoinProblem {

  public static void main(String[] args) {
    System.out.println(Arrays.toString(minimumCoins(new int[]{1, 2, 3}, 9)));
  }

  public static int[] minimumCoins(int[] coins, int amount) {
    if (amount <= 0) {
      return new int[0];
    }

    int[] answer = new int[coins.length];
    for (int i = 0; i < coins.length; i++) {
      answer = new int[coins.length];
      int subAmount = amount - coins[i];
      if (subAmount < 0) {
        continue;
      }
      answer[i] += 1;
      answer = minimumCoins(coins, subAmount);
    }

    return answer;
  }
}
