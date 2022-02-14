package sword_to_offer.t0214.er_wei_shu_zu_zhong_de_cha_zhao_lcof;

/**
 * https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/
 *
 * 剑指 Offer 04. 二维数组中的查找
 * 中等
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };

//        int[][] matrix = new int[][]{};

        int target = 20;

        System.out.println(findNumberIn2DArray(matrix, target));
    }

    /**
     * O(n+m) 的解法，从最右上角开始逐渐排除一行/一列
     * @param matrix
     * @param target
     * @return
     */
    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix.length == 0){
            return false;
        }

        int x = 0;
        int y = matrix[0].length -1;

        while(x < matrix.length && y>=0){
            if(matrix[x][y] > target){
                y-=1;
            }else if(matrix[x][y] < target){
                x+=1;
            }else {
                return true;
            }
        }

        return false;
    }
}
