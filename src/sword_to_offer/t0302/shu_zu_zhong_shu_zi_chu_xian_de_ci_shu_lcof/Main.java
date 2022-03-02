package sword_to_offer.t0302.shu_zu_zhong_shu_zi_chu_xian_de_ci_shu_lcof;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof/
 *
 * 剑指 Offer 56 - I. 数组中数字出现的次数
 * 中等
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = {1,2,10,4,1,4,3,3};

        System.out.println(Arrays.toString(singleNumbers(nums)));
    }

    /**
     * 分组亦或
     * @param nums
     * @return
     */
    public static int[] singleNumbers(int[] nums) {
        int yh = 0;
        for (int num : nums) {
            yh ^= num;
        }

        int dev = 1;
        while ((dev & yh) == 0){
            dev <<= 1;
        }

        int a = 0, b = 0;
        for (int num : nums) {
            if((num & dev) == 0){
                a ^= num;
            }else {
                b ^= num;
            }
        }

        return new int[]{a,b};
    }
}
