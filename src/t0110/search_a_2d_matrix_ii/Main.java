package t0110.search_a_2d_matrix_ii;

/**
 * https://leetcode-cn.com/problems/search-a-2d-matrix-ii/
 *
 * 240. 搜索二维矩阵 II
 * 中等
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,4,7,11,15},
                {2,5,8,12,19},
                {3,6,9,16,22},
                {10,13,14,17,24},
                {18,21,23,26,30}
        };
        int target = 5;

        System.out.println(searchMatrix(matrix, target));
        System.out.println(searchMatrix2(matrix, target));
    }

    /**
     * 每一行做 二分 时间复杂度 O(mlogn)
     * 6 ms 39.89% 44.1 MB 6.81%
     * @param matrix
     * @param target
     * @return
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0){
            return false;
        }

        for (int[] row : matrix) {
            boolean s = search(row,target);
            if(s){
                return true;
            }
        }

        return false;
    }

    /**
     * z 字形 搜索 从右上角开始
     * 5 ms  97.38%  43.6 MB  78.06%
     * @param matrix
     * @param target
     * @return
     */
    public static boolean searchMatrix2(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0){
            return false;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        int x = 0;
        int y = n - 1;

        while (x < m && y >= 0 ){
            if(matrix[x][y] == target){
                return true;
            }else if(matrix[x][y] > target){
                y = y -1;
            }else {
                x = x + 1;
            }
        }

        return false;
    }



    private static boolean search(int[] row, int target) {
        if(row == null || row.length == 0){
            return false;
        }

        int left = 0;
        int right = row.length-1;

        while (left <= right){

            int mid = left + ((right - left) >> 1);

            if(row[mid] == target){
                return true;
            }else if(row[mid] > target){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }

        return false;
    }
}
