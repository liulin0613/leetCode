package t0104.find_first_and_last_position_of_element_in_sorted_array;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 *
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * 中等
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{1};
        int target = 6;
        System.out.println(Arrays.toString(searchRange(nums, target)));
    }


    /**
     * 两次二分
     * @param nums
     * @param target
     * @return
     */
    public static int[] searchRange(int[] nums, int target) {
        if(nums.length<1){
            return new int[]{-1,-1};
        }

        int left = 0;
        int right = nums.length - 1;

        while (left<right){
            int mid = left + ((right - left) >> 2);
            if(nums[mid] < target){
                left = mid +1;
            }else {
                right = mid;
            }
        }

        if(nums[left] != target){
            return new int[]{-1,-1};
        }

        int[] res = new int[2];
        res[0] = left;

        left = 0;
        right = nums.length - 1;

        while (left < right){
            int mid = left + ((right - left) >> 2) + 1;
            if(nums[mid] > target){
                right = mid - 1;
            }else {
                left = mid;
            }
        }

        res[1] = left;

        return res;
    }
}
