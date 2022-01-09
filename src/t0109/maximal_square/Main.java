package t0109.maximal_square;

/**
 * https://leetcode-cn.com/problems/maximal-square/
 *
 * 221. 最大正方形
 * 中等
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        char[][] matrix = {
                {'1'}

//                {'0','1'},
//                {'1','0'}

//                {'1','0','1','0','0'},
//                {'1','0','1','1','1'},
//                {'1','1','1','1','1'},
//                {'1','0','0','1','0'},
        };

        System.out.println(maximalSquare(matrix));
    }

    /**
     * 动态规划
     * @param matrix
     * @return
     */
    public static int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0){
            return 0;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        int max = 0;

        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = matrix[i][0]  - '0';
            max = Math.max(max,dp[i][0]);
        }

        for (int i = 0; i < n; i++) {
            dp[0][i] = matrix[0][i] - '0';
            max = Math.max(max,dp[0][i]);
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if(matrix[i][j] == '1'){
                    dp[i][j] = Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1]) + 1;
                    max = Math.max(max,dp[i][j]);
                }else {
                    dp[i][j] = 0;
                }

            }
        }

        return max * max;
    }
}
