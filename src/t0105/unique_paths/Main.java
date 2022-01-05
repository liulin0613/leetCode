package t0105.unique_paths;

/**
 * https://leetcode-cn.com/problems/unique-paths/
 *
 * 62. 不同路径
 * 中等
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        int m = 19;
        int n = 13;
        System.out.println(uniquePaths(m, n));
        System.out.println(uniquePaths2(m, n));
    }

    /**
     * 动态规划
     * @param m
     * @param n
     * @return
     */
    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        // 上边距设为 1
        for (int i = 0; i < m; ++i) {
            dp[i][0] = 1;
        }

        // 左边距设为 1
        for (int j = 0; j < n; ++j) {
            dp[0][j] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }

    static int result = 0;

    /**
     * 回溯，大数据集超时
     * @param m
     * @param n
     */
    public static int uniquePaths2(int m, int n) {

        boolean[][] used = new boolean[m][n];
        backtrack(0,0,m,n,used);
        return result;
    }

    private static void backtrack(int x, int y, int m, int n, boolean[][] used) {
        if(x == m-1 && y == n-1){
            result++;
            return;
        }

        /**
         * 向右移动
         */
        if(y<n-1 && !used[x][y]){
            used[x][y] = true;
            backtrack(x,y+1,m,n,used);
            used[x][y] = false;
        }

        /**
         * 向下移动
         */
        if(x<m-1 && !used[x][y]){
            used[x][y] = true;
            backtrack(x+1,y,m,n,used);
            used[x][y] = false;
        }

//        /**
//         * 向左移动
//         */
//        if(y>0 && !used[x][y]){
//            used[x][y] = true;
//            backtrack(x,y-1,m,n,used);
//            used[x][y] = false;
//        }
//
//        /**
//         * 向上移动
//         */
//        if(x>0 && !used[x][y]){
//            used[x][y] = true;
//            backtrack(x-1,y,m,n,used);
//            used[x][y] = false;
//        }
    }
}
