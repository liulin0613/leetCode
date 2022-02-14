package sword_to_offer.t0214.shu_zu_zhong_chong_fu_de_shu_zi_lcof;

import java.util.HashSet;

/**
 * https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
 *
 * 剑指 Offer 03. 数组中重复的数字
 * 简单
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        int[] num = new int[]{2, 3, 1, 0, 4, 5, 3};

        System.out.println(findRepeatNumber2(num));
    }

    /**
     * O（1）的空间复杂度
     * @param nums
     * @return
     */
    private static int findRepeatNumber2(int[] nums) {
        for (int num : nums) {
            int k = num;
            if(k < 0) k = k + nums.length;

            if(nums[k] < 0){
                return k;
            }

            nums[k] -= nums.length;
        }

        return -1;
    }

    public static int findRepeatNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            if(set.contains(num)){
                return num;
            }

            set.add(num);
        }

        return 0;
    }
}
