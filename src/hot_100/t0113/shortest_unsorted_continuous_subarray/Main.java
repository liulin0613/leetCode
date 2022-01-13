package hot_100.t0113.shortest_unsorted_continuous_subarray;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray/
 *
 * 581. 最短无序连续子数组
 * 中等
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{2,6,4,8,10,9,15};

        System.out.println(findUnsortedSubarray(nums));
        System.out.println(findUnsortedSubarray2(nums));
    }

    /**
     * 数组 复制 + 排序
     * @param nums
     * @return
     */
    public static int findUnsortedSubarray(int[] nums) {
        int[] nums_copy = new int[nums.length];

        System.arraycopy(nums,0,nums_copy,0,nums.length);
        Arrays.sort(nums_copy);

        int left = 0;
        for (int i = 0; i < nums_copy.length; i++) {
            if (nums[i] != nums_copy[i]){
                left = i;
                break;
            }
        }

        int right = -1;
        for (int j = nums_copy.length - 1; j >= 0; j--) {
            if (nums[j] != nums_copy[j]){
                right = j;
                break;
            }
        }

        return right - left + 1;
    }

    /**
     * 一次遍历
     * [1,3,2,2,2]
     * @param nums
     * @return
     */
    public static int findUnsortedSubarray2(int[] nums) {
        int left = -1, right = - 1;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if(max > nums[i]){
                right = i;
            }else {
                max = nums[i];
            }

            if(min < nums[n-i-1]){
                left = n-i-1;
            }else {
                min = nums[n-i-1];
            }
        }

        return right == -1 ? 0 : right - left + 1;
    }
}
