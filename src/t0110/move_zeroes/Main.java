package t0110.move_zeroes;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/move-zeroes/
 *
 * 283. 移动零
 * 简单
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,3,12};

        moveZeroes3(nums);

        System.out.println(Arrays.toString(nums));
    }

    /**
     * 插入法
     * 32 ms 10.18%  39.1 MB 97.74%
     * @param nums
     */
    public static void moveZeroes(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] != 0){
                int j;
                for (j = i; j > 0;) {
                    if(nums[j-1] == 0){
                        j--;
                    }else {
                        break;
                    }
                }

                if(j != i){
                    nums[j] = nums[i];
                    nums[i] = 0;
                }
            }
        }
    }

    /**
     * 双指针
     * 2 ms  60.03%  39.5 MB 78.52%
     * @param nums
     */
    public static void moveZeroes2(int[] nums) {
        int len = nums.length;
        int left = 0;
        int right = 0;

        while (right < len){
            if(nums[right] != 0){
                if(left != right){
                    nums[left] = nums[right];
                    nums[right] = 0;
                }

                left++;
            }
            right++;
        }
    }

    /**
     * 填充 0
     * 1 ms 100.00%  39.2 MB  96.80%
     * @param nums
     */
    public static void moveZeroes3(int[] nums) {
        int index = 0;
        for (int num : nums) {
            if(num != 0){
                nums[index++] = num;
            }
        }

        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
