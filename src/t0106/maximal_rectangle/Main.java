package t0106.maximal_rectangle;

import static t0106.largest_rectangle_in_histogram.Main.largestRectangleArea;

/**
 * https://leetcode-cn.com/problems/maximal-rectangle/
 *
 * 85. 最大矩形
 * 困难
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        char[][] matrix = {
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };
        System.out.println(maximalRectangle(matrix));
    }

    public static int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0) return 0;

        int[][] heights = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if(matrix[j][i] == '0'){
                    heights[j][i] = 0;
                }else {
                    if(j>0){
                        heights[j][i] = heights[j-1][i] + 1;
                    }else {
                        heights[j][i] = 1;
                    }
                }
            }
        }

        int max = 0;
        for (int[] height : heights) {
            max = Math.max(largestRectangleArea(height),max);
        }
        return max;
    }

}
