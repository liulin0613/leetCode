package t0104.maximum_subarray;

/**
 * https://leetcode-cn.com/problems/maximum-subarray/
 *
 * 53. 最大子数组和
 * 简单
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{1};
        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        int max = nums[0];
        int res = nums[0];

        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max + nums[i],nums[i]);
            res = Math.max(res,max);
        }

        return res;
    }
}
