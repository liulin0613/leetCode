package sword_to_offer.t0302.he_wei_sde_liang_ge_shu_zi_lcof;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/he-wei-sde-liang-ge-shu-zi-lcof/
 *
 * Offer 57. 和为s的两个数字
 * 简单
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = {10,26,30,31,47,60};
        int target = 40;

        System.out.println(Arrays.toString(twoSum(nums, target)));
    }

    public static int[] twoSum(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left < right){
            if(nums[left] + nums[right] < target){
                left++;
            }else if(nums[left] + nums[right] > target){
                right--;
            }else {
                return new int[]{nums[left],nums[right]};
            }
        }

        return new int[]{0};
    }
}
