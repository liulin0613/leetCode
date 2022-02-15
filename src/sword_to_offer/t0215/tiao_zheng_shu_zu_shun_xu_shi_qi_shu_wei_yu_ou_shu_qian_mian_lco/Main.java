package sword_to_offer.t0215.tiao_zheng_shu_zu_shun_xu_shi_qi_shu_wei_yu_ou_shu_qian_mian_lco;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/
 *
 * 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
 * 简单
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7,8,9,0,1,2,3,4,5,6,7,8,9};
//        System.out.println(Arrays.toString(exchange(nums)));
        System.out.println(Arrays.toString(exchange2(nums)));
    }

    private static int[] exchange2(int[] nums) {
        int p1=0,p2=0;
        for (int num : nums) {
            if(num % 2 == 1){
                nums[p2++] = nums[p1];
                nums[p1++] = num;
            }else {
                nums[p2++] = num;
            }
        }

        return nums;
    }

    public static int[] exchange(int[] nums) {
        int p1 = 0, p2 = nums.length - 1;
        while (p1 < p2){
            while (p1 < p2 && nums[p1] % 2 == 1){
                p1++;
            }

            while (p1 < p2 && nums[p2] % 2 == 0){
                p2--;
            }

            if(p1 < p2){
                int temp = nums[p1];
                nums[p1] = nums[p2];
                nums[p2] = temp;
            }
        }

        return nums;
    }
}
