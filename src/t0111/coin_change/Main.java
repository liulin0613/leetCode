package t0111.coin_change;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/coin-change/
 *
 * 322. 零钱兑换
 * 中等
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        int[] coins = new int[]{186,419,83,408};
        int amount = 6249;

        System.out.println(coinChange2(coins, amount));
    }

    private static int res = Integer.MAX_VALUE;

    /**
     * 回溯，超时
     * @param coins
     * @param amount
     * @return
     */
    public static int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;

        Arrays.sort(coins);

        backtrack(coins,0,amount,0);

        return res == Integer.MAX_VALUE ? -1:res;
    }

    /**
     * 动态规划
     * @param coins
     * @param amount
     * @return
     */
    public static int coinChange2(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp,max);
        dp[0] = 0;

        for (int i = 0; i <= amount; i++) {
            for (int coin : coins) {
                if(coin <= i){
                    dp[i] = Math.min(dp[i],dp[i-coin]+1);
                }
            }
        }

        return dp[amount] < max ? dp[amount] : -1;
    }

    private static boolean backtrack(int[] coins, long current, int amount, int count) {

        if(current == amount){
            res = Math.min(count,res);
            return true;
        }

        if(current > amount){
            return false;
        }

        for (int length = coins.length-1; length >= 0; length--) {
            boolean res = backtrack(coins,current + coins[length],amount,++count);
            count--;
            if(res){
                System.out.println(coins[length]);
                return true;
            }
        }

        return false;
    }
}
