package hot_100.t0113.subarray_sum_equals_k;

import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/subarray-sum-equals-k/
 *
 * 560. 和为 K 的子数组
 * 中等
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1};
        int k = 2;

        System.out.println(subarraySum(nums, k));
        System.out.println(subarraySum2(nums, k));
    }

    /**
     * 前缀和 + 哈希表
     * @param nums
     * @param k
     * @return
     */
    public static int subarraySum(int[] nums, int k) {

        int count = 0, pre = 0;

        HashMap < Integer, Integer > mp = new HashMap<>();
        mp.put(0, 1);

        for (int num : nums) {
            pre += num;
            if (mp.containsKey(pre - k)) {
                count += mp.get(pre - k);
            }
            mp.put(pre, mp.getOrDefault(pre, 0) + 1);
        }

        return count;
    }

    /**
     * 暴力穷举
     * @param nums
     * @param k
     * @return
     */
    public static int subarraySum2(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j >= 0; j--) {
                sum += nums[j];
                if(sum == k){
                    count++;
                }
            }
        }

        return count;
    }
}
