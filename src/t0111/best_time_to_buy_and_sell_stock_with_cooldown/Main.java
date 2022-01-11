package t0111.best_time_to_buy_and_sell_stock_with_cooldown;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 *
 * 最佳买卖股票时机含冷冻期
 * 中等
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        int[] prices = new int[]{1,2,3,0,2};
        System.out.println(maxProfit(prices));
    }

    /**
     * 动态规划
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0){
            return 0;
        }

        int len = prices.length;

        int[][] dp = new int[len][3];

        dp[0][0] = - prices[0]; // 目前持有一支股票
        dp[0][1] = 0;           // 目前不持有任何股票，并且处于冷冻期中
        dp[0][2] = 0;           // 目前不持有任何股票，并且不处于冷冻期中

        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i - 1][2] - prices[i]);
            dp[i][1] = dp[i-1][0] + prices[i];
            dp[i][2] = Math.max(dp[i-1][2],dp[i-1][1]);
        }

        return Math.max(dp[len-1][1],dp[len-1][2]);
    }
}
