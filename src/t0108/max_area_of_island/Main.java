package t0108.max_area_of_island;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/max-area-of-island/
 *
 * 695. 岛屿的最大面积
 * 中等
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        int[][] grid = {
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}
        };

        System.out.println(maxAreaOfIsland(grid));
    }

    static int max = 0;
    static int count = 0;

    /**
     * dfs
     * 2 ms  99.75%  39.3 MB  5.04%
     * @param grid
     * @return
     */
    public static int maxAreaOfIsland(int[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == 1){
                    count = 0;
                    backtrack(i,j,m,n,grid);
                }
            }
        }

        // 如果要复原数组，将其中的 2 变为 1 即可
        System.out.println(Arrays.deepToString(grid));

        return max;
    }

    private static void backtrack(int i, int j, int m, int n, int[][] grid) {
        if(i<0 || j<0 || i>=m || j>=n || grid[i][j] == 0 || grid[i][j] == 2){

            return;
        }

        grid[i][j] = 2;
        count++;

        backtrack(i+1,j,m,n,grid);
        backtrack(i,j+1,m,n,grid);
        backtrack(i-1,j,m,n,grid);
        backtrack(i,j-1,m,n,grid);

        max = Math.max(max,count);
    }
}
