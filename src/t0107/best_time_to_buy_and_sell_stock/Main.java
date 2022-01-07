package t0107.best_time_to_buy_and_sell_stock;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 *
 * 121. 买卖股票的最佳时机
 * 简单
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        int[] prices = new int[]{7,6,4,3,1};
        System.out.println(maxProfit(prices));
    }

    /**
     * 动态规划
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int maxP = 0;

        int[] dp = new int[n];
        dp[n-1] = prices[n-1];

        for (int i = n-2; i >= 0; i--) {
            dp[i] = Math.max(dp[i+1],prices[i]);
            maxP = Math.max(maxP,dp[i] - prices[i]);
        }

        return maxP;
    }
}
