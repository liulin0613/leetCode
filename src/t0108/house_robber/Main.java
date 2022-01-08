package t0108.house_robber;

/**
 * https://leetcode-cn.com/problems/house-robber/
 *
 * 198. 打家劫舍
 * 中等
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{2,7,9,3,1,5};
        System.out.println(rob(nums));
        System.out.println(rob2(nums));
    }

    /**
     * 动态规划
     * 0 ms 100.00%  35.9 MB  33.53%
     * @param nums
     * @return
     */
    public static int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }

        if(nums.length == 2){
            return Math.max(nums[0],nums[1]);
        }

        if(nums.length == 3){
            return  Math.max(nums[0] + nums[2],nums[1]);
        }

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = nums[1];
        dp[2] = nums[0] + nums[2];

        for (int i = 3; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-2],dp[i-3]) + nums[i];
        }

        return Math.max(dp[nums.length - 1],dp[nums.length - 2]);
    }

    /**
     * 官方解答
     * 动态规划 + 滚动数组
     * 偷 or 不偷 ？
     * 偷 --> dp[i] = dp[i-2] + nums[i]
     * 不偷 --> dp[i] = dp[i-1]
     *
     * 0 ms 100.00%  35.9 MB  28.54%
     *
     * @param nums
     * @return
     */
    public static int rob2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        int[] dp = new int[length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[length - 1];
    }

}
