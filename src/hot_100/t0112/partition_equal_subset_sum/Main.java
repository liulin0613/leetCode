package hot_100.t0112.partition_equal_subset_sum;

/**
 * https://leetcode-cn.com/problems/partition-equal-subset-sum/
 *
 * 416. 分割等和子集
 * 中等
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{1,5,11,5};

        System.out.println(canPartition(nums));
    }

    /**
     * https://www.bilibili.com/video/BV1kp4y1e794?from=search&seid=722142665339590717
     *
     * 转化为 0-1 背包问题
     *
     * @param nums
     * @return
     */
    public static boolean canPartition(int[] nums) {
        if (nums.length < 2) {
            return false;
        }

        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            sum += num;
            max = Math.max(max,num);
        }

        if(sum % 2 != 0){
            return false;
        }

        if(max > sum / 2){
            return false;
        }

        int target = sum / 2;

        boolean[] dp = new boolean[target+1];
        dp[0] = true;

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            for (int j = target; j >= num; j--) {
                dp[j] |= dp[j-num];
            }
        }

        return dp[target];
    }
}
