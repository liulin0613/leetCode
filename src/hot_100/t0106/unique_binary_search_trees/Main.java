package hot_100.t0106.unique_binary_search_trees;

/**
 * https://leetcode-cn.com/problems/unique-binary-search-trees/
 *
 * 96. 不同的二叉搜索树
 * 中等
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        int n = 19;
        System.out.println(numTrees(n));
        System.out.println(numTrees2(n));
    }

    /**
     * 动态规划
     *
     * F(i,n) = G(i−1) ⋅ G(n−i)     ........ 1
     *
     *      i=1
     * G(n)= ∑ F(i,n)               ........ 2
     *       n
     *
     *                 1，2 得
     *
     *       n
     * G(n)= ∑ G(i−1)⋅ G(n−i)       ........ 3
     *      i=1
     *
     * @param n
     * @return
     */
    public static int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j-1] * dp[i-j];
            }
        }

        return dp[n];
    }

    /**
     * 数学
     *                      2(2n+1)
     * C_0 =1 , C_{n+1} =  ———————— C_n
     *                        n+2
     *
     * @param n
     * @return
     */
    public static int numTrees2(int n) {
        long C = 1; // long 防止溢出
        for (int i = 0; i < n; ++i) {
            C = C * 2 * (2 * i + 1) / (i + 2);
        }
        return (int) C;
    }
}
