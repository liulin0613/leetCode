package t0111.longest_increasing_subsequence;

/**
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 *
 * 300. 最长递增子序列
 * 中等
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(nums));
    }

    /**
     * 动态规划
     * 52 ms  74.02%  38 MB  67.90%
     * @param nums
     * @return
     */
    public static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];

        int max = 1;
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            int cur = 1;
            for (int j = i-1; j >= 0; j--) {
                if(nums[j] < nums[i]){
                    cur = Math.max(dp[j] + 1 ,cur);
                }
            }

            dp[i] = cur;
            max = Math.max(max,dp[i]);
        }

        return max;
    }
}
