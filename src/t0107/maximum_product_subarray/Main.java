package t0107.maximum_product_subarray;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/maximum-product-subarray/
 *
 * 152. 乘积最大子数组
 * 中等
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{-1,-2,-9,-6};
        System.out.println(maxProduct(nums));
    }

    /**
     * 动态规划
     * @param nums
     * @return
     */
    public static int maxProduct(int[] nums) {
        if(nums.length < 1){
            return -1;
        }

        int[] max_dp = new int[nums.length];
        int[] min_dp = new int[nums.length];
        max_dp[0] = nums[0];
        min_dp[0] = nums[0];

        int res = max_dp[0];

        for (int i = 1; i < nums.length; i++) {
            max_dp[i] = Math.max(Math.max(max_dp[i-1]*nums[i],min_dp[i-1]*nums[i]),nums[i]);
            min_dp[i] = Math.min(Math.min(max_dp[i-1]*nums[i],min_dp[i-1]*nums[i]),nums[i]);

            res = Math.max(max_dp[i],res);
        }

        System.out.println(Arrays.toString(max_dp));

        return res;
    }
}
