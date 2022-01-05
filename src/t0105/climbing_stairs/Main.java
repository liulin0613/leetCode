package t0105.climbing_stairs;

/**
 * https://leetcode-cn.com/problems/climbing-stairs/
 *
 * 70. 爬楼梯
 * 简单
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        int n = 44;
        System.out.println(climbStairs(n));
        System.out.println(climbStairs2(n));
    }

    /**
     * 动态规划
     * @param n
     * @return
     */
    public static int climbStairs(int n) {
        if(n<2){
            return n;
        }
        int[] dp = new int[n+1];
        dp[0] = 1; dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }


    static int count = 0;

    /**
     * 回溯 大数据集超时
     * @param n
     * @return
     */
    public static int climbStairs2(int n) {
        int[] nums = new int[]{1,2};
        backtrack(0,n,nums);
        return count;
    }

    private static void backtrack(int start, int target, int[] nums) {
        if(target == 0){
            count++;
            return;
        }

        if(target<0){
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            backtrack(i,target-nums[i],nums);
        }
    }
}
