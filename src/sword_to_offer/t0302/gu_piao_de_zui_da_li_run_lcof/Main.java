package sword_to_offer.t0302.gu_piao_de_zui_da_li_run_lcof;

/**
 * https://leetcode-cn.com/problems/gu-piao-de-zui-da-li-run-lcof/
 *
 * 剑指 Offer 63. 股票的最大利润
 * 中等
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        int[] prices = {7,6,1,5,5,4,8};

        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        if(prices.length <= 1) return 0;

        int res = 0 , len = prices.length;
        int max = prices[len - 1];

        for (int i = len - 2; i >= 0; i--) {
            res = Math.max(res,max - prices[i]);
            max = Math.max(max,prices[i]);
        }

        return res;
    }
}
