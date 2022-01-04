package t0104.rotate_image;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/rotate-image/
 *
 * 48. 旋转图像
 * 中等
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        int[][] matrix = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
//        int[][] matrix ={{1,2},{3,4}};
        rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

    /**
     * 非原地旋转
     * @param matrix
     */
    public static void rotate2(int[][] matrix) {
        int[][] temp = new int[matrix.length][matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                temp[j][matrix.length-i-1] = matrix[i][j];
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            System.arraycopy(temp[i], 0, matrix[i], 0, matrix.length);
        }
    }

    /**
     * 用翻转代替旋转 先将其通过水平轴翻转,再根据主对角线翻转
     * @param matrix
     */
    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        // 水平轴翻转
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-i-1][j];
                matrix[n-i-1][j] = temp;
            }
        }

        // 主对角线翻转
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
