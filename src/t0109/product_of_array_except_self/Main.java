package t0109.product_of_array_except_self;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/product-of-array-except-self/
 *
 * 238. 除自身以外数组的乘积
 * 中等
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4};

        System.out.println(Arrays.toString(productExceptSelf(nums)));
        System.out.println(Arrays.toString(productExceptSelf2(nums)));
    }

    /**
     * 前缀 后缀和
     * 空间复杂度 为 O(n)
     *
     * 2 ms 46.19%  51.6 MB 9.29%
     *
     * @param nums
     * @return
     */
    public static int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];

        left[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i-1] * nums[i-1];
        }

        right[nums.length-1] = 1;
        for (int length = nums.length-2; length >= 0; length--) {
            right[length] = right[length + 1] * nums[length+1];
        }

        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = left[i] * right[i];
        }

        return res;
    }

    /**
     * 使用 res 优化空间复杂度
     *
     * 1 ms 100.00%  49.3 MB  34.69%
     * @param nums
     * @return
     */
    private static int[] productExceptSelf2(int[] nums) {
        int[] res = new int[nums.length];

        res[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            res[i] = res[i-1] * nums[i-1];
        }

        int right = 1;
        for (int length = nums.length-1; length >= 0; length--) {
            res[length] = res[length] * right;
            right = nums[length]*right;
        }

        return res;
    }
}
