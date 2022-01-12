package hot_100.t0105.edit_distance;

/**
 * https://leetcode-cn.com/problems/edit-distance/
 *
 * 72. 编辑距离
 * 困难
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        String word1 = "intention";
        String word2 = "execution";
        System.out.println(minDistance(word1, word2));
    }

    /**
     * 动态规划
     * @param word1
     * @param word2
     * @return
     */
    public static int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        if(n == 0 || m == 0){
            return n == 0 ? m : n;
        }

        int[][] dp = new int[n+1][m+1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if(i == 0) {dp[i][j] = j; continue;}
                if(j == 0) {dp[i][j] = i; continue;}

                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = Math.min(Math.min(dp[i][j-1]+1,dp[i-1][j]+1),dp[i-1][j-1]);
                }else {
                    dp[i][j] = Math.min(Math.min(dp[i][j-1]+1,dp[i-1][j]+1),dp[i-1][j-1] + 1);
                }
            }
        }

        return dp[n][m];
    }
}
