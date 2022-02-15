package sword_to_offer.t0215.jian_sheng_zi_lcof;

/**
 * https://leetcode-cn.com/problems/jian-sheng-zi-lcof/
 *
 * 剑指 Offer 14- I. 剪绳子
 * 中等
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        int n = 59;
        System.out.println(cuttingRope(n));
        System.out.println(cuttingRope2(n));
    }

    /**
     * 贪心算法
     * @param n
     * @return
     */
    private static int cuttingRope2(int n) {
        if(n == 2) return 1;
        if(n == 3) return 2;
        if(n == 4) return 4;

        int res = 1;
        while (n > 4){
            res *= 3;
            n -= 3;
        }

        return res * n;
    }

    /**
     * 动态规划
     * @param n
     * @return
     */
    public static int cuttingRope(int n) {
        int[] dp = new int[n+1];
        dp[2] = 1;
        for(int i = 3;i <= n; i++){
            for(int j = i-1;j >= 2; j--){
                dp[i] = Math.max(dp[i],Math.max(j*(i-j),j*dp[i-j]));
            }
        }

        return dp[n];
    }
}
