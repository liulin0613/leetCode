package sword_to_offer.t0215.shun_shi_zhen_da_yin_ju_zhen_lcof;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/
 *
 * 剑指 Offer 29. 顺时针打印矩阵
 * 简单
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12}
        };

        System.out.println(Arrays.toString(spiralOrder(matrix)));
    }

    public static int[] spiralOrder(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return new int[]{};
        }

        int m = matrix.length;
        int n = matrix[0].length;

        int index = 0;
        int sum = m * n;
        int[] order = new int[sum];

        int left = 0,top = 0, right = n-1, bottom = m-1;

        while (left <= right && top <= bottom){
            for(int col = left; col <= right ; col++){
                order[index++] = matrix[top][col];
            }

            for(int row = top + 1; row <= bottom ; row++){
                order[index++] = matrix[row][right];
            }

            if(left < right && top < bottom){
                for(int col = right - 1; col > left; col--){
                    order[index++] = matrix[bottom][col];
                }

                for(int row = bottom; row > top; row--){
                    order[index++] = matrix[row][left];
                }
            }

            left++;
            right--;
            top++;
            bottom--;
        }


        return order;
    }
}
