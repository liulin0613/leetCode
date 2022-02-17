package sword_to_offer.t0217.lian_xu_zi_shu_zu_de_zui_da_he_lcof;

/**
 * https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/
 *
 * 剑指 Offer 42. 连续子数组的最大和
 * 简单
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = {-2,3};

        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        int sum = nums[0];
        int max = sum;

        for(int i = 1; i< nums.length; i++){
            sum = Math.max(sum + nums[i],nums[i]);
            max = Math.max(max,sum);
        }

        return max;
    }
}
