package sword_to_offer.t0214.ji_qi_ren_de_yun_dong_fan_wei_lcof;

/**
 * https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/
 *
 * 剑指 Offer 13. 机器人的运动范围
 * 中等
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        int m = 11 , n = 8 , k = 16;
        System.out.println(movingCount(m, n, k));
    }

    public static int movingCount(int m, int n, int k) {
        if(k == 0) return 1;
        boolean[][] used = new boolean[m][n];

        backtrack(0,0,m,n,used,k);

        int count = 0;
        for (boolean[] booleans : used) {
            for (boolean res : booleans) {
                if(res){
                    count++;
                }
            }
        }
        return count;
    }

    private static void backtrack(int x, int y, int m, int n, boolean[][] used, int k) {
        int[][] dist = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};

        for (int[] ints : dist) {
            int newx = x + ints[0];
            int newy = y + ints[1];
            if(newx >= 0 && newx < m && newy >= 0 && newy < n
                    && !used[newx][newy] && computer(newx,newy ) <= k){
                used[newx][newy] = true;
                backtrack(newx,newy,m,n,used,k);
            }
        }
    }

    private static int computer(int m, int n) {
        int sum = 0;
        while (m > 0){
            sum += m % 10;
            m /= 10;
        }

        while (n > 0){
            sum += n % 10;
            n /= 10;
        }

        return sum;
    }
}
