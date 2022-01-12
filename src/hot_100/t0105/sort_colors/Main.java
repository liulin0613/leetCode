package hot_100.t0105.sort_colors;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/sort-colors/
 *
 * 75. 颜色分类
 * 中等
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{1,0,0};
        sortColors2(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 个人题解 双指针 0ms 36.8M
     * @param nums
     */
    public static void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        int temp;
        while (left<right){
            while (left < right && nums[right] != 0) right--;
            while (left < right && nums[left] == 0) left++;

            if(left < right){
                temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }

            if(left+1<right){
                left++;
                right--;
            }
        }

        left = 0;
        right = nums.length - 1;
        while (left<right){
            while (left < right && nums[right] != 1) right--;
            while (left < right && nums[left] != 2) left++;

            if(left < right){
                temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }

            left++;
            right--;
        }
    }

    /**
     * 官方题解 双指针 0ms 37.1M
     * @param nums
     */
    public static void sortColors2(int[] nums){
        int n = nums.length;
        int p0 = 0;
        int p2 = n-1;

        for (int i = 0; i <= p2; i++) {
            while (i < p2 && nums[i] == 2){
                int temp = nums[i];
                nums[i] = nums[p2];
                nums[p2] = temp;

                p2--;
            }

            if(nums[i] == 0){
                int temp = nums[i];
                nums[i] = nums[p0];
                nums[p0] = temp;

                p0++;
            }
        }
    }
}
