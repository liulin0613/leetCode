package hot_100.t0103.next_permutation;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/next-permutation/
 *
 * 31. 下一个排列
 * 中等
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1};
        nextPermutation(nums);
    }

    public static void nextPermutation(int[] nums) {
        if(nums.length<=1){
            System.out.println(Arrays.toString(nums));
            return;
        }
        boolean hasNext = hasNextPermutation(nums);
        if(hasNext){
            getNextPermutation(nums);
        }else {
            reverseArray(nums,0,nums.length-1);
        }
        System.out.println(Arrays.toString(nums));
    }

    private static boolean hasNextPermutation(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] > nums[i-1]){
                return true;
            }
        }
        return false;
    }

    private static void getNextPermutation(int[] nums) {
        int len = nums.length-1;
        int target=-1;
        for (int i = len; i > 0; i--) {
            if(nums[i] > nums[i-1]){
                target = i-1;
                break;
            }
        }

        for (int i = len; i > target; i--) {
            if(nums[i] <= nums[target+1] && nums[i] > nums[target]){
                swap(nums,i,target);
                break;
            }
        }

        reverseArray(nums,target+1,nums.length-1);
    }

    private static void reverseArray(int[] nums,int left,int right) {
        while (left<right){
            swap(nums,left,right);
            left++;
            right--;
        }
    }

    private static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
