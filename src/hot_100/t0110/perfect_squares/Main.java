package hot_100.t0110.perfect_squares;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/perfect-squares/
 *
 * 279. 完全平方数
 * 中等
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        int n = 12;
        System.out.println(numSquares(n));
        System.out.println(numSquares2(n));
    }

    static int min = Integer.MAX_VALUE;

    /**
     * 迭代，超出时间限制
     * @param n
     * @return
     */
    public static int numSquares(int n) {
        List<Integer> nums = new ArrayList<>();

        for (int i = 1; i <= Math.sqrt(n); i++) {
            nums.add(i*i);
        }

        adder(nums,n,0, 0);

        return min;
    }

    /**
     * 动态规划
     * @param n
     * @return
     */
    public static int numSquares2(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j*j <= i; j++) {
               min = Math.min(min,dp[i-j*j]);
            }
            dp[i] = min + 1;
        }

        return dp[n];
    }


    private static void adder(List<Integer> nums, int target, int cur, int count) {
        if(cur == target){
            min = Math.min(min,count);
            return ;
        }

        if(cur > target){
            return;
        }

        for (int size = nums.size()-1; size >= 0; size--) {
            adder(nums,target,cur + nums.get(size),++count);
            count--;
        }
    }
}
