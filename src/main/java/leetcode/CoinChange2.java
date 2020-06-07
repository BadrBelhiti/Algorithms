package leetcode;

import java.util.Arrays;

public class CoinChange2 {

    private int[][] dp;

    public int change(int amount, int[] coins) {
        this.dp = new int[amount + 1][coins.length + 1];

        for (int[] row : dp){
            Arrays.fill(row, -1);
        }

        return recur(amount, coins, 0);
    }

    public int recur(int amount, int[] coins, int start){

        if (amount == 0){
            return 1;
        }

        if (dp[amount][start] != -1){
            return dp[amount][start];
        }

        int sum = 0;

        for (int i = start; i < coins.length; i++){
            if (coins[i] == amount){
                sum++;
            } else if (coins[i] < amount){
                sum+= recur(amount - coins[i], coins, i);
            }
        }

        dp[amount][start] = sum;
        return sum;
    }

}
