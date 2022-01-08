package t0108.number_of_islands;

/**
 * https://leetcode-cn.com/problems/number-of-islands/
 *
 * 200. 岛屿数量
 * 中等
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        char[][] grid = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };

        System.out.println(numIslands(grid));
    }

    /**
     * 从每个 ‘1’ 开始做深度优先遍历
     *  2 ms  99.79%  46.7 MB 56.15%
     * @param grid
     * @return
     */
    public static int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;

        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == '1'){
                    count++;
                    backtrack(i,j,grid);
                }
            }
        }
        return count;
    }

    private static void backtrack(int i, int j, char[][] grid) {
        int nr = grid.length;
        int nc = grid[0].length;

        if (i < 0 || j < 0 || i >= nr || j >= nc || grid[i][j] == '0') {
            return;
        }

        grid[i][j] = '0';
        backtrack(i - 1, j,grid);
        backtrack(i + 1, j,grid);
        backtrack(i, j - 1,grid);
        backtrack(i, j + 1,grid);
    }
}
