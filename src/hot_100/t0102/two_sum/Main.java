package hot_100.t0102.two_sum;

import java.util.Arrays;
import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/two-sum/
 *
 * 1. 两数之和
 * 简单
 *
 * @author liulin
 */

public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{2,5,5,11};
        int target = 10;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }

    /**
     * hash 表
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int key = target - nums[i];
            if(map.containsKey(key)){
                return new int[]{map.get(key),i};
            }

            map.put(nums[i],i);
        }

        return new int[0];
    }

    /**
     * 暴力枚举
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum2(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }

        return null;
    }
}
